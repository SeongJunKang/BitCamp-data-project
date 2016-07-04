package bitcamp.pet.vo;

import java.sql.Date;

public class Request {
  int req;
  int mno;
  int pno;
  Date cdt;
  String conts;
  String stat;
  String ans;
  String res;
  String neut;
  String anifd;
  String manfd;
  String bark;
  String diz;
  String meal;
  String train;
  
  public int getReq() {
    return req;
  }
  public void setReq(int req) {
    this.req = req;
  }
  public int getMno() {
    return mno;
  }
  public String getRes() {
    return res;
  }
  public void setRes(String res) {
    this.res = res;
  }
  public String getNeut() {
    return neut;
  }
  public void setNeut(String neut) {
    this.neut = neut;
  }
  public String getAnifd() {
    return anifd;
  }
  public void setAnifd(String anifd) {
    this.anifd = anifd;
  }
  public String getManfd() {
    return manfd;
  }
  public void setManfd(String manfd) {
    this.manfd = manfd;
  }
  public String getBark() {
    return bark;
  }
  public void setBark(String bark) {
    this.bark = bark;
  }
  public String getDiz() {
    return diz;
  }
  public void setDiz(String diz) {
    this.diz = diz;
  }
  public String getMeal() {
    return meal;
  }
  public void setMeal(String meal) {
    this.meal = meal;
  }
  public String getTrain() {
    return train;
  }
  public void setTrain(String train) {
    this.train = train;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public Date getCdt() {
    return cdt;
  }
  public void setCdt(Date cdt) {
    this.cdt = cdt;
  }
  public String getConts() {
    return conts;
  }
  public void setConts(String conts) {
    this.conts = conts;
  }
  public String getStat() {
    return stat;
  }
  public void setStat(String stat) {
    this.stat = stat;
  }
  public String getAns() {
    return ans;
  }
  public void setAns(String ans) {
    this.ans = ans;
  }
  
  
}
