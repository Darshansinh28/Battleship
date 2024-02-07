import java.util.Scanner;

public class HumanPlayerActions {
    public static Player initializeHuman(Player player,Board board){

        int counter = 1;
        for (Ship s : player.ship) {
                while (counter <= 6) {
                System.out.println("Enter the coordinates of your ship #" + counter +" : ");
                String userInputshipindex = Battleship.sc.next();
                userInputshipindex = userInputshipindex.toLowerCase();
                char userShipColumnLetter = userInputshipindex.charAt(0);
                int inputshipRow = userInputshipindex.charAt(1) - '0';

                if (userShipColumnLetter >= 'a' && userShipColumnLetter <= 'h' && inputshipRow >= 1 && inputshipRow <=8){


                    int inputshipColumn=Constants.mapCharacterToIntColumn(userShipColumnLetter);
                    inputshipRow = inputshipRow - 1;

                    if (!board.coordinate[inputshipRow][inputshipColumn].hasPlayerShip() && !board.coordinate[inputshipRow][inputshipColumn].hasPlayerGrenade()){
                        s.setPosition(inputshipRow,inputshipColumn);
                        board.coordinate[inputshipRow][inputshipColumn].markPlayerShip();
                        counter++;
                    }
                    else{
                        System.out.println("sorry, coordinates already used.  try again.");
                    }
                }
                else{
                    System.out.println("sorry, coordinates outside the grid.  try again. ");
                }



            }

            System.out.println(" ");
        }


        counter = 1;

        for (Grenade g : player.grenade) {
            while (counter <= 4) {
                System.out.println("Enter the coordinates of your grenade #" + counter + " :");

                String userInputgrenadeindex = Battleship.sc.next();
                userInputgrenadeindex = userInputgrenadeindex.toLowerCase();
                char userGrenadeColumnLetter = userInputgrenadeindex.charAt(0);
                int inputgrenadeRow = userInputgrenadeindex.charAt(1) - '0';

                if (userGrenadeColumnLetter >= 'a' && userGrenadeColumnLetter <= 'h' && inputgrenadeRow >= 1 && inputgrenadeRow <= 8) {

                    int inputgrenadeColumn = Constants.mapCharacterToIntColumn(userGrenadeColumnLetter);
                    inputgrenadeRow = inputgrenadeRow - 1;

                    if (!board.coordinate[inputgrenadeRow][inputgrenadeColumn].hasPlayerShip() && !board.coordinate[inputgrenadeRow][inputgrenadeColumn].hasPlayerGrenade()) {
                        g.setPosition(inputgrenadeRow, inputgrenadeColumn);
                        board.coordinate[inputgrenadeRow][inputgrenadeColumn].markPlayerGrenade();
                        counter++; // Increment counter when a valid grenade position is entered
                    } else {
                        System.out.println("Sorry, coordinates already used. Try again.");
                    }
                } else {
                    System.out.println("Sorry, coordinates outside the grid. Try again.");
                }
            }
        }
        System.out.println(" ");

        return player;
    }

}
