// 주제: 문자열로 Engine 객체를 생성하는 변환기 만들기
package step33.exam08;

import java.beans.PropertyEditorSupport;

public class EnginePropertyEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    try {
      String[] items = text.split(",");
      if (items == null || items.length < 3) 
        throw new Exception("Engine 타입에 맞지 않는 값입니다.");
      
      Engine engine = new Engine();
      engine.setCc(Integer.parseInt(items[0]));
      engine.setValve(Integer.parseInt(items[1]));
      engine.setType(items[2]);
      
      this.setValue(engine);

    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }
}







