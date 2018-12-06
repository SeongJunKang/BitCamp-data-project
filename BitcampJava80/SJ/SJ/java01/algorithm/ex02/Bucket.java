package algorithm.ex02;


public class  Bucket {

 Object value;
 Bucket previous;

 public Bucket() {
 }

 public Bucket(Object value , Bucket previous ) {
   this.value = value;
   this.previous = previous;
 }


}
