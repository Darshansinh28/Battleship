/**
 * Class containing methods for initializing the human player and handling human player actions.
 * This class provides functionality for the human player to set up their ships and grenades on the game board,
 * as well as launching rockets to attack the computer player's ships and grenades.
 *
 * @author Darshansinh Dilipsinh Devda (40261713)
 * @author Pranaykumar Chauhan Rajeshkumar (40266722)
 * <p>
 * COMP6481
 * Assignment 1
 * Due Date : 16 Feb 2024
 */
public class HumanPlayerActions {

    /**
     * Initialize human player's ships and grenades on the game board.
     *
     * @param player The human player object to initialize.
     * @param grid The grid representing the game board.
     * @return The initialized human player object.
     */
    public static Player initializeHuman(Player player,Grid grid){

        int counter = 1;
        // Place human player's ships on the board
        for (Ship s : player.ship) {
                while (true) {
                System.out.print("Enter the coordinates of your ship #" + counter +" : ");
                String userInputshipindex = Battleship.sc.next();
                userInputshipindex = userInputshipindex.toLowerCase();
                char userShipColumnLetter = userInputshipindex.charAt(0);
                int inputshipRow = userInputshipindex.charAt(1) - '0';

                if (userShipColumnLetter >= 'a' && userShipColumnLetter <= 'h' && inputshipRow >= 1 && inputshipRow <=8){


                    int inputshipColumn=CommonFunctions.mapCharacterToIntColumn(userShipColumnLetter);
                    inputshipRow = inputshipRow - 1;

                    if (!grid.cell[inputshipRow][inputshipColumn].hasHumanShip() && !grid.cell[inputshipRow][inputshipColumn].hasHumanGrenade()){
                        s.setPosition(inputshipRow,inputshipColumn);
                        grid.cell[inputshipRow][inputshipColumn].markHumanShip();
                        break;
                    }
                    else{
                        System.out.println("sorry, coordinates already used.  try again.");
                    }
                }
                else{
                    System.out.println("sorry, coordinates outside the grid.  try again. ");
                }
            }
            counter++;
        }
        System.out.println(" ");

        counter = 1;
        // Place human player's grenades on the board
        for (Grenade g : player.grenade) {
            while (true) {
                System.out.print("Enter the coordinates of your grenade #" + counter + " :");

                String userInputgrenadeindex = Battleship.sc.next();
                userInputgrenadeindex = userInputgrenadeindex.toLowerCase();
                char userGrenadeColumnLetter = userInputgrenadeindex.charAt(0);
                int inputgrenadeRow = userInputgrenadeindex.charAt(1) - '0';

                if (userGrenadeColumnLetter >= 'a' && userGrenadeColumnLetter <= 'h' && inputgrenadeRow >= 1 && inputgrenadeRow <= 8) {

                    int inputgrenadeColumn = CommonFunctions.mapCharacterToIntColumn(userGrenadeColumnLetter);
                    inputgrenadeRow = inputgrenadeRow - 1;

                    if (!grid.cell[inputgrenadeRow][inputgrenadeColumn].hasHumanShip() && !grid.cell[inputgrenadeRow][inputgrenadeColumn].hasHumanGrenade()) {
                        g.setPosition(inputgrenadeRow, inputgrenadeColumn);
                        grid.cell[inputgrenadeRow][inputgrenadeColumn].markHumanGrenade();
                        break;
                    } else {
                        System.out.println("Sorry, coordinates already used. Try again.");
                    }
                } else {
                    System.out.println("Sorry, coordinates outside the grid. Try again.");
                }
            }
            counter++;
        }
        System.out.println(" ");
        return  player;
    }

    /**
     * Launch rockets to attack the computer player's ships and grenades.
     *
     * @param computerBoard The grid representing the computer player's board.
     * @param hiddenBoard The grid representing the hidden state of the game.
     * @param turns The number of turns for the human player.
     * @return The next turn for the human player.
     */
    public static int launchHumanRocket(Grid computerBoard, Grid hiddenBoard, int turns) {
        int nextturn = 1;
        while (turns != 0) {
            System.out.print("Please enter the coordinates for your rocket, column (A-H) and the row (1-8) :  ");
            String userInputrocketindex = Battleship.sc.next();
            userInputrocketindex = userInputrocketindex.toLowerCase();
            char userrocketColumnLetter = userInputrocketindex.charAt(0);
            int inputrocketRow = userInputrocketindex.charAt(1) - '0';

            if (userrocketColumnLetter >= 'a' && userrocketColumnLetter <= 'h' && inputrocketRow >= 1 && inputrocketRow <= 8) {

                int inputrocketColumn = CommonFunctions.mapCharacterToIntColumn(userrocketColumnLetter);
                inputrocketRow = inputrocketRow - 1;

                if (computerBoard.cell[inputrocketRow][inputrocketColumn].hasComputerShip() && !hiddenBoard.cell[inputrocketRow][inputrocketColumn].hasCalled()) {
                    computerBoard.points--;
                    hiddenBoard.cell[inputrocketRow][inputrocketColumn].markComputerShip();
                    hiddenBoard.cell[inputrocketRow][inputrocketColumn].markCall();
                    System.out.println("\nYou sunk the computer's battleship!");
                } else if (computerBoard.cell[inputrocketRow][inputrocketColumn].hasComputerGrenade() && !hiddenBoard.cell[inputrocketRow][inputrocketColumn].hasCalled()) {
                    hiddenBoard.cell[inputrocketRow][inputrocketColumn].markComputerGrenade();
                    hiddenBoard.cell[inputrocketRow][inputrocketColumn].markCall();
                    nextturn = 0;
                    System.out.println("\nYou hit the computer's grenade!");
                } else if (!hiddenBoard.cell[inputrocketRow][inputrocketColumn].hasCalled()) {
                    hiddenBoard.cell[inputrocketRow][inputrocketColumn].markCall();
                }
                turns--;
                System.out.println(" ");
            } else {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
            }
        }
        return nextturn;
    }
}
