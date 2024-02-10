import java.util.Scanner;

/**
 * The main method for handling game setup and control flow.
 *
 *  @author Darshansinh Dilipsinh Devda
 *  @author Pranaykumar Chauhan Rajeshkumar
 *
 */
public class Battleship {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Display initial message
        System.out.println("Hi,  let's play Battleship!");

        // Initialize game boards for human, computer, and hidden
        Grid hiddenBoard = new Grid(); // The hidden board where the players play the game.
        Grid humanBoard = new Grid(); // The human player's visible board
        Grid computerBoard = new Grid(); // The computer player's visible board

        // Initialize human and computer players
        Player human = HumanPlayerActions.initializeHuman(new Player(), humanBoard);
        Player computer = ComputerPlayerActions.initializeComputer(new Player(), computerBoard, humanBoard);

        // Display reference boards for the game
        System.out.println("Here is your reference for this game : \n");
        showBoard(humanBoard);
//        showBoard(computerBoard);

        // Initialize turn counters
        int humanTurn = 1;
        int computerTurn = 1;

        // Main game loop
        while (true) {
            // Check if either player has won
            if (humanBoard.points == 0 || computerBoard.points == 0) {
                if (computerBoard.points == 0){
                    System.out.println("Human player won the game!"); // Display winning message if human player wins
                } else {
                    System.out.println("Sorry! You lost the game"); // Display losing message if human player loses
                }
                System.out.println("GAME OVER!\n");
//                showFinalResult(humanBoard, computerBoard, human, computer);
                showBoard(hiddenBoard);
                System.exit(0);
            }

            // Execute human and computer turns
            humanTurn = HumanPlayerActions.launchHumanRocket(computerBoard, hiddenBoard, humanTurn);
            computerTurn = ComputerPlayerActions.launchComputerRocket(humanBoard, hiddenBoard, computerTurn);

            // Display updated hidden board and player points
            showBoard(hiddenBoard);
            System.out.println("Human points: " + humanBoard.points);
            System.out.println("Computer points: " + computerBoard.points + "\n");
        }
    }

    /**
     * Display the current state of the game board.
     * This method prints the grid representing the current state of the game, including ships, grenades,
     * and empty positions. It formats the grid with row and column labels and displays the contents of
     * each cell.
     *
     * @param grid The grid representing the current state of the game.
     */
    public static void showBoard(Grid grid) {

        System.out.println("   A  B  C  D  E  F  G  H");

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (y == 0) {
                    System.out.print((x + 1) + "  " + grid.cell[x][y]);
                } else {
                    System.out.print("  " + grid.cell[x][y]);
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

//    /**
//     * Display the final result of the game, showing the positions of ships and grenades.
//     *
//     * @param humanBoard The human player's board.
//     * @param computerboard The computer player's board.
//     * @param human The human player.
//     * @param computer The computer player.
//     */
//    public static void showFinalResult(Grid humanBoard, Grid computerboard, Player human, Player computer) {
//        Grid finalSampleBoard = new Grid();
//        for (Ship s : human.ship) {
//            finalSampleBoard.cell[s.row][s.column].markHumanShip();
//        }
//        for (Grenade g : human.grenade) {
//            finalSampleBoard.cell[g.row][g.column].markHumanGrenade();
//        }
//
//        for (Ship s : computer.ship) {
//            finalSampleBoard.cell[s.row][s.column].markComputerShip();
//        }
//        for (Grenade g : computer.grenade) {
//            finalSampleBoard.cell[g.row][g.column].markComputerGrenade();
//        }
//        showBoard(finalSampleBoard);
//    }

}
