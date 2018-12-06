// 주제: 문자열로 java.util.Date 객체를 생성하는 변환기 만들기
// => java.beans.PropertyEditor 인터페이스를 구현하면 된다.
// => 그러나 인터페이스를 구현하는 것은 너무 번거롭다.
// => PropertyEditor를 미리 구현한 PropertyEditorSupport 클래스를 상속 받아라.
package step33.exam08;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

public class DatePropertyEditor extends PropertyEditorSupport {
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    try {
      this.setValue(simpleDateFormat.parse(text));
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }
}







