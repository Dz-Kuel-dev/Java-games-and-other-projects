import java.util.Scanner;
import java.util.Random;

/**
 * Game: Rock Paper Scissors
 * Structure:
 * - RPS: main class with main method
 * - Inner classes: GameModes, Player, ComputerCharacter, Rules, utilityMethods
 *
 * Commenting strategy:
 * - Complex logic (game evaluation, AI choice, game mode resolution) is explained in more detail.
 * - Simple getters/setters or declarative lines have brief comments.
 *
 * Note: all comments are generated with AI
 */

public class RPS {

    /* Constants for possible moves */
    final static String ROCK = "ROCK";
    final static String PAPER = "PAPER";
    final static String SCISSORS = "SCISSORS";

    /* Game mode flags (only one should be true at a time) */
    public static boolean pvp = false;
    public static boolean pve = false;
    public static boolean eve = false;

    /* Points goal for a match (determined by game mode input) */
    public static int pointsGoal = 1;

    /* Current game state: winner, scores, result codes */
    public static boolean WIN;
    public static String winner;
    public static int pointsP1 = 0;
    public static int pointsP2 = 0;
    public static int caseResult;

    /* Statistics placeholders (not actively used, prepared for future) */
    public static int totalGames;
    public static int wins;
    public static int loses;
    public static int ties;

    /* Example in-memory "persistence" placeholders */
    public static String[][] playerList = new String[100][15];
    public static int[] idList = new int[100];

    /**
     * Lightweight helper class for future utilities.
     * Currently a placeholder for shared helper functions.
     */
    class utilityMethods {
        // space for shared utility methods
    }

    /**
     * Game mode related logic:
     * - chooseTypesOfPlayers: sets the chosen game mode based on string input ("1","2","3")
     * - chooseGameMode: determines pointsGoal when the two players chose different numbers:
     *      If both equal -> use that number.
     *      If different -> choose randomly between the two inputs.
     */
    class GameModes {

        /**
         * Determines pointsGoal. If both players selected same number -> use it.
         * If they selected different numbers -> randomly choose one of them.
         *
         * @param player1   Player 1 (contains gameModeInput)
         * @param player2   Player 2
         * @param objRandom Random instance for decisions
         */
        public static void chooseGameMode(Player player1, Player player2, Random objRandom) {
            if (player1.getGameModeInput() == player2.getGameModeInput()) {
                pointsGoal = player1.getGameModeInput();
            } else {
                // random boolean to choose between player1's or player2's choice
                if (objRandom.nextBoolean()) {
                    pointsGoal = player1.getGameModeInput();
                } else {
                    pointsGoal = player2.getGameModeInput();
                }
            }
        }

