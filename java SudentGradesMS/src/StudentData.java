public class StudentData {
  
  private String studId;
  private String studFName;
  private String studLName;
  private String studAge;
  private String studGender;
  private String studAddress;
  private String studEmail;
  private String studMobile;
  private String studClass;
 // private String[] studSchoolings;






  public StudentData( String studId,
                      String studFName, 
                      String studLName, 
                      String studAge, 
                      String studGender,
                      String studAddress, 
                      String studEmail, 
                      String studMobile, 
                      String studClass) {

                                              this.studId = studId;
                                              this.studFName = studFName; 
                                              this.studLName = studLName; 
                                              this.studAge = studAge; 
                                              this.studGender = studGender; 
                                              this.studAddress = studAddress;
                                              this.studEmail = studEmail; 
                                              this.studMobile = studMobile; 
                                              this.studClass = studClass;


                                            }
  

  public void setStudId (String newStudId) {

    this.studId = newStudId;

  } 


  public void setStudFname (String newStudFName) {

    this.studFName = newStudFName;

  } 


  public void setStudLName (String newStudLName) {

    this.studLName = newStudLName;

  } 


  public void setStudAge (String newStudAge) {

    this.studAge = newStudAge;

  } 

  
  public void setStudGender (String newStudGender) {

    this.studGender = newStudGender;

  } 


  public void setStudAddress (String newStudAddress) {

    this.studAddress = newStudAddress;

  } 


  public void setStudEmail (String newStudEmail) {

    this.studEmail = newStudEmail;

  } 

  
  public void setStudMobile(String newStudMobile) {

    this.studMobile = newStudMobile;

  } 


  public void setStudClass (String newStudClass) {

    this.studClass = newStudClass;

  } 









  public String getStudId ( ) {

    return studId;

  } 


  public String getStudFname ( ) {

    return studFName;

  } 


  public String getStudLName ( ) {

    return studLName;

  } 


  public String getStudAge ( ) {

    return studAge;

  } 

  
  public String getStudGender ( ) {

    return studGender;

  } 


  public String getStudAddress ( ) {

    return studAddress;

  } 


  public String getStudEmail ( ) {

    return studEmail;

  } 

  
  public String getStudMobile( ) {

    return studMobile;

  } 


  public String getStudClass ( ) {

    return studClass;

  } 





  public void print_all_data () {

    System.out.println();
    System.out.println("ID: " + studId);
    System.out.println("First Name: " + studFName);
    System.out.println("Last Name: " + studLName);
    System.out.println("Age: " + studAge);
    System.out.println("Gender: " + studGender);
    System.out.println("Address: " + studAddress);
    System.out.println("E-mail: " + studEmail);
    System.out.println("Mobile: " + studMobile);
    System.out.println("Class: " + studClass);
    System.out.println();
    
  }







  //grades




/*   public class StudentGrades {

    int maths;
  
  }  */


}


//illegal: class must have its own file or be in a nother class (sub-class?)
/* public class StudentGrades {
  
} */

