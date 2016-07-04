package bitcamp.pet.vo;

public class PetSitter {
  
  int pno;      // 회원번호
  String nick;  // 닉네임
  String intro; // 소개
  int amt;      // 가격
  String ktalk; // 카카오톡
  String bank;  // 은행
  String bknm;  // 예금주
  String acc;   // 계좌번호
  String ser;   // 추가서비스
  String inqur; // 문의시간
  String pet;   // 반려동물유무
  int rad;   // 반지름
  String lat;   // 위도
  String lnt;   // 경도
  String addr_1;
  String addr_2;
  String addr_3;
  String region;  // 산책범위
  String img;     // 프로필사진
  int likes;      // 좋아요
  int petg;       // 펫등급
  int hospital;
  public String getAddr_3() {
    return addr_3;
  }
  public void setAddr_3(String addr_3) {
    this.addr_3 = addr_3;
  }
  public int getHospital() {
    return hospital;
  }
  public void setHospital(int hospital) {
    this.hospital = hospital;
  }
  public int getLikes() {
    return likes;
  }
  public void setLikes(int likes) {
    this.likes = likes;
  }
  public int getPetg() {
    return petg;
  }
  public void setPetg(int petg) {
    this.petg = petg;
  }
  public String getImg() {
    return img;
  }
  public void setImg(String img) {
    this.img = img;
  }
  public String getRegion() {
    return region;
  }
  public void setRegion(String region) {
    this.region = region;
  }
  public String getAddr_1() {
    return addr_1;
  }

  public void setAddr_1(String addr_1) {
    this.addr_1 = addr_1;
  }

  public String getAddr_2() {
    return addr_2;
  }

  public void setAddr_2(String addr_2) {
    this.addr_2 = addr_2;
  }

  public PetSitter(){}
  
  public int getPno() {
    return pno;
  }
  public void setPno(int pno) {
    this.pno = pno;
  }
  public String getNick() {
    return nick;
  }
  public void setNick(String nick) {
    this.nick = nick;
  }
  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public int getAmt() {
    return amt;
  }
  public void setAmt(int amt) {
    this.amt = amt;
  }
  public String getKtalk() {
    return ktalk;
  }
  public void setKtalk(String ktalk) {
    this.ktalk = ktalk;
  }
  public String getBank() {
    return bank;
  }
  public void setBank(String bank) {
    this.bank = bank;
  }
  public String getBknm() {
    return bknm;
  }
  public void setBknm(String bknm) {
    this.bknm = bknm;
  }
  public String getAcc() {
    return acc;
  }
  public void setAcc(String acc) {
    this.acc = acc;
  }
  public String getSer() {
    return ser;
  }
  public void setSer(String ser) {
    this.ser = ser;
  }
  public String getInqur() {
    return inqur;
  }
  public void setInqur(String inqur) {
    this.inqur = inqur;
  }
  public String getPet() {
    return pet;
  }
  public void setPet(String pet) {
    this.pet = pet;
  }
  public int getRad() {
    return rad;
  }
  public void setRad(int rad) {
    this.rad = rad;
  }
  public String getLat() {
    return lat;
  }
  public void setLat(String lat) {
    this.lat = lat;
  }
  public String getLnt() {
    return lnt;
  }
  public void setLnt(String lnt) {
    this.lnt = lnt;
  }
  
}
