package vo;

public class Member {
  private int no;
  private String id;
  private String name;
  private String level;
  private String passwd;
  private String email;
  private String phone;
  private String regist;

  public Member() {

  }

  public Member setNo(int no) {
    this.no = no;
    return this;
  }

  public Member setId(String id) {
    this.id = id;
    return this;
  }

  public Member setName(String name) {
    this.name = name;
    return this;
  }

  public Member setLevel(String level) {
    this.level = level;
    return this;
  }

  public Member setPasswd(String passwd) {
    this.passwd = passwd;
    return this;
  }

  public Member setEmail(String email) {
    this.email = email;
    return this;
  }

  public Member setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Member setRegist(String regist) {
    this.regist = regist;
    return this;
  }

  public int getNo() {
    return no;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLevel() {
    return level;
  }

  public String getPasswd() {
    return passwd;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getRegist() {
    return regist;
  }
}
