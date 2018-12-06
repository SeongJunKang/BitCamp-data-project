/*
 * 용도
 * appcontext가 관리하는 객체 중에서 명령을 처리하는 메서드 정보를
 * 따로 보관하여 관리한다.
 * projectApp은 명령어를 처리할 때 이 클래스를 통해 메서드 정보를 얻어서 
 * 해당 메서드를 호출.
 */
package bitcamp.pms.context.request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.context.ApplicationContext;

public class RequestHandlerMapping {
  ApplicationContext appContext;
  HashMap<String,RequestHandler> handlerMap = new HashMap<>();
  public RequestHandlerMapping(ApplicationContext appContext) {
    this.appContext = appContext;
    
    //1) ApplicationContext를 통해 @Controller 가 붙은 객체를 꺼낸다.
    Map<String,Object> controllersMap =
        appContext.getBeansWithAnnotation(Controller.class);
    
    //2) 각 객체에서 @RequestMapping이 붙은 메서드를 꺼낸다.    
    Method[] methods = null;
    RequestMapping anno = null;
    RequestMapping classanno = null;
    String baseName = null;
    for (Object controller : controllersMap.values()) {
      classanno = controller.getClass().getAnnotation(RequestMapping.class);
      if (classanno != null) {
        baseName = classanno.value();
      } else {
        baseName = "";
      }
      
      methods = controller.getClass().getMethods();

      for(Method method : methods) {
        anno = method.getAnnotation(RequestMapping.class);
        if(anno == null) {
          continue;
        }
      //3) RequestHandler 객체에 메서드와 객체 정보를 저장.
      //4) requestMap에 requestHandler 객체 보관.
        handlerMap.put(baseName + anno.value(), new RequestHandler(method,controller));
//        System.out.printf("%s --> %s\n",
//            controller.getClass().getName(),method.getName());
      } 

    }
    
    

  }
  public RequestHandler getRequestHandler(String name) {

    return handlerMap.get(name);
  }
  
  
}
