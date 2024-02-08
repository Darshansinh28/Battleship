import java.util.Scanner;

public class Battleship {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Hi,  let's play Battleship!");

        Board hiddenBoard = new Board();
        Board humanBoard =  new Board();
        Board computerBoard = new Board();

        Player human = HumanPlayerActions.initializeHuman(new Player(), humanBoard);
        Player computer = ComputerPlayerActions.initializeComputer(new Player(), computerBoard, humanBoard);


        System.out.println("Here is your reference for this game : \n");
        showBoard(humanBoard);
        showBoard(computerBoard);

        int humanTurn = 1;
        int computerTurn = 1;

        while (true) {
            if (humanBoard.points == 0 || computerBoard.points == 0) {
                if (computerBoard.points == 0){
                    System.out.println("🎉 Congratulations! Human player won the game! 🎉");

                }else{
                    System.out.println("🎉 Congratulations! Computer player won the game! 🎉");
                }
                System.out.println("GAME OVER!\n");
                showFinalResult(humanBoard, computerBoard, human, computer);
                System.exit(0);
            }
            humanTurn = launchHumanRocket(computerBoard, hiddenBoard, humanTurn);
            computerTurn = launchComputerRocket(humanBoard, hiddenBoard, computerTurn);
            showBoard(hiddenBoard);
            System.out.println("Human points: " + humanBoard.points);
            System.out.println("Computer points: " + computerBoard.points + "\n");
        }
    }

    public static int launchHumanRocket(Board computerBoard, Board hiddenBoard, int turns) {
        int nextturn = 1;
        while (turns != 0) {
            System.out.print("Please enter the coordinates for your rocket, column (A-H) and the row (1-8) :  ");
            String userInputrocketindex = sc.next();
            userInputrocketindex = userInputrocketindex.toLowerCase();
            char userrocketColumnLetter = userInputrocketindex.charAt(0);
            int inputrocketRow = userInputrocketindex.charAt(1) - '0';

            if (userrocketColumnLetter >= 'a' && userrocketColumnLetter <= 'h' && inputrocketRow >= 1 && inputrocketRow <= 8) {

                int inputrocketColumn = Constants.mapCharacterToIntColumn(userrocketColumnLetter);
                inputrocketRow = inputrocketRow - 1;

                if (computerBoard.coordinate[inputrocketRow][inputrocketColumn].hasComputerShip() && !hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].hasCalled()) {
                    computerBoard.points--;
                    hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markComputerShip();
                    hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markCall();
                    System.out.println("\nYou sunk the computer's battleship!");
                } else if (computerBoard.coordinate[inputrocketRow][inputrocketColumn].hasComputerGrenade() && !hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].hasCalled()) {
                    hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markComputerGrenade();
                    hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markCall();
                    nextturn = 0;
                    System.out.println("\nYou hit the computer's grenade!");
                } else if (!hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].hasCalled()) {
                    hiddenBoard.coordinate[inputrocketRow][inputrocketColumn].markCall();
                }
                turns--;
                System.out.println(" ");
            } else {
                System.out.println("Sorry, coordinates outside the grid. Try again.");
            }
        }
        return nextturn;
    }

    public static int launchComputerRocket(Board humanBoard, Board hiddenBoard, int turns) {
        int nextturn = 1;
        while (turns != 0) {

            int computerRandomrow = Constants.randomInt(0, 7);
            int computerRandomcolumn = Constants.randomInt(0, 7);
            char characterComputerColumn = Constants.mapIntColumnToCharacter(computerRandomcolumn);

            System.out.println("Computer's rocket: (" + (characterComputerColumn) + " , " + (computerRandomrow + 1) + ")\n");

            if (humanBoard.coordinate[computerRandomrow][computerRandomcolumn].hasHumanShip() && !hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].hasCalled()) {
                humanBoard.points--;
                hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markHumanShip();
                hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markCall();
                System.out.println("\nYou sunk the Human's battleship!");
            } else if (humanBoard.coordinate[computerRandomrow][computerRandomcolumn].hasHumanGrenade() && !hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].hasCalled()) {
                hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markHumanGrenade();
                hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markCall();
                nextturn = 0;
                System.out.println("\nYou hit the Human's grenade!");
            } else if (!hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].hasCalled()) {
                hiddenBoard.coordinate[computerRandomrow][computerRandomcolumn].markCall();
            }
            turns--;
            System.out.println(" ");
        }
        return nextturn;
    }

    public static void showBoard(Board board) {

        System.out.println("   A  B  C  D  E  F  G  H");

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (y == 0) {
                    System.out.print((x + 1) + "  " + board.coordinate[x][y]);
                } else {
                    System.out.print("  " + board.coordinate[x][y]);
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void showFinalResult(Board humanBoard, Board computerboard, Player human, Player computer) {
        Board finalSampleBoard = new Board();
        for (Ship s : human.ship) {
            finalSampleBoard.coordinate[s.row][s.column].markHumanShip();
        }
        for (Grenade g : human.grenade) {
            finalSampleBoard.coordinate[g.row][g.column].markHumanGrenade();
        }

        for (Ship s : computer.ship) {
            finalSampleBoard.coordinate[s.row][s.column].markComputerShip();
        }
        for (Grenade g : computer.grenade) {
            finalSampleBoard.coordinate[g.row][g.column].markComputerGrenade();
        }
        showBoard(finalSampleBoard);
    }

}
