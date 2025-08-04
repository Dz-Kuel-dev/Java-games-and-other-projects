import java.util.Scanner;
//add different error 

public class TTT {

    static int expectedTurns = 9;
    static int count = 1;
    static String[][] playerInput = {{"x1", "x2", "x3"}, 
                                    {"y1", "y2", "y3"}, 
                                    {"z1", "z2", "z3"}};
    static boolean validInput = true;
    static int arrayI = 0;
    static int arrayJ = 0;



    public static boolean checkWin(char[][] array, char playerSign/* , PlayerInfo currentPlayer */){
        for(int i = 0; i < array.length; i++){
          if(checkRow(i, array, playerSign) || checkColumn(i, array, playerSign)){
            /* System.out.println("Victory!!! " + "Player " + playerSign + " won"); */
            return true;

          } else if(checkDiagonal(array, playerSign) || checkOtherDiagonal(array, playerSign)){
            /* System.out.println("Victory!!! " + "Player " + playerSign + " won"); */
            return true;
          }
        }
        return false;
    }

    public static boolean checkRow(int column, char[][] array, char playerSign){
        for(int j = 0; j < array.length; j++){
            if(array[column][j] != playerSign){
                return false;
            }   
        }
        return true;
    }

    public static boolean checkColumn(int row, char[][] array, char playerSign){
        for(int i = 0; i < array.length; i++){
            if(array[i][row] != playerSign){
                return false;
            }   
        }
        return true;
    }

    public static boolean checkDiagonal(char[][] array, char playerSign){
        for(int i = 0; i < array.length; i++){
            if(array[i][i] != playerSign){
                return false;
            }   
        }
        return true;
    }

    public static boolean checkOtherDiagonal(char[][] array, char playerSign){
        for(int i = 0; i < array.length; i++){
            if(array[i][array.length -1 - i] != playerSign){
                return false;
            }   
        }
        return true;
    }



    

public static void initializeField(char[][] array){
       
        char check = ' ';
    
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    if(array[i][j] != '\u0000'){
                        check = array[i][j];
                        return;
                    }
                }
            }
        if(check != 'x' && check != 'o'){//does || even make sense?
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array[i].length; j++){
                    array[i][j] = ' ';
                }
            }
        } return;
    
}

public static void resetField(char[][] array){
    for(int i = 0; i < array.length; i++){
        for(int j = 0; j < array[i].length; j++){
            array[i][j] = ' ';
        }
    }
}

