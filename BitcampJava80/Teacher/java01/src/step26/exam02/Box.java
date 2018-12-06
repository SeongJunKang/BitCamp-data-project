// 제네릭(Generic) 적용
// => 타입 이름을 받을 변수를 지정한다.
package step26.exam02;

public class Box<T> {
  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
