public class Adressdaten {

  private String fname;
  private String lname;
  private String tel;
  private String email;


  public Adressdaten (String newFname, String newLname, String newTel, String newEmail){

    this.fname = newFname;
    this.lname = newLname;
    this.tel   = newTel;
    this.email = newEmail;

  }




  public void setFname (String newFname) {
    this.fname = newFname;
  }

  public void setLname (String newLname) {
    this.lname = newLname;
  }

  public void setTel (String newTel) {
    this.tel = newTel;
  }

  public void setEmail (String newEmail) {
    this.email = newEmail;
  }




  public String getFname () {
    return fname;
  }

  public String getLname () {
    return lname;
  }

  public String getTel () {
    return tel;
  }

  public String getEmail () {
    return email;
  }




  public String print_all(){
    
    return 
            "First Name: " + fname + "\n" +
            "Last Name: " + lname + "\n" +
            "Tel. Number: " + tel + "\n" +
            "E-mail Address: " + email + "\n" 
    ;
    

  }






}
