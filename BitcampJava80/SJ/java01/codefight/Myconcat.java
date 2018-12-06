public class Myconcat{
  public static void main(String[] args){

    String[] arguments = new String[]{"Code","Fight", "On","!"};
    String separator = " ";
    String str = "";
      for(int i = 0 ; i < arguments.length ; i++) {
        str=str.concat(arguments[i].concat(separator));
    }
    System.out.println(str);
  }
}
