import java.util.Scanner;

/*
 https://www.perplexity.ai/search/gib-mir-spielevorschlager-die-5rzY7hRPSL6kKAMhgA5CKw
 */
public class GuessTheNumber {


    public static void main(String[] args) throws Exception {
        
        int playerInput;//int
        int tries = 0;

        Scanner objScanner = new Scanner(System.in);

        int randomGeneratedNumber = 1 +(int)(Math.random() * 99);
       

                System.out.println("Guess a number between 1 and 100: ");

                do{//do while ist praktischer, da die bedingung nicht erfüllt werden muss damit es ausgeführt wird;
                    //bei diesem spiel ist es wichtig dass ich nicht vorher einen scaninput zugewiesen habe, damit ich nichts zweimal eingeben muss
                    //man könnte es ohne machen aber das wäre unnotig viel redundanter code

                    /*int*/playerInput = objScanner.nextInt();//wieso muss bei einem while loop die variable vorher zugewiesen sein? aber bei do-while nicht, aber sie muss vorher erstellt worden sein?
                    tries++;
                    
                    if(playerInput == randomGeneratedNumber){
                        System.out.println("Correct! You guessed the rigth number in " + tries + " tries.");
                    } else if (playerInput < randomGeneratedNumber){
                        System.out.println("Wrong. Enter higher number: ");
                    } else {
                        System.out.println("Wrong. Enter lower number: ");
                    }
                }while(playerInput != randomGeneratedNumber);
            


                while(randomGeneratedNumber != 100 && randomGeneratedNumber != 1){
                    randomGeneratedNumber = (int)(Math.round(Math.random() * 99)) + 1;//i only now notice that the odds of getting a 1 for example is so low because there is no rounding
                    System.out.println(randomGeneratedNumber);
                }

                objScanner.close();
       
    }
}
/*  for(int i = 0; i < 50; i++){
            randomGeneratedNumber = 10 +(int)(Math.random() * 90);
            System.out.println(randomGeneratedNumber);
        } */

        /*
         Antwort: - java compiler muss sicherstellen dass eine variable initialisiert wurde bevor sie genutzt werden kann
                  - daher muss bei einer while schleife die variable vorher einen wert haben
                  - eine do-while schleife prüft diese initialisierungsbedingung und co erst nach dem 1. durchlauf der schleife, kann sie auch erst in der schleife zugewiesen werden
                  - WICHTIG: - dies variable muss in beiden fällen vorher erstellt werden
                              - bei while, da der compiler die bedingung vorher prüfen muss
                              - bei do-while, da die in der schleife/block erstellte variable LOKAL ist 
                                => bei nächstem durchgang zählt sie als andere variable, ABER es muss ja nach diesem durchgang 
                                geprüft werden ob die bedingung stimmt, was nicht geht da es sich jz um eine andere uninitialisierte variable handelt 
         */