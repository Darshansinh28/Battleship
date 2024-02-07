import java.util.Random;
public class ComputerPlayerActions {
    public static Player initializeComputer(Player player,Board board){

    int counter = 1;
        for (Ship s : player.ship) {
            int column, row;
            do {
                column = randInt(0, 7);
                row = randInt(0, 7);
            } while (board.coordinate[row][column].hasPlayerShip() || board.coordinate[row][column].hasPlayerGrenade()
                    || board.coordinate[row][column].hasComputerShip() || board.coordinate[row][column].hasComputerGrenade());

            s.setPosition(row, column);
            board.coordinate[row][column].markComputerShip();
            counter++;
        }

        counter = 1;
        for (Grenade g : player.grenade) {
            int column, row;
            do {
                column = randInt(0, 7);
                row = randInt(0, 7);
            } while (board.coordinate[row][column].hasPlayerShip() || board.coordinate[row][column].hasPlayerGrenade()
                    || board.coordinate[row][column].hasComputerShip() || board.coordinate[row][column].hasComputerGrenade());

                g.setPosition(row, column);
                board.coordinate[row][column].markComputerGrenade();
                counter++;
        }
        return player;
    }

    public static int randInt (int min, int max) {

        Random randomizer = new Random();
        int randomInt = 0;
        randomInt = randomizer.nextInt((max-min) + 1) + min;
        return randomInt;
    }
}
