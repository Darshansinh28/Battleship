import java.util.Scanner;

public class Battleship {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Hi,  let's play Battleship!");


        Board hiddenBoard = new Board();
        Board humanboard = new Board();
        Board computerboard = new Board();

        Player human = HumanPlayerActions.initializeHuman(new Player(),humanboard);
        Player computer = ComputerPlayerActions.initializeComputer(new Player(),computerboard);


        System.out.println("Here is your reference for this game : \n");
        showBoard(humanboard);
        showBoard(computerboard);

        while (true){
            if (humanboard.points == 0 || computerboard.points == 0 ){
                System.out.println("GAME OVER!\n");
                showBoard(hiddenBoard);
                System.exit(0);
            }

            launchHumanRocket (computerboard, hiddenBoard);
            launchComputerRocket (humanboard, hiddenBoard);

            //Display board showing results of rocket launches after each turn
            showBoard(hiddenBoard);

            // Display the points at the end of each turn
            System.out.println("Human points: " + humanboard.points);
            System.out.println("Computer points: " + computerboard.points + "\n");
        }


    }

    public static void launchHumanRocket(Board computerBoard,Board hiddenBoard){
        System.out.print("Please enter the coordinates for your rocket, column (A-H) and the row (1-8) :  ");
        String userInputrocketindex = sc.next();
        userInputrocketindex = userInputrocketindex.toLowerCase();
        char userrocketColumnLetter = userInputrocketindex.charAt(0);
        int inputrocketRow = userInputrocketindex.charAt(1) - '0';

        if (userrocketColumnLetter >= 'a' && userrocketColumnLetter <= 'h' && userrocketColumnLetter >= 1 && userrocketColumnLetter <= 8) {

            int inputrocketColumn = Constants.mapCharacterToIntColumn(userrocketColumnLetter);
            inputrocketRow = inputrocketRow - 1;

            if (computerBoard.coordinate[inputrocketRow][inputrocketColumn].hasComputerShip()){
                computerBoard.points--;
                hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markComputerShip();
                System.out.println("\nYou sunk the computer's battleship!");
            }else if (computerBoard.coordinate[inputrocketRow][inputrocketColumn].hasComputerGrenade()) {
                hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markComputerGrenade();
                System.out.println("\nYou hit the computer's grenade!");
            }
            else {hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markCall(); }

            System.out.println(" ");
        } else {
            System.out.println("Sorry, coordinates outside the grid. Try again.");
        }

    }
    public static void launchComputerRocket(Board humanBoard,Board hiddenBoard){
        System.out.print("Please enter the coordinates for your rocket, column (A-H) and the row (1-8) :  ");

        int computerRandomrow = Constants.randomInt(0, 7);
        int computerRandomcolumn = Constants.randomInt(0, 7);
        char characterComputerColumn = Constants.mapIntColumnToCharacter(computerRandomcolumn);

        System.out.println("Computer's rocket: (" + (characterComputerColumn) + " , " + (computerRandomrow+1) + ")\n");

        if (humanBoard.coordinate[computerRandomrow][computerRandomcolumn].hasPlayerShip()){
            humanBoard.points--;
            hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markPlayerShip();
            System.out.println("\nYou sunk the Human's battleship!");
        }else if (humanBoard.coordinate[computerRandomrow][computerRandomcolumn].hasPlayerGrenade()) {
            hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markPlayerGrenade();
            System.out.println("\nYou hit the Human's grenade!");
        }
        else {
            hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markCall();
        }
        System.out.println(" ");
    }

    public static void showBoard(Board b) {

        System.out.println("   A  B  C  D  E  F  G  H");


        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (y==0) {
                    System.out.print((x+1) + "  " +b.coordinate[x][y]);
                }
                else {
                    System.out.print("  " + b.coordinate[x][y]);
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

}
