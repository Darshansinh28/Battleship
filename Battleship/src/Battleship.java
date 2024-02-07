import java.util.Scanner;

public class Battleship {

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
            System.out.println("Compu points: " + computerboard.points + "\n");
        }


    }

    public static void launchHumanRocket(Board computer,Board hiddenBoard){
        System.out.print("Please enter the coordinates for your rocket, column (A-H) and the row (1-8) :  ");

    }
    public static void launchComputerRocket(Board human,Board hiddenBoard){
        System.out.print("Please enter the coordinates for your rocket, column (A-H) and the row (1-8) :  ");

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