        /**
         * Sets game-mode flags based on choice string.
         *
         * @param playerChoice "1" = PvP, "2" = PvE, "3" = EvE
         * @return true if a valid mode was chosen, false otherwise
         */
        public static boolean chooseTypesOfPlayers(String playerChoice) {
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
                    return false;
            }
        }
    }

    /**
     * Base Player class.
     * Contains id, name and the chosen game-mode input (points target).
     */
    class Player {
        private int playerID;
        private String playerName;
        private int gameModeInput;
        static String currentPlayer; // not used but kept for compatibility

        public Player(String playerName, int playerID) {
            this.playerName = playerName;
            this.playerID = playerID;
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
    }

    /**
     * Computer player class (inherits from Player).
     * Manages its own Random instance and returns random moves.
     */
    class ComputerCharacter extends Player {

        Random objRandom;

        public ComputerCharacter(String playerName, int playerID) {
            super(playerName, playerID);
            this.objRandom = new Random();
        }

        /**
         * Randomly picks ROCK, PAPER or SCISSORS.
         * Uses nextInt(1,4) which returns 1..3.
         *
         * @param playerChoice input placeholder (will be overwritten)
         * @param objRandom    random instance to use
         * @return chosen move
         */
        public String ComputerCharacter_choice_rps(String playerChoice, Random objRandom) {
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
                    return "ERROR!!! Computer picked an unregistered option!";
            }
        }
    }

    /**
     * Rules and game evaluation:
     * - returnResultPlayer1: returns result code (1: P1 wins, 2: P2 wins, 3: tie, 4: invalid)
     * - allocatePointsToPlayers: assigns points and prints debug output
     * - checkWin: checks whether a player reached the points goal
     */
    class Rules {

        /**
         * Compares both players' moves and returns a result code.
         *
         * @param player1Choice move of player 1
         * @param player2Choice move of player 2
         * @return 3 = tie, 1 = player1 wins, 2 = player2 wins, 4 = invalid input
         */
        public static int returnResultPlayer1(String player1Choice, String player2Choice) {
            if (player1Choice.equals(player2Choice)) {
                winner = "no player";
                return 3;
            } else if ((player1Choice.equals(SCISSORS) && player2Choice.equals(PAPER)) ||
                    (player1Choice.equals(PAPER) && player2Choice.equals(ROCK)) ||
                    (player1Choice.equals(ROCK) && player2Choice.equals(SCISSORS))) {
                winner = "player 1";
                return 1;
            } else if ((player2Choice.equals(SCISSORS) && player1Choice.equals(PAPER)) ||
                    (player2Choice.equals(PAPER) && player1Choice.equals(ROCK)) ||
                    (player2Choice.equals(ROCK) && player1Choice.equals(SCISSORS))) {
                winner = "player 2";
                return 2;
            } else {
                return 4;
            }
        }

        /**
         * Allocates points according to the result code and prints debug information.
         *
         * @param player1Choice move of player 1
         * @param player2Choice move of player 2
         * @param player1       Player object 1
         * @param player2       Player object 2
         */
        public static void allocatePointsToPlayers(String player1Choice, String player2Choice, Player player1, Player player2) {
            caseResult = returnResultPlayer1(player1Choice, player2Choice);

            System.out.println("--------------------");
            System.out.println("Debug: " + player1.getPlayerName() + " chose " + player1Choice + ", " + player2.getPlayerName() + " chose " + player2Choice);
            System.out.println("Debug: Result is " + caseResult);

            switch (caseResult) {
                case 1:
                    System.out.println(winner + " wins");
                    pointsP1++;
                    break;
                case 2:
                    System.out.println(winner + " wins");
                    pointsP2++;
                    break;
                case 3:
                    System.out.println("Tie");
                    break;
                default:
                    System.out.println("Debug:\tSOME ERROR OCCURRED 2!!!");
                    break;
            }

            System.out.println();
            System.out.println("Debug: Current scores - " + player1.getPlayerName() + ": " + pointsP1 + ", " + player2.getPlayerName() + ": " + pointsP2);
            System.out.println("--------------------");
        }

        /**
         * Checks if one of the players reached pointsGoal and sets readable winner name.
         *
         * @param player1 player1 object
         * @param player2 player2 object
         * @return true if a winner exists, false otherwise
         */
        public static boolean checkWin(Player player1, Player player2) {
            if (pointsP1 == pointsGoal) {
                winner = player1.getPlayerName();
                return true;
            } else if (pointsP2 == pointsGoal) {
                winner = player2.getPlayerName();
                return true;
            } else {
                return false;
            }
        }

        /**
         * Example enum for demonstration (not used).
         */
        enum Test {
            LOW,
            MEDIUM,
            HIGH
        }
    }

    /**
     * Generates a random five-digit number (e.g. for player ID).
     *
     * @return int between 10000 and 99999
     */
    public static int randomFiveDigitNumber() {
        return 10000 + (int) (Math.random() * 90000);
    }

    /**
     * Validates the length of a string (e.g. player name). Keeps asking until length <= 15.
     *
     * @param someString input string (name)
     * @param objScanner scanner for re-entry
     */
    public static void validateStringLength(String someString, Scanner objScanner) {
        while (someString.length() > 15) {
            System.out.println("The name must not be longer than 15 characters!");
            System.out.println("Try again: ");
            someString = objScanner.nextLine();
        }
    }

    /**
     * Checks whether the provided move is valid (ROCK, PAPER or SCISSORS).
     *
     * @param playerChoice chosen move
     * @return true if valid, otherwise false
     */
    public static boolean checkPlayerChoice(String playerChoice) {
        return playerChoice.equals(ROCK) || playerChoice.equals(PAPER) || playerChoice.equals(SCISSORS);
    }

    /**
     * Creates a computer player with fixed name "Computer".
     *
     * @param objRPS     RPS instance for inner-class instantiation
     * @param objScanner scanner (kept in signature though not needed)
     * @return new Player object (actually ComputerCharacter)
     */
    public static Player createPlayersComputer(RPS objRPS, Scanner objScanner) {
        String playerName = "Computer";
        System.out.println(playerName);
        Player objComputerCharacter = objRPS.new ComputerCharacter(playerName, randomFiveDigitNumber());
        return objComputerCharacter;
    }

    /**
     * Creates a human player: reads name from scanner and validates length.
     *
     * @param objRPS     RPS instance
     * @param objScanner scanner for input
     * @return new Player object
     */
    public static Player createPlayers(RPS objRPS, Scanner objScanner) {
        System.out.println("Please enter a name (max. 15 characters): ");
        String playerName = objScanner.nextLine();
        validateStringLength(playerName, objScanner);
        Player player = objRPS.new Player(playerName, randomFiveDigitNumber());
        return player;
    }

    /**
     * Reads desired points goal from scanner and stores it in the player object.
     *
     * @param objScanner scanner for input
     * @param player     player whose gameModeInput is set
     */
    public static void choosePointsGoal(Scanner objScanner, Player player) {
        System.out.println("Choose a game mode: ");
        System.out.println("Up to how many points do you want to play to?: ");
        player.setGameModeInput(objScanner.nextInt());
        objScanner.nextLine(); // consume remaining newline
    }

    /**
     * For a computer player: randomly choose a points goal between 1 and 5.
     *
     * @param player    player object (computer)
     * @param objRandom random instance
     */
    public static void choosePointsGoalComputer(Player player, Random objRandom) {
        System.out.println("Choose a game mode: ");
        System.out.println("Up to how many points do you want to play to?: ");
        player.setGameModeInput(objRandom.nextInt(1, 6)); // 1..5 inclusive
        System.out.println(player.getGameModeInput());
    }

    /**
     * Prompts the human player for a move and validates input.
     *
     * @param objScanner  scanner for user input
     * @param playerChoice placeholder string (will be overwritten)
     * @return validated, uppercase move
     */
    public static String printPlayerChoice(Scanner objScanner, String playerChoice) {
        System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
        playerChoice = objScanner.nextLine().toUpperCase();
        while (!checkPlayerChoice(playerChoice)) {
            System.out.println("Wrong input! Please enter ROCK, PAPER or SCISSORS!");
            System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
            playerChoice = objScanner.nextLine().toUpperCase();
        }
        System.out.println();
        return playerChoice;
    }

    /**
     * Gets a move from a computer player (retries if invalid for some reason).
     *
     * @param objRandom    random instance
     * @param playerChoice placeholder string
     * @param player       player object (expected to be ComputerCharacter)
     * @return valid move
     */
    public static String printPlayerChoiceComputer(Random objRandom, String playerChoice, Player player) {
        System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
        playerChoice = callComputerChoice(player, playerChoice, objRandom);
        while (!checkPlayerChoice(playerChoice)) {
            System.out.println("Wrong input! Please enter ROCK, PAPER or SCISSORS!");
            System.out.print("Make your choice:\tROCK\tPAPER\tSCISSORS\n->");
            playerChoice = callComputerChoice(player, playerChoice, objRandom);
        }
        System.out.println(playerChoice);
        return playerChoice;
    }

    /**
     * Helper: calls the computer-specific choice method if player is instance of ComputerCharacter.
     *
     * @param player       player object
     * @param playerChoice placeholder
     * @param objRandom    random instance
     * @return chosen move or an error string
     */
    private static String callComputerChoice(Player player, String playerChoice, Random objRandom) {
        if (player instanceof ComputerCharacter) {
            return ((ComputerCharacter) player).ComputerCharacter_choice_rps(playerChoice, objRandom);
        } else {
            System.out.println("The player is not a computer object");
            return "ERROR_UNKNOWN";
        }
    }

    /**
     * Main method: controls game flow and user interaction.
     * Flow:
     * - Main loop: ask if user wants to start
     * - Choose player mode
     * - Create players
     * - Choose points goal (each player picks a number; if different, a random choice is used)
     * - Play rounds until a player reaches the points goal
     * - Offer to play again
     */
    public static void main(String[] args) throws Exception {
        RPS objRPS = new RPS();
        GameModes objGameModes = objRPS.new GameModes();
        Random objRandom = new Random();
        Scanner objScanner = new Scanner(System.in);

        String player1Choice;
        String player2Choice;
        String startAnotherGame;

        System.out.println("WELCOME TO ROCK PAPER SCISSORS!");
        System.out.println("Do you want to start the Game?");
        System.out.println("Press 1 or 2! _______     _______");
        System.out.println("             | 1.Yes |   | 2.No  |");
        System.out.println("             |_______|   |_______|");

        startAnotherGame = objScanner.nextLine().toLowerCase();

        do {
            System.out.println("                                 ____________________     ____________________     ____________________");
            System.out.println("Choose Player Mode:             | 1.Player vs Player |   | 2.Player vs Entity |   | 3.Entity vs Entity |");
            System.out.println("Select the associated number!   |____________________|   |____________________|   |____________________|");
            player1Choice = objScanner.nextLine();

            // While a valid mode is chosen we execute the corresponding flow
            while (GameModes.chooseTypesOfPlayers(player1Choice) == true) {

                if (pvp == true) {
                    Player player1 = createPlayers(objRPS, objScanner);
                    Player player2 = createPlayers(objRPS, objScanner);

                    System.out.println(player1.getPlayerID() + " : " + player2.getPlayerID());

                    choosePointsGoal(objScanner, player1);
                    choosePointsGoal(objScanner, player2);

                    GameModes.chooseGameMode(player1, player2, objRandom);

                    do {
                        System.out.println();
                        System.out.println("First player to reach " + pointsGoal + " points wins!");
                        System.out.println("Score: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() + "\n");

                        player1Choice = "Placeholder";
                        player1Choice = printPlayerChoice(objScanner, player1Choice);

                        player2Choice = "Placeholder";
                        player2Choice = printPlayerChoice(objScanner, player2Choice);

                        Rules.allocatePointsToPlayers(player1Choice, player2Choice, player1, player2);

                    } while (Rules.checkWin(player1, player2) != true);

                    System.out.println("Final Score: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() + "\n");

                    pvp = false;

                } else if (pve == true) {
                    Player player1 = createPlayers(objRPS, objScanner);
                    Player player2 = createPlayersComputer(objRPS, objScanner);

                    System.out.println(player1.getPlayerID() + " : " + player2.getPlayerID());

                    choosePointsGoal(objScanner, player1);
                    choosePointsGoalComputer(player2, objRandom);

                    GameModes.chooseGameMode(player1, player2, objRandom);

                    do {
                        System.out.println();
                        System.out.println("First player to reach " + pointsGoal + " points wins!");
                        System.out.println("Score: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() + "\n");

                        player1Choice = "Placeholder";
                        player1Choice = printPlayerChoice(objScanner, player1Choice);

                        player2Choice = "Placeholder";
                        player2Choice = printPlayerChoiceComputer(objRandom, player2Choice, player2);

                        Rules.allocatePointsToPlayers(player1Choice, player2Choice, player1, player2);

                    } while (Rules.checkWin(player1, player2) != true);

                    System.out.println("Final Score: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() + "\n");

                    pve = false;

                } else if (eve == true) {
                    Player player1 = createPlayersComputer(objRPS, objScanner);
                    Player player2 = createPlayersComputer(objRPS, objScanner);

                    System.out.println(player1.getPlayerID() + " : " + player2.getPlayerID());

                    choosePointsGoalComputer(player1, objRandom);
                    choosePointsGoalComputer(player2, objRandom);

                    GameModes.chooseGameMode(player1, player2, objRandom);

                    do {
                        System.out.println();
                        System.out.println("First player to reach " + pointsGoal + " points wins!");
                        System.out.println("Score: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() + "\n");

                        player1Choice = "Placeholder";
                        player1Choice = printPlayerChoiceComputer(objRandom, player1Choice, player1);

                        player2Choice = "Placeholder";
                        player2Choice = printPlayerChoiceComputer(objRandom, player2Choice, player2);

                        Rules.allocatePointsToPlayers(player1Choice, player2Choice, player1, player2);

                    } while (Rules.checkWin(player1, player2) != true);

                    System.out.println("Final Score: \t" + player1.getPlayerName() + ":    " + pointsP1 + ":" + pointsP2 + "    :" + player2.getPlayerName() + "\n");

                    eve = false;

                } else {
                    System.out.println("Debug: ERROR!!! Selecting Player Mode went wrong! Try again!");
                }

                /* Reset points before the next mode or next game */
                pointsP1 = 0;
                pointsP2 = 0;
            }

            System.out.println("Do you want to start another game?");
            System.out.println("Press 1 or 2! _______     _______");
            System.out.println("             | 1.Yes |   | 2.No  |");
            System.out.println("             |_______|   |_______|");

            startAnotherGame = objScanner.nextLine().toLowerCase();

        } while (startAnotherGame.equals("1"));

        objScanner.close();
    }
}


