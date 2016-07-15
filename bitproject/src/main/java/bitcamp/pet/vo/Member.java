package bitcamp.pet.vo;

import java.util.Date;

public class Member {
  int mno;
  String email;
  String pwd;
  String name;
  String gen;
  Date bth;
  String agency;
  String eauth;
  public String getEauth() {
    return eauth;
  }

  public void setEauth(String eauth) {
    this.eauth = eauth;
  }
  String tel;
  String qus;
  String ans;
  int gra;
  String prof;
  
  public String getProf() {
    return prof;
  }

  public void setProf(String prof) {
    this.prof = prof;
  }

  public String getAgency() {
    return agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }
  public String getQus() {
    return qus;
  }

  public void setQus(String qus) {
    this.qus = qus;
  }

  public String getAns() {
    return ans;
  }

  public void setAns(String ans) {
    this.ans = ans;
  }

  public int getGra() {
    return gra;
  }

  public void setGra(int gra) {
    this.gra = gra;
  }
  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Member(){}
  
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getGen() {
    return gen;
  }
  public void setGen(String gen) {
    this.gen = gen;
  }
  public Date getBth() {
    return bth;
  }
  public void setBth(Date bth) {
    this.bth = bth;
  }

}
