package step27.exam07;

public class Test {

  public static void main(String[] args) {
    //Class<?> clazz = Member.class;
    Class<?> clazz = Member2.class;
    Component anno = clazz.getAnnotation(Component.class);
    String[] list = anno.value();
    
    for (String s : list) {
      System.out.println(s);
    }

  }

}






