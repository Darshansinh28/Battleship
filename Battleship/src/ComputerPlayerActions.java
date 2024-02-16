/**
 * Class containing methods for initializing the computer player and handling computer player actions.
 * This class provides functionality for placing computer player's ships and grenades on the game board,
 * as well as launching rockets to attack the human player's ships and grenades.
 *
 * @author Darshansinh Dilipsinh Devda (40261713)
 * @author Pranaykumar Chauhan Rajeshkumar (40266722)
 * <p>
 * COMP6481
 * Assignment 1
 * Due Date : 16 Feb 2024
 */
public class ComputerPlayerActions {

    /**
     * Initialize computer player's ships and grenades on the game board.
     *
     * @param player The computer player object to initialize.
     * @param computerBoard The grid representing the computer player's board.
     * @param humanBoard The grid representing the human player's board.
     * @return The initialized computer player object.
     */
    public static Player initializeComputer(Player player,Grid computerBoard,Grid humanBoard) {
        // Place computer player's ships on the board
        for (Ship s : player.ship) {
            int column, row;
            while(true) {
                column = CommonFunctions.randomInt(0, 7);
                row = CommonFunctions.randomInt(0, 7);
                if (!humanBoard.cell[row][column].hasHumanShip() && !humanBoard.cell[row][column].hasHumanGrenade()
                        && !computerBoard.cell[row][column].hasComputerShip() && !computerBoard.cell[row][column].hasComputerGrenade()){
                    s.setPosition(row, column);
                    computerBoard.cell[row][column].markComputerShip();
                    break;
                }
            }
        }
        // Place computer player's grenades on the board
        for (Grenade g : player.grenade) {
            int column, row;
            while(true) {
                column = CommonFunctions.randomInt(0, 7);
                row = CommonFunctions.randomInt(0, 7);
                if (!humanBoard.cell[row][column].hasHumanShip() && !humanBoard.cell[row][column].hasHumanGrenade()
                        && !computerBoard.cell[row][column].hasComputerShip() && !computerBoard.cell[row][column].hasComputerGrenade()){
                    g.setPosition(row, column);
                    computerBoard.cell[row][column].markComputerGrenade();
                    break;
                }
            }
        }
        return player;
    }

    /**
     * Launch rockets to attack the human player's ships and grenades.
     *
     * @param humanBoard The grid representing the human player's board.
     * @param hiddenBoard The grid representing the hidden state of the game.
     * @param turns The number of turns for the computer player.
     * @return The next turn for the computer player.
     */
    public static int launchComputerRocket(Grid humanBoard, Grid hiddenBoard, int turns) {
        int nextturn = 1;
        while (turns != 0) {

            int computerRandomrow = CommonFunctions.randomInt(0, 7);
            int computerRandomcolumn = CommonFunctions.randomInt(0, 7);
            char characterComputerColumn = CommonFunctions.mapIntColumnToCharacter(computerRandomcolumn);

            System.out.println("Computer's rocket: (" + (characterComputerColumn) + " , " + (computerRandomrow + 1) + ")\n");

            if (humanBoard.cell[computerRandomrow][computerRandomcolumn].hasHumanShip() && !hiddenBoard.cell[computerRandomrow][computerRandomcolumn].hasCalled()) {
                humanBoard.points--;
                hiddenBoard.cell[computerRandomrow][computerRandomcolumn].markHumanShip();
                hiddenBoard.cell[computerRandomrow][computerRandomcolumn].markCall();
                System.out.println("\nYou sunk the Human's battleship!");
            } else if (humanBoard.cell[computerRandomrow][computerRandomcolumn].hasHumanGrenade() && !hiddenBoard.cell[computerRandomrow][computerRandomcolumn].hasCalled()) {
                hiddenBoard.cell[computerRandomrow][computerRandomcolumn].markHumanGrenade();
                hiddenBoard.cell[computerRandomrow][computerRandomcolumn].markCall();
                nextturn = 0;
                System.out.println("\nYou hit the Human's grenade!");
            } else if (!hiddenBoard.cell[computerRandomrow][computerRandomcolumn].hasCalled()) {
                hiddenBoard.cell[computerRandomrow][computerRandomcolumn].markCall();
            }
            turns--;
            System.out.println(" ");
        }
        return nextturn;
    }
}
