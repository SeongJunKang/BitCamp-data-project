package bitcamp.pms.context;

import java.util.*;
import java.io.*;

import bitcamp.pms.annotation.Component;

public class ApplicationContext {

  HashMap<String,Object> objPool = new HashMap<>();

  public ApplicationContext(String basePackage) {
    String path = "./bin/"+basePackage.replace(".","/");
    createObject(new File(path));
  }


  public void createObject(File file) {

    if(file.isFile() && file.getName().endsWith(".class")) {
      String classPath = file.getPath()
      .replace("./bin/","")
      .replace(".class","")
      .replace("/",".");
      try {
        Class<?> clazz = Class.forName(classPath);
        Component anno = clazz.getAnnotation(Component.class);
        if(anno != null) {
          Object obj = clazz.newInstance();
          objPool.put(anno.value(),obj);
        }
      } catch (Exception e) {
      }
      return;
    }

      File[] filelist = file.listFiles();
      for (File files : filelist ) {
        createObject(files);
      }
  }

  public List<Object> getBeans(Class<?> beanType) {
    ArrayList<Object> list = new ArrayList<>();
    Collection<Object> objects = objPool.values();

    for (Object obj : objects) {
      if (beanType.isInstance(obj)) {

        list.add(obj);
      }
    }
    return list;

  }

  public Object getBean(String name) {
    return objPool.get(name);
  }











}
