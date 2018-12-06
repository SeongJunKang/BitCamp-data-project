//제네릭 적용하기.
package step26$Generic.exam02;

public class Box<T> {
  private T value;

  public T getValue() {
    return value;
  }
  public void setValue(T value) {
    this.value = value;
  }
  
}
