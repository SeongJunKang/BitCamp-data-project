package bitcamp.pms.context;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;

public class ApplicationContext {
  private HashMap<String, Object> objPool = new HashMap<>();

  public ApplicationContext(String basePackage) {
    String path = "./bin/" + basePackage.replace(".", "/");
    createObject(new File(path));
    injectDependency();
  }

  private void injectDependency() {
    Object dependency = null;
    Class<?> clazz = null;
    Class<?> paramType = null;
    for (Object obj : objPool.values()) {
      clazz = obj.getClass();
      if (!clazz.isAnnotationPresent(Component.class) && !clazz.isAnnotationPresent(Controller.class)) {
        continue;
      }
      for (Method m : clazz.getMethods()) {
        if (!m.getName().startsWith("set")) {
          continue;
        }
        paramType = m.getParameterTypes()[0];
        dependency = getBean(paramType);
        if (dependency == null) {
          continue;
        }

        try {
          m.invoke(obj, dependency);
        } catch (Exception e) {
        }
      }
    }
  }

  private void createObject(File file) {
    if (file.isFile() && file.getName().endsWith(".class")) {
      String classNameWithPackage = file.getPath().replace("./bin/", "").replace(".class", "").replace("/", ".");
      try {
        Class<?> clazz = Class.forName(classNameWithPackage);
        if (clazz.getAnnotation(Component.class) != null) {
          processComponentAnnotation(clazz);
        } else if (clazz.getAnnotation(Controller.class) != null) {
          processControllerAnnotation(clazz);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return;
    }
    if (!file.isDirectory()) {
      return;
    }
    File[] fileList = file.listFiles();
    for (File files : fileList) {
      createObject(files);

    }
  }

  private void processControllerAnnotation(Class<?> clazz) throws Exception {
    String key = clazz.getAnnotation(Controller.class).value();
    if (key.equals("")) {
      key = clazz.getName();
    }
    objPool.put(key, clazz.newInstance());
  }

  private void processComponentAnnotation(Class<?> clazz) throws Exception {
    Component anno = clazz.getAnnotation(Component.class);
    String key = anno.value();
    if (key.equals("")) {
      key = clazz.getName();
    }
    objPool.put(key, clazz.newInstance());
  }

  public Object getBean(Class<?> paramType) {
    for (Object obj : objPool.values()) {
      if (paramType.isInstance(obj)) {
        return obj;
      }
    }
    return null;
  }

  public void addBean(String name, Object bean) {
    objPool.put(name, bean);
    injectDependency();
  }

  public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annoType) {
    Set<Entry<String, Object>> entrySet = objPool.entrySet();
    HashMap<String, Object> objMap = new HashMap<>();
    Object obj = null;
    for (Entry<String, Object> entry : entrySet) {
      obj = entry.getValue();
      if (obj.getClass().getAnnotation(annoType) == null) {
        continue;
      }
      objMap.put(entry.getKey(), obj);
    }
    return objMap;
  }

}
