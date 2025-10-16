public class StudentGradesMS {

  // a program that allows users to input student information and grades, calculate averages, and display results. Implement classes for students and courses.
  //TODO: unfinished!

      public static void main(String[] args){

        StudentData student_No1 = new StudentData("1000",
                                                  "Peter",
                                                  "Smits", 
                                                  "35", 
                                                  "Male", 
                                                  "Ort",
                                                  "mail", 
                                                  "111-111-111", 
                                                  "10"            );

        
                                                  
        student_No1.setStudId("1001");    
        System.out.println(student_No1.getStudId());          
        student_No1.print_all_data();
        
        StudentGrades student_No1_grades = new StudentGrades(   1,
                                                                1,
                                                                1,
                                                                1,
                                                                2,
                                                                3,
                                                                2,
                                                                1,
                                                                2,
                                                                1       ); 

        student_No1_grades.setMaths(3);
        int newMaths = student_No1_grades.getMaths();


        System.out.println(student_No1_grades.getMaths());
        
        System.out.println(newMaths);

        student_No1_grades.print_all_grades();


//mach: zwischen-noten, mündlich/schriflich, durchschnitt gesammt-/zwischen-noten

        int[] array = new int[5];//mach ein 2-D array mit vektor rechnung bei dem die prozente vllt mit eingerechnet werden
            /*  schr., münd., tests,        Prozentuale Wertung
                  { {1, 4, 1},                { {0.5},
                    {1, 2, 2},                  {0.4},
                    {2, 3, 1},                  {0.1} }
                    {2, 2, 1},
                    {3, 2, 4},
                    {2, 1, 1} }
             */


        array[0] = 1;//schriflich 1. halbjahr
        array[1] = 1;
        array[2] = 2;

        array[3] = 2;//schriftlich 2. halbjahr
        array[4] = 3;
        array[5] = 2;

        array[6] = 4;//mündlich 1.hj 
        array[7] = 2;
        array[8] = 3;

        array[9] = 2;//mündlich 2.hj 
        array[10] = 2;
        array[11] = 1;

        array[12] = 1;//tests 1.hj 
        array[12] = 2;
        array[13] = 1;

        array[14] = 1;//tests 2.hj 
        array[15] = 4;
        array[16] = 1;




      }



}
