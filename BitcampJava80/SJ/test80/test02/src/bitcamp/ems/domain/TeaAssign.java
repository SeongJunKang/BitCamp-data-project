package bitcamp.ems.domain;

import java.sql.Date;

public class TeaAssign {
  protected int tano;     // Tea_Assign 번호
  protected int lno;      // 강의 번호
  protected int tno;      // 강사 번호
  protected Date stdt;   // 강의 시작일
  protected Date endt;   // 강의 종료일
  protected String desct; // 강의 내용
  protected int hr;       // 총 강의 시간

  public TeaAssign() {} 

  
  public TeaAssign(int tano, int lno, int tno, Date stdt,
                          Date endt, String desct, int hr) {    
    this.tano = tano;   
    this.lno = lno;     
    this.tno = tno;     
    this.stdt = stdt;  
    this.endt = endt; 
    this.desct = desct; 
    this.hr = hr;       
  }

  @Override
  public String toString() {
    return "Tea_assign [tano=" + tano + ", lno=" + 
        lno + ", tno=" + tno + ", stdt=" + stdt + ", endt=" + 
        endt + ", desct=" + desct + ", hr=" + hr + "]";
  }


  public int getTano() {
    return tano;
  }

  public void setTano(int tano) {
    this.tano = tano;
  }

  public int getLno() {
    return lno;
  }

  public void setLno(int lno) {
    this.lno = lno;
  }

  public int getTno() {
    return tno;
  }

  public void setTno(int tno) {
    this.tno = tno;
  }

  public Date getStdt() {
    return stdt;
  }

  public void setStdt(Date stdt) {
    this.stdt = stdt;
  }

  public Date getEndt() {
    return endt;
  }

  public void setEndt(Date endt) {
    this.endt = endt;
  }

  public String getDesct() {
    return desct;
  }

  public void setDesct(String desct) {
    this.desct = desct;
  }

  public int getHr() {
    return hr;
  }

  public void setHr(int hr) {
    this.hr = hr;
  }

}
