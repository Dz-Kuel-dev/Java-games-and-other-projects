import java.util.Scanner;
import java.util.Random;
/*
 - spiel wird beendet
 - spieler wählen richtige dinge
 - sieger wird richtig ausgewählt
 - punkte wachsen

 bei nextint():
 - pointsgoal auswahl wird manchmal ignoriert (kleinere zahl wird preferiert, oder default 1 )
    ausnahmen wenn größere z - 3, ->5  ;  ->5, 2  ;  ->2, 1  ; ->5, 1  ; 1, ->3  ;  1; ->3  (keien relevanz)
    wenn pgoal ignoriert - 5, 2 ->4  (keine relevanz)
    wenn ->1 - 3, 4  ; 3, 2  ; 5, 4  ; 2, 4  ; 3, 5  ; debug some error occured (5,1 ->1 ; 5,1 ->1  ; 1, 2 ->1)
    1 kann auch normal gewinnen es ist nicht immer ein fehler (also kein fehler)

 standpunkt start,continue game:
    //wenn das spiel beendet wird taucht die choosetypesofplayers fehlermeldung auf da ja die funktion false zurück gibt wegen des spiel endes
    //vergiss nicht pvp,... zurück zu false zu setzen

    //gib namen ein pve/eve soll der name computer angezeigt werden

    //der punkte stand wird bei dem loop nicht resetted

FÜRS NÄCHSTE MAL: schreib auf wie das spiel aussehen soll in paint: menü, funktionen, ...

            https://merchant-shade.itch.io/16x16-mini-world-sprites

FRAGEN: was ist mit den erstellten objekten(player1/2) während ich noch im loop bin?werden sie bei erneuten spiel wieder genutzt, gelöscht?es scheint zu funktioneren(für jetzt),aber wie ist das wenn ich mich registrieren will?
 */
public class RPS {

  

    public static int i;

    //working with constructors
    final static String ROCK = "ROCK";
    final static String PAPER = "PAPER";
    final static String SCISSORS = "SCISSORS";

    public static boolean pvp = false;
    public static boolean pve = false;
    public static boolean eve = false;

    public static int pointsGoal = 1;
    //public static Ki ki;

    public static boolean WIN;
    public static String winner;

    public static boolean winConGameMode;

    public static int pointsP1 = 0;
    public static int pointsP2 = 0;

    public static int caseResult;

    public static int totalGames;
    public static int wins;
    public static int loses;
    public static int ties;

    //wie kann ich etwas langfristig in einem array speichern, selbst wenn das programm beendet wird: datenbanken; in text-file speichern; serialisierung in datei; json-file;
    public static String[][] playerList = new String[100][15];
    public static int[] idList = new int[100];

    class utilityMethods{

        //hilfreich für ordnung aber dann ist das schwieriger/umstndlicher zu erreichen
        //vllt wäre es sinnvoller wenn hier auf die gleichen variablen zugegriffen werden, 
        //die ich unzugänglich machen will?dann wäre private auch ok, also gibt es einen sinn?
     
    }

    class GameModes{

        public static void chooseGameMode(Player player1, Player player2, Random objRandom){
            //fixed das problem mit den ignoriertem zahlen bei random.nextInt()
            //nextInt(2) statt nextInt(0, 2)  das fixed auch das problem(das 2. kann zu fehlern führen)
            if(player1.getGameModeInput() == player2.getGameModeInput()){
                pointsGoal = player1.getGameModeInput();
            } else {
                if(objRandom.nextBoolean()){//gibt true oder false zurück
                    pointsGoal = player1.getGameModeInput();
                } else {//else checkt für false
                    pointsGoal = player2.getGameModeInput();
                } 
            }
               
            
        }