public static void printField(char[][] array, PlayerInfo currentPlayer){


    System.out.println("\n");
    System.out.println("Spieler " + currentPlayer.getPlayerSign() + " ist am Zug.\t\t  Turn: " + count);

    initializeField(array);
    
    System.out.println();
    System.out.println(" ---------------");
    System.out.println("|   | 1 | 2 | 3 | ");
    System.out.println(" ---------------");
    System.out.println("| x | " + array[0][0] + " | " + array[0][1] + " | " + array[0][2] + " | ");
    System.out.println(" ---------------");
    System.out.println("| y | " + array[1][0] + " | " + array[1][1] + " | " + array[1][2] + " | ");
    System.out.println(" ---------------");
    System.out.println("| z | " + array[2][0] + " | " + array[2][1] + " | " + array[2][2] + " | ");
    System.out.println(" ---------------");

    System.out.println("\nSelect a field: ");
}



    class PlayerInfo{
        
        
        private char playerSign;
        



        public PlayerInfo(char playerSign){

            this.playerSign = playerSign;

        }

        public char getPlayerSign(){
            return playerSign;
        }

        public void setPlayerSign(char playerSign){
            this.playerSign = playerSign;
        }

    }



    public static boolean checkIfZoneIsOcupied(char[][] array, PlayerInfo currentPlayer){
        if(array[arrayI][arrayJ] == 'x' || array[arrayI][arrayJ] == 'o'){
            count--/*  -= 1 */;
            return false;
        } else {
            array[arrayI][arrayJ] = currentPlayer.getPlayerSign();
            return true;
        }
    }


    public static boolean changeField(char[][] array, PlayerInfo currentPlayer){

        Scanner objScanner = new Scanner(System.in);
        String userinput = objScanner.nextLine();
        //objScanner.close();


            count++/* += 1 */;

                if(userinput.equals(TTT.playerInput[0][0])){//equals() vergleicht ob die WERTE gleich sind (objecte only), "==" auch, aber bei objekten vergleicht es die REFERENZEN(addresse), nicht die werte
                    arrayI = 0;
                    arrayJ = 0;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);                   
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[0][1])){
                    arrayI = 0;
                    arrayJ = 1;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[0][2])){
                    arrayI = 0;
                    arrayJ = 2;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[1][0])){
                    arrayI = 1;
                    arrayJ = 0;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[1][1])){
                    arrayI = 1;
                    arrayJ = 1;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[1][2])){
                    arrayI = 1;
                    arrayJ = 2;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;
                    
                } else if(userinput.equals(TTT.playerInput[2][0])){
                    arrayI = 2;
                    arrayJ = 0;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[2][1])){
                    arrayI = 2;
                    arrayJ = 1;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;

                } else if(userinput.equals(TTT.playerInput[2][2])){
                    arrayI = 2;
                    arrayJ = 2;
                    validInput = checkIfZoneIsOcupied(array, currentPlayer);
                    return validInput;
                    
                } else {
                    count -- ; // brauche einen counter für den fall das was falsches eingegeben wird
                    
                    return false/* !validInput */;
                }     
                    
       
        
    }



    public static void loopField(char[][] array, PlayerInfo player1, PlayerInfo player2){
        //player change; global player; if ändern; wie habe ich ein objekt(player1/2) current player zugewiesen?was ist überhaupt currentPlayer?
        PlayerInfo currentPlayer = player1;

        
        
        printField(array, currentPlayer);
        

       outerLoop:
       while(count <= expectedTurns+1 && checkWin(array, currentPlayer.playerSign/* , currentPlayer */) == false){
        //i think the loop still finishes the rest when the condition is met in the middle

                validInput = changeField(array, currentPlayer);
               
            
            if(checkWin(array, currentPlayer.playerSign) != true){

                if(count == expectedTurns+1){
                    System.out.println("It's a Draw! Nobody wins!");
                    count--;
                    printField(array, currentPlayer);
                    break outerLoop;//break beendet den inneren loop/if,..; + outerloop beendet den den ganzen bestimmten bereich
                }
            
                if(validInput == false){//!validInput 
                    System.out.println("Invalid Input! Please enter corrrect characters.");
                    //return;beendet den ganzen
                } else if (currentPlayer == player1  && validInput == true|| currentPlayer == player2 && validInput == true){
                    if (currentPlayer == player1){
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
                }
             

            } else {
                System.out.println("Victory!!! " + "Player " + currentPlayer.playerSign + " won");//ich weis nicht wie es in dem fall am besten im userinterface aussehen würde
                count--;
                printField(array, currentPlayer);
                break outerLoop;
            }

            
            printField(array, currentPlayer);
            

        }
        count = 1;
        resetField(array);//the enemy of perfection is change
    } 




    public static void main(String[] args) throws Exception {

        char[][] array = new char[3][3];

        TTT objTTT = new TTT();
        PlayerInfo player1 = objTTT.new PlayerInfo('x');
        PlayerInfo player2 = objTTT.new PlayerInfo('o');/* TTT. */
     
        System.out.println("Do you want to start a new Game?");
         System.out.println("Yes\tNo?\n");
        Scanner objScanner = new Scanner(System.in);
        String startGame = objScanner.nextLine().toLowerCase();

        
       
        while(startGame.equals("yes") ){

            loopField(array, player1, player2);
            
            System.out.println("Do you want to start a new Game?");
            System.out.println("Yes\tNo?\n");
            startGame = objScanner.nextLine().toLowerCase();

        }
           

        objScanner.close();
    }
}




   /* 
    //static String[][] validInput = playerInput;
    //static int newCount = 1;

    public TTT(String[][] playerInput) {

        this.playerInput = playerInput;
        
    } 


        public static boolean checkIfFieldIsOcupied(char[][]array, TTT playerInput[][]){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] != 'y'){ 
                    return !validInput;
                }
            }
        }
        return validInput;
    }
     
    if(count % 2 == 1){
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            } 


        if(true){

            count += 1;
        
            switch (userinput) {
                case TTT.playerInput[0][0]:
                    array[0][0] = 'x';
                    break;
                case "x2":
                    array[0][1] = 'x';
                    break;
                .......
                default: 
                    count -= 1; // brauche einen counter für den fall das was falsches eingegeben wird, das die alte anzahl an eingaben gesaved wird
                    break;
            }



    //fehler die auftauchten:
    //  -suche nochmal nach minus count bugs
    //  -while loop für new game mit userinput checken: yes, no?
    //  -die !validInput bedingung check ich nicht
    //  -draw funktioniert nicht
    //  -new game geht nicht wenn x gewinnt oder es ein draw ist, sonst geht, aber o fängt an



    lektionen:
       -es ist besser einzelne funktionen für jeden fall zu machen, die dann in einer funktion zusammenlaufen
        versuche nicht den krassesten algorithmus zu finden
        return statements mit einem true false check sind da sehr hilfreich
        wenn etwas bei den einzelnen functionen keinen sinn ergibt oder die wichtige info von irgendwo fehlt, versuche einen gemeinsamen nenner der parallelen func zu finden und die fehlende info aus der urfunction zu beschaffen

       -the enemy of perfection is change
       -try to work more on composition/isolation/less dependancy: a function should only do as much as needed not more


    //get und set(functions dont work in functions)
    //man muss constant values benutzen keine variablen für die switch cases, arrays gehen daher auch nicht
    //wenn als bedingung für while: (true) benutzt wird, ist alles in den: {} true => infinite, false => never
    //man kann func calls als bedingung nutzen zb mit: return true/false
    //wenn man etwas als bedingung macht muss es nicht vorher aufgerufen werden
    //i think the loop still finishes the rest when the condition is met in the middle
    //loopField(array, player1, player2);//wieso wird das nicht aufgerufen?weil die bedingung für den loop ist dass count<expectedTurns
    //funktion mit static var nötig um spielfeld zu resetten
    //when working with zb. constructors: lokal variables will always be prefered over instance vars, so this. is needed when both vars have the same name
    //equals() vergleicht ob die WERTE gleich sind (objecte only), "==" auch, aber bei objekten vergleicht es die REFERENZEN(addresse), nicht die werte
 */