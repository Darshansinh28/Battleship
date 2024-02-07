import java.util.Random;
public class ComputerPlayerActions {
    public static void initializeComputer(Player player,Board computerBoard,Board humanBoard) {

        int counter = 1;
        for (Ship s : player.ship) {
            int column, row;
            do {
                column = Constants.randomInt(0, 7);
                row = Constants.randomInt(0, 7);
            } while (humanBoard.coordinate[row][column].hasHumanShip() || humanBoard.coordinate[row][column].hasHumanGrenade()
                    || computerBoard.coordinate[row][column].hasComputerShip() || computerBoard.coordinate[row][column].hasComputerGrenade());

            s.setPosition(row, column);
            computerBoard.coordinate[row][column].markComputerShip();
            counter++;
        }

        counter = 1;
        for (Grenade g : player.grenade) {
            int column, row;
            do {
                column = Constants.randomInt(0, 7);
                row = Constants.randomInt(0, 7);
            } while (humanBoard.coordinate[row][column].hasHumanShip() || humanBoard.coordinate[row][column].hasHumanGrenade()
                    || computerBoard.coordinate[row][column].hasComputerShip() || computerBoard.coordinate[row][column].hasComputerGrenade());

            g.setPosition(row, column);
            computerBoard.coordinate[row][column].markComputerGrenade();
            counter++;
        }
    }
}
