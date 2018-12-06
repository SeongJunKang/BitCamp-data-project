/* Responsibility(or Role)
 * 객체를 준비하고 관리한다. --> "bean container(빈 컨테이너)"라 부른다.
 * 객체 -->  "bean" 이라고 부른다.
 * 관리하는 클래스를 보통 "컨테이너(container)" 라고 부른다.
 */
package bitcamp.pms.context;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ApplicationContext {
  HashMap<String,Object> objPool = new HashMap<>();
  
  public ApplicationContext(String basePackage) {
    prepareObject(basePackage);
  }
  private void prepareObject(String packageName) {
    // TODO Auto-generated method stub
    String path ="./bin/"+packageName.replace(".", "/");
    File dir = new File(path);
    File[] fileList = dir.listFiles();
    for (File file : fileList) {
      if (file.isFile() && file.getName().endsWith(".class")) {
        String classNameWithPackage = file.getPath()
            .replace("./bin/","")
            .replace(".class","")
            .replace("/",".");
        try {
          Class<?> clazz = Class.forName(classNameWithPackage);
          
          if (!clazz.isInterface()) {
            Object obj = clazz.newInstance();
            objPool.put(obj.toString(), obj);
            }
       } catch (Exception e) {
           e.printStackTrace();     
        } 
     }
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
