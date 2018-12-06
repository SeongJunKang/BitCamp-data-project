package bitcamp.ems.domain;

import java.sql.Date;

public class TeaAssignAdv extends TeaAssign {
  private String titl;
  private String tnm;
  public String getTitl() {
    return titl;
  }
  public TeaAssignAdv() {
    super();
    // TODO Auto-generated constructor stub
  }
  public TeaAssignAdv(int tano, int lno, int tno, Date stdt, Date endt, String desct, int hr) {
    super(tano, lno, tno, stdt, endt, desct, hr);
    // TODO Auto-generated constructor stub
  }
  public void setTitl(String titl) {
    this.titl = titl;
  }
  public String getTnm() {
    return tnm;
  }
  public void setTnm(String tnm) {
    this.tnm = tnm;
  }

}
