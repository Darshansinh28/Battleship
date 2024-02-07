import java.util.Scanner;

public class HumanPlayerActions {
    public static Player initializeHuman(Player player,Board board){
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        for (Ship s : player.ship) {
                while (counter <= 6) {
                System.out.println("Enter the coordinates of your ship #" + counter +" : ");
                String userInputshipindex = sc.next();
                userInputshipindex = userInputshipindex.toLowerCase();
                char userShipColumnLetter = userInputshipindex.charAt(0);
                int inputshipRow = userInputshipindex.charAt(1) - '0';

                if (userShipColumnLetter >= 'a' && userShipColumnLetter <= 'h' && inputshipRow >= 1 && inputshipRow <=8){
                    int inputshipColumn=0;

                    switch (userShipColumnLetter) {
                        case 'a': inputshipColumn = 0;
                            break;
                        case 'b': inputshipColumn = 1;
                            break;
                        case 'c': inputshipColumn = 2;
                            break;
                        case 'd': inputshipColumn = 3;
                            break;
                        case 'e': inputshipColumn = 4;
                            break;
                        case 'f': inputshipColumn = 5;
                            break;
                        case 'g': inputshipColumn = 6;
                            break;
                        case 'h': inputshipColumn = 7;
                            break;
                    };

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

                String userInputgrenadeindex = sc.next();
                userInputgrenadeindex = userInputgrenadeindex.toLowerCase();
                char userGrenadeColumnLetter = userInputgrenadeindex.charAt(0);
                int inputgrenadeRow = userInputgrenadeindex.charAt(1) - '0';

                if (userGrenadeColumnLetter >= 'a' && userGrenadeColumnLetter <= 'h' && inputgrenadeRow >= 1 && inputgrenadeRow <= 8) {
                    int inputgrenadeColumn = 0;

                    switch (userGrenadeColumnLetter) {
                        case 'a':
                            inputgrenadeColumn = 0;
                            break;
                        case 'b':
                            inputgrenadeColumn = 1;
                            break;
                        case 'c':
                            inputgrenadeColumn = 2;
                            break;
                        case 'd':
                            inputgrenadeColumn = 3;
                            break;
                        case 'e':
                            inputgrenadeColumn = 4;
                            break;
                        case 'f':
                            inputgrenadeColumn = 5;
                            break;
                        case 'g':
                            inputgrenadeColumn = 6;
                            break;
                        case 'h':
                            inputgrenadeColumn = 7;
                            break;
                    }

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
