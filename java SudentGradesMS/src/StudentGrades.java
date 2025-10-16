public class StudentGrades {
  
  private int maths;
  private int german;
  private int english;
  private int history;
  private int PE;
  private int geology;
  private int biology;
  private int physics;
  private int chemistry;
  private int arts;





  public StudentGrades (  int maths,
                          int german,
                          int english,
                          int history,
                          int PE,
                          int geology,
                          int biology,
                          int physics,
                          int chemistry,
                          int arts      ) {
                                                this.maths = maths;
                                                this.german = german;
                                                this.english = english;
                                                this.history = history;
                                                this.PE = PE;
                                                this.geology = geology;
                                                this.biology = biology;
                                                this.physics = physics;
                                                this.chemistry = chemistry;
                                                this.arts = arts;  
                                             }








  public void setMaths (int newMaths) {

    this.maths = newMaths;

  }

  public void setGerman (int newGerman) {

    this.german = newGerman;

  }

  public void setEnglish (int newEnglish) {

    this.english = newEnglish;

  }

  public void setHistory (int newHistory) {

    this.history = newHistory;

  }

  public void setPE (int newPE) {

    this.PE = newPE;

  }

  public void setGeology (int newGeology) {

    this.geology = newGeology;

  }

  public void setBiology (int newBiology) {

    this.biology = newBiology;

  }

  public void setPhysics (int newPhysics) {

    this.physics = newPhysics;

  }

  public void setChemisty (int newChemistry) {

    this.chemistry = newChemistry;

  }

  public void setArts (int newArts) {

    this.arts = newArts;

  }




  




  public int getMaths () {

    return maths;

  }

  public int getGerman () {

    return german;

  }

  public int getEnglish () {

    return english;

  }

  public int gereturnory () {

    return history;

  }

  public int getPE () {

    return PE;

  }

  public int getGeology () {

    return geology;

  }

  public int getBiology () {

    return biology;

  }

  public int getPhysics () {

    return physics;

  }

  public int getChemisty () {

    return chemistry;

  }

  public int getArts () {

    return arts;

  }




  public void print_all_grades () {
                                    System.out.println("Maths: " + maths);
                                    System.out.println("German: " + german);
                                    System.out.println("English: " + english);
                                    System.out.println("History: " + history);
                                    System.out.println("PE: " + PE);
                                    System.out.println("Geology: " + geology);
                                    System.out.println("Biology: " + biology);
                                    System.out.println("Physics: " + physics);
                                    System.out.println("Chemistry: " + chemistry);
                                    System.out.println("Arts: " + arts);
  }



  int[] zwischen_noten = {};



}