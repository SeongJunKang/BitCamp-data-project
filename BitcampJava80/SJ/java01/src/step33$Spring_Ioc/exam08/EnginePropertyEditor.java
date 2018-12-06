/* 문자열을 Engine 객체를 생성하는 변환기 만들기.*/
package step33$Spring_Ioc.exam08;

import java.beans.PropertyEditorSupport;

public class EnginePropertyEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    Engine engine = new Engine();
    String[] specs = text.split(",");
    try {
      if (specs.length < 3 || specs == null)
        throw new Exception("Engine 타입에 맞지 않습니다.");
    } catch (Exception e) {
    }
    engine.setCc(Integer.parseInt(specs[0]));
    engine.setValve(Integer.parseInt(specs[1]));
    engine.setType(specs[2]);
    this.setValue(engine);
  }
}
