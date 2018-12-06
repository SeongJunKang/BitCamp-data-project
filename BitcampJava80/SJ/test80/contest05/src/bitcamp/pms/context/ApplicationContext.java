package bitcamp.pms.context;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;

public class ApplicationContext { 

  HashMap<String, Object> objPool = new HashMap<>();

  public ApplicationContext(String base) {
    String path = "./bin/" + base.replace(".", "/");
    createObject(new File(path));
    injection();
    
  }

  private void createObject(File file) {
    if (file.isFile() && file.getName().endsWith(".class")) {
      
      String path = file.getPath().replace(".class", "").replace("./bin/", "").replace("/", ".");
      try {
        
        Class<?> clazz= Class.forName(path);
        
        if (clazz.getAnnotation(Component.class) != null || clazz.getAnnotation(Controller.class) != null) {
          objPool.put(clazz.getName(), clazz.newInstance());
        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
        return;



    }
    File[] files = file.listFiles();
    for (File f : files) {
      createObject(f);
    }
  }

  private void injection() {
    Object dependence = null;
    for (Object obj : objPool.values()) {
      for (Method m : obj.getClass().getMethods()) {
        if (!m.getName().startsWith("set")) {
          continue;
        }
        dependence = getBean(m.getParameterTypes()[0]);
        if (dependence == null) {
          continue;
        }
        try {
          m.invoke(obj, dependence);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public Object getBean(Class<?> clazz) {
    try {
      for (Object obj : objPool.values()) {
        if (clazz.isInstance(obj)) {
          return obj;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void addBean(String key, Object bean) {
    objPool.put(key, bean);
  }

  public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> type) {
    HashMap<String, Object> map = new HashMap<>();

    for (Object obj : ob0jPool.values()) {
      if (obj.getClass().getAnnotation(type) == null) {
        continue;
      }
      map.put(obj.getClass().getName(), obj);
    }
    return map;
  }

}