        public static boolean chooseTypesOfPlayers(String playerChoice){
            switch (playerChoice) {
                case "1":
                    pvp = true;
                    return true;
                case "2":
                    pve = true;
                    return true;
                case "3":
                    eve = true;
                    return true;
                default:
                    /* System.out.println("Debug:\tSOME ERROR OCCURED!!!_________________________________chooseTypesOfPlayers"); */
                    return false;
            }
        }
    }




/* abstract  */class Player{
    //soll ich die ki erben lassen?wie löse ich das mit dem input
    class Ki{//static vorteil: kein obj von outer.C. nötig, nachteil: kann nicht auf RPS zugreifen
   
    }

    private int playerID;
    private String playerName;
    /* String playerChoice; */

    private int gameModeInput;

    static String curentPlayer;


    public Player(String playerName, int playerID){

        this.playerName = playerName;
        this.playerID = playerID;
/* 
        for(int i = 0; i < playerList.length; i++){
            if(playerList[i] == null ){
                playerList[i] = this.playerName;
            }else{
                continue;
            }
        } */

    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getGameModeInput() {
        return gameModeInput;
    }


    public void setGameModeInput(int gameModeInput) {
        this.gameModeInput = gameModeInput;
    }


  /*   public void setPlayerID(int playerID) {
        this.playerID = playerID;
    } */

}


/* abstract */class ComputerCharacter extends Player{

    Random objRandom;

    public ComputerCharacter(String playerName, int playerID){
        super(playerName, playerID);
        this.objRandom = new Random();

    }


    public String ComputerCharacter_choice_rps(String playerChoice, Random objRandom){
        switch (objRandom.nextInt(1, 4)) {
            
            case 1:
                playerChoice = ROCK;
                return playerChoice;
            case 2:
                playerChoice = PAPER;
                return playerChoice;
            case 3:
                playerChoice = SCISSORS;
                return playerChoice;
            default:
                return "ERROR!!! Computer picked an unregistrated option!";
        }
    }


}




class Rules{//man kann inner classes extenden, oder auch zu abstract clsses machen
    
   public static int returnResultPlayer1(String player1Choice, String player2Choice){//man kann über object passing auf playerchoice zugreifen

    if (player1Choice.equals(player2Choice)) {
        winner = "no player";
        return 3; // tie
    } else if ((player1Choice.equals(SCISSORS) && player2Choice.equals(PAPER)) ||
               (player1Choice.equals(PAPER) && player2Choice.equals(ROCK)) ||
               (player1Choice.equals(ROCK) && player2Choice.equals(SCISSORS))) {
        winner = "player 1";
        return 1; // win for player 1
    } else if ((player2Choice.equals(SCISSORS) && player1Choice.equals(PAPER)) ||
               (player2Choice.equals(PAPER) && player1Choice.equals(ROCK)) ||
               (player2Choice.equals(ROCK) && player1Choice.equals(SCISSORS))) {
        winner = "player 2";//so im facing the problem that when i type something other than r,p,s the programm does (sometimes) ignore the input check. has this something to do with race condition, cause this else scenario is about the same input, so are those two race against each other?but why does the loser not get printed afterwords?
        return 2; // win for player 2
    } else {
        
        return 4;
    }
    

    }



   public static void allocatePointsToPlayers(String player1Choice, String player2Choice, Player player1, Player player2){
    caseResult = returnResultPlayer1(player1Choice, player2Choice);
        System.out.println("--------------------");
        System.out.println("Debug: " + player1.getPlayerName() + " chose " + player1Choice + ", " + player2.getPlayerName() + " chose " + player2Choice);
        System.out.println("Debug: Result is " + caseResult);
    switch (caseResult) {
        case 1:
            System.out.println(winner + " wins");//manchmal habe ich das problem das die anzeige: ebug:\tSOME ERROR OCCURED!!!" auftaucht
            pointsP1++;                         //selten: first player to reach 1 points wins? ich habe 3 und 4 eingegeben
            break;                              //dann noch das problem dass die erste fehlermeldung: Wrong input! Please enter rock, paper or scissors! auftaucht
        case 2:
            System.out.println(winner + " wins");
            pointsP2++;
            break;
        case 3:
            System.out.println(winner + " wins");
            break;      
        default:
            System.out.println("Debug:\tSOME ERROR OCCURED 2!!!");
            break;
    }
        System.out.println("");
        System.out.println("Debug: Current scores - " + player1.getPlayerName() +": " + pointsP1 + ", " + player2.getPlayerName() + ": " + pointsP2);
        System.out.println("--------------------");
   }

    public static boolean checkWin(Player player1, Player player2){
        if(pointsP1 == pointsGoal){
            winner = player1.playerName;
            return true;  
        } else if(pointsP2 == pointsGoal){
            winner = player2.playerName;
            return true; 
        } else {
            return false;
        }
   } 
   


enum Test{
    LOW,
    MEDIUM,
    HIGH
}

} 


public static int randomFiveDigitNumber(){
    return 10000 + (int)(Math.random() * 90000);
    //casting hat priorität gegenüber "*", klammern sind also nötig
           
} 


public static void validateStringLength(String someString, Scanner objScanner){
    while(someString.length() > 15){
        System.out.println("Der Name darf nicht mehr als 15 Zeichen haben!");
        System.out.println("Versuche es nochmal: ");
        someString = objScanner.nextLine();
        
       }
} 

public static boolean checkPlayerChoice(String playerChoice){
    if(playerChoice.equals(ROCK) || playerChoice.equals(PAPER) || playerChoice.equals(SCISSORS)){
        return true;
    } else {
        return false;
    }
    
}

public static Player createPlayersComputer(RPS objRPS, Scanner objScanner){

    System.out.println("Gib bitte einen Namen ein(max. 15 Zeichen): ");
    String playerName = "Computer";//lösung für doppelten namen
    System.out.println(playerName);
    //validateStringLength(playerName, objScanner);//da wird ein input benötigt
    Player objComputerCharacter = objRPS.new ComputerCharacter(playerName, randomFiveDigitNumber()); 

    return objComputerCharacter;//wie wird das behandelt? als objekt vom parent?NEIN!!! als objekt der child class. könnte aber tricky werden dessen functs zu nutzen
}

public static Player createPlayers(RPS objRPS, Scanner objScanner){

    System.out.println("Gib bitte einen Namen ein(max. 15 Zeichen): ");
    String playerName = objScanner.nextLine();
    validateStringLength(playerName, objScanner);
    Player player = objRPS.new Player(playerName, randomFiveDigitNumber()); 

    return player;
}

public static void choosePointsGoal(Scanner objScanner, Player player){
    System.out.println("Choose a gamemode: \n");
    System.out.println("Up to how many points do you want to play to?: \n->");
    player.setGameModeInput(objScanner.nextInt());
    objScanner.nextLine();
}

public static void choosePointsGoalComputer(Player player, Random objRandom){
    System.out.println("Choose a gamemode: \n");
    System.out.println("Up to how many points do you want to play to?: \n->");
    player.setGameModeInput(objRandom.nextInt(1, 6));
    //objScanner.nextLine();
    System.out.println(player.getGameModeInput());
}

public static String printPlayerChoice(Scanner objScanner, String playerChoice){//ich könnte auch einfach playerchoice hier erstellen und weitergeben an pchoice1/2 in der main
    System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
    playerChoice = objScanner.nextLine().toUpperCase();
      while(checkPlayerChoice(playerChoice) == false){
        System.out.println("Wrong input! Please enter rock, paper or scissors!");
        System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
        playerChoice = objScanner.nextLine().toUpperCase();
      }
    System.out.println();

    return playerChoice;
}


public static String printPlayerChoiceComputer(Random objRandom, String playerChoice, Player player){
    System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
    playerChoice = callComputerChoice(player, playerChoice, objRandom);
       while(checkPlayerChoice(playerChoice) == false){
        System.out.println("Wrong input! Please enter rock, paper or scissors!");
        System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
        playerChoice = callComputerChoice(player, playerChoice, objRandom);// das ändert nicht die condition????
        //break;
      }
      System.out.println(playerChoice);
    //System.out.println(playerChoice + "111111111111111111111111111111111111");

    return playerChoice;
}


private static String callComputerChoice(Player player, String playerChoice, Random objRandom) {
    if (player instanceof ComputerCharacter) {
        return ((ComputerCharacter) player).ComputerCharacter_choice_rps(playerChoice, objRandom);
    } else {
        System.out.println("Der Spieler ist kein Computer-Objekt");
        return "Debug:ERROR!!! I DONT KNOW WHAT TO PUT HERE!";
    }
}






    public static void main(String[] args) throws Exception {

            /*
             player 1, player 2, pchoice 1, pchoice 2 werden hier genutzt
             */


            RPS objRPS = new RPS();
            GameModes objGameModes = objRPS.new GameModes();
            Random objRandom = new Random();
            Scanner objScanner = new Scanner(System.in);

            String player1Choice;
            String player2Choice;

            String startAnotherGame;

            System.out.println("WELCOME TO ROCK PAPER SCISSORS!");
            System.out.println("Do you want start the Game?");
            System.out.println("Press 1 or 2! _______     _______");
            System.out.println("             | 1.Yes |   | 2.No  |");
            System.out.println("             |_______|   |_______|");

            startAnotherGame = objScanner.nextLine().toLowerCase();//statt player1choice, ist zuverlässiger wenn die inputs nicht von einander abhängig sind(1 variable sollte nicht über das ganze spiel entscheiden(btw es funktioniert auch nicht mit p1choice))

           do{

                

                System.out.println("                                 ____________________     ____________________     ____________________");
                System.out.println("Choose Player Mode:             | 1.Player vs Player |   | 2.Player vs Entity |   | 3.Entity vs Entity |");
                System.out.println("Select the associated number!   |____________________|   |____________________|   |____________________|");
                player1Choice = objScanner.nextLine();//be carefull here!if playerchoice does not change at the End the loop never ends. also make sure you reassign it correctly before you want to use it again
                
                while(GameModes.chooseTypesOfPlayers(player1Choice) == true){//vlt if benutzen

                    if(pvp == true){
                        Player player1 = createPlayers(objRPS, objScanner);
                        Player player2 = createPlayers(objRPS, objScanner); 

                        System.out.println(player1.getPlayerID() + " : " + player2.getPlayerID());

                        choosePointsGoal(objScanner, player1);
                        choosePointsGoal(objScanner, player2);

                        GameModes.chooseGameMode(player1, player2, objRandom);
                        do{

                            System.out.println();
                            System.out.println("First Player to reach " + pointsGoal + " points wins!");
                            System.out.println("Punktestand: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() +  "\n");
                            
                            player1Choice = "Placeholder";//reassigning playerchoice from "1"/"2"/"3"
                            player1Choice = printPlayerChoice(objScanner, player1Choice);
                            
                            player2Choice = "Placeholder";
                            player2Choice = printPlayerChoice(objScanner, player2Choice);
            
                            Rules.allocatePointsToPlayers( player1Choice,  player2Choice, player1, player2);
                
                            //i++;
                        }
                        while(Rules.checkWin(player1, player2) != true/*  && i <= 10 */);
            
                        System.out.println("Punktestand: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() +  "\n");

                        //player1Choice = "1";this would make the loop infinite
                        pvp = false;
                    
                    } else if(pve == true){
                        Player player1 = createPlayers(objRPS, objScanner);
                        Player player2 = createPlayersComputer(objRPS, objScanner); 

                        System.out.println(player1.getPlayerID() + " : " + player2.getPlayerID());

                        choosePointsGoal(objScanner, player1);
                        choosePointsGoalComputer(player2, objRandom);

                        GameModes.chooseGameMode(player1, player2, objRandom);
                        do{

                            System.out.println();
                            System.out.println("First Player to reach " + pointsGoal + " points wins!");
                            System.out.println("Punktestand: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() +  "\n"); 
                            
                            player1Choice = "Placeholder";
                            player1Choice = printPlayerChoice(objScanner, player1Choice);
                            
                            player2Choice = "Placeholder";
                            player2Choice = printPlayerChoiceComputer(objRandom, player2Choice, player2);
            
                            Rules.allocatePointsToPlayers( player1Choice,  player2Choice, player1, player2);
                
                            //i++;
                        }
                        while(Rules.checkWin(player1, player2) != true/*  && i <= 10 */);
            
                        System.out.println("Punktestand: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() +  "\n");
                    
                        pve = false;

                    } else if(eve == true){
                        Player player1 = createPlayersComputer(objRPS, objScanner);
                        Player player2 = createPlayersComputer(objRPS, objScanner);

                        System.out.println(player1.getPlayerID() + " : " + player2.getPlayerID());

                        choosePointsGoalComputer(player1, objRandom);
                        choosePointsGoalComputer(player2, objRandom);
                        
                        GameModes.chooseGameMode(player1, player2, objRandom);
                        do{

                            System.out.println();
                            System.out.println("First Player to reach " + pointsGoal + " points wins!");
                            System.out.println("Punktestand: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() +  "\n");
                        
                            player1Choice = "Placeholder";
                            player1Choice = printPlayerChoiceComputer(objRandom, player1Choice, player1); 

                            player2Choice = "Placeholder";
                            player2Choice = printPlayerChoiceComputer(objRandom, player2Choice, player2);

                            Rules.allocatePointsToPlayers( player1Choice,  player2Choice, player1, player2);
                
                            i++;
                        }
                        while(Rules.checkWin(player1, player2) != true/*  && i <= 10 */);

                        System.out.println("Punktestand: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() +  "\n");
            
                        eve = false;

                    } else {
                        System.out.println("Debug: ERROR!!!______Selecting Player Mode went wrong! Try again!");
                    }

                    pointsP1 = 0;
                    pointsP2 = 0;
                }

                System.out.println("Do you want start another the Game?");
                System.out.println("Press 1 or 2! _______     _______");
                System.out.println("             | 1.Yes |   | 2.No  |");
                System.out.println("             |_______|   |_______|");
    
                startAnotherGame = objScanner.nextLine().toLowerCase();

            } while(startAnotherGame.equals("1"));
          
    }
       
}

 /*  String eingabeSubString = playerName.substring(0, Math.min(playerName.length(), 15));
            System.out.println(eingabeSubString); */

             /*   public static int returnResultPlayer2(String player1Choice, String player2Choice){//kann ich über object passing auf playerchoice zugreifen?
    if(player2Choice.equals(player1Choice)){
        return 3;//tie p2
    }else if(player2Choice.equals(PAPER) && player1Choice.equals(SCISSORS) || player2Choice.equals(ROCK) && player1Choice.equals(PAPER)){
        return 2;//loss p2
    } else{
        return 1;//win p2
    } 
    
   }*/


 /*   public static void allocatePointsToPlayers(String player1Choice, String player2Choice, String currentPlayer){
    if(caseResult == 1){
        currentPlayer 
    }
    caseResult = Rules.returnResultPlayer1(player1Choice, player2Choice);
    caseResult = Rules.returnResultPlayer2(player1Choice, player2Choice);
   }*/


/*    public static void chooseGameMode(Player player1, Player player2, Random objRandom){
    
    if(player1.getGameModeInput() == player2.getGameModeInput()){
        pointsGoal = player1.getGameModeInput();
    } else if(objRandom.nextInt(0, 2) == 0){
        pointsGoal = player1.getGameModeInput();
    } else if(objRandom.nextInt(0, 2) == 1){
        pointsGoal = player2.getGameModeInput();
    } else{
        System.out.println("Debug:\tSOME ERROR OCCURED!!!________________________________________________________________");
    }
    
} */


   /*
            Player player1 = objRPS.new Player(createCharacters(objRPS, objScanner), randomFiveDigitNumber());
            
            Player player2 = objRPS.new Player(createCharacters(objRPS, objScanner), randomFiveDigitNumber());
    
    */