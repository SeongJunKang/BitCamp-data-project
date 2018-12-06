package algorithm.ex03;


public class  Bucket {

 Object value;
 Bucket tail;

 public Bucket() {
 }

 public Bucket(Object value , Bucket tail ) {
   this.value = value;
   this.tail = tail;
 }


}
