import java.util.Scanner;

public class HumanPlayerActions {
    public static Player initializeHuman(Player player,Board board){

        int counter = 1;
        for (Ship s : player.ship) {
                while (true) {
                System.out.print("Enter the coordinates of your ship #" + counter +" : ");
                String userInputshipindex = Battleship.sc.next();
                userInputshipindex = userInputshipindex.toLowerCase();
                char userShipColumnLetter = userInputshipindex.charAt(0);
                int inputshipRow = userInputshipindex.charAt(1) - '0';

                if (userShipColumnLetter >= 'a' && userShipColumnLetter <= 'h' && inputshipRow >= 1 && inputshipRow <=8){


                    int inputshipColumn=Constants.mapCharacterToIntColumn(userShipColumnLetter);
                    inputshipRow = inputshipRow - 1;

                    if (!board.coordinate[inputshipRow][inputshipColumn].hasHumanShip() && !board.coordinate[inputshipRow][inputshipColumn].hasHumanGrenade()){
                        s.setPosition(inputshipRow,inputshipColumn);
                        board.coordinate[inputshipRow][inputshipColumn].markHumanShip();
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

        for (Grenade g : player.grenade) {
            while (true) {
                System.out.print("Enter the coordinates of your grenade #" + counter + " :");

                String userInputgrenadeindex = Battleship.sc.next();
                userInputgrenadeindex = userInputgrenadeindex.toLowerCase();
                char userGrenadeColumnLetter = userInputgrenadeindex.charAt(0);
                int inputgrenadeRow = userInputgrenadeindex.charAt(1) - '0';

                if (userGrenadeColumnLetter >= 'a' && userGrenadeColumnLetter <= 'h' && inputgrenadeRow >= 1 && inputgrenadeRow <= 8) {

                    int inputgrenadeColumn = Constants.mapCharacterToIntColumn(userGrenadeColumnLetter);
                    inputgrenadeRow = inputgrenadeRow - 1;

                    if (!board.coordinate[inputgrenadeRow][inputgrenadeColumn].hasHumanShip() && !board.coordinate[inputgrenadeRow][inputgrenadeColumn].hasHumanGrenade()) {
                        g.setPosition(inputgrenadeRow, inputgrenadeColumn);
                        board.coordinate[inputgrenadeRow][inputgrenadeColumn].markHumanGrenade();
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

}
