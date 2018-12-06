package bitcamp.pms.domain;

public class Rooms {
  private String rno;
  private String rnm;

  
  
  public Rooms() {
  }
  public Rooms(String rno, String rnm) {
    this.rno = rno;
    this.rnm = rnm;
  }


  @Override
  public String toString() {
    return "Rooms [rno=" + rno + ", rnm=" + rnm + "]";
  }
  
  public String getRno() {
    return rno;
  }
  public void setRno(String rno) {
    this.rno = rno;
  }
  public String getRnm() {
    return rnm;
  }
  public void setRnm(String rnm) {
    this.rnm = rnm;
  }

  
}
