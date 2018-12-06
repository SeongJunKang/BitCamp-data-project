package bitcamp.ems.domain;

import java.sql.Date;

public class Lects {
  private int lno;
  private String rno;
  private String titl;
  private String desct;
  private Date st_dt;
  private Date en_dt;
  private int day_hr;
  private int tot_hr;
  private Date fi_dt;
  @Override
  public String toString() {
    return "Lects [lno=" + lno + ", rno=" + rno + ", titl=" + titl + ", desct=" + desct + ", st_dt=" + st_dt
        + ", en_dt=" + en_dt + ", day_hr=" + day_hr + ", tot_hr=" + tot_hr + ", fi_dt=" + fi_dt + "]";
  }
  public Lects() {
    super();
  }
  public int getLno() {
    return lno;
  }
  public void setLno(int lno) {
    this.lno = lno;
  }
  public String getRno() {
    return rno;
  }
  public void setRno(String rno) {
    this.rno = rno;
  }
  public String getTitl() {
    return titl;
  }
  public void setTitl(String titl) {
    this.titl = titl;
  }
  public String getDesct() {
    return desct;
  }
  public void setDesct(String descrt) {
    this.desct = descrt;
  }
  public Date getSt_dt() {
    return st_dt;
  }
  public void setSt_dt(Date st_dt) {
    this.st_dt = st_dt;
  }
  public Date getEn_dt() {
    return en_dt;
  }
  public void setEn_dt(Date en_dt) {
    this.en_dt = en_dt;
  }
  public int getDay_hr() {
    return day_hr;
  }
  public void setDay_hr(int day_hr) {
    this.day_hr = day_hr;
  }
  public int getTot_hr() {
    return tot_hr;
  }
  public void setTot_hr(int tot_hr) {
    this.tot_hr = tot_hr;
  }
  public Date getFi_dt() {
    return fi_dt;
  }
  public void setFi_dt(Date fi_dt) {
    this.fi_dt = fi_dt;
  }
  
}
