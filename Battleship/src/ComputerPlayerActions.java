import java.util.Random;
public class ComputerPlayerActions {
    public static Player initializeComputer(Player player,Board computerBoard,Board humanBoard) {

        for (Ship s : player.ship) {
            int column, row;
            while(true) {
                column = Constants.randomInt(0, 7);
                row = Constants.randomInt(0, 7);
                if (!humanBoard.coordinate[row][column].hasHumanShip() && !humanBoard.coordinate[row][column].hasHumanGrenade()
                        && !computerBoard.coordinate[row][column].hasComputerShip() && !computerBoard.coordinate[row][column].hasComputerGrenade()){
                    s.setPosition(row, column);
                    computerBoard.coordinate[row][column].markComputerShip();
                    break;
                }
            }


        }

        for (Grenade g : player.grenade) {
            int column, row;
            while(true) {
                column = Constants.randomInt(0, 7);
                row = Constants.randomInt(0, 7);
                if (!humanBoard.coordinate[row][column].hasHumanShip() && !humanBoard.coordinate[row][column].hasHumanGrenade()
                        && !computerBoard.coordinate[row][column].hasComputerShip() && !computerBoard.coordinate[row][column].hasComputerGrenade()){
                    g.setPosition(row, column);
                    computerBoard.coordinate[row][column].markComputerGrenade();
                    break;
                }
            }


        }
        return player;
    }
}
