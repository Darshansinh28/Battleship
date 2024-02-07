import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Hi,  let's play Battleship!");


        Board board = new Board();

        Player human = HumanPlayerActions.initializeHuman(new Player(),board);
        Player computer = ComputerPlayerActions.initializeComputer(new Player(),board);


        System.out.println("Here is your reference for this game : \n");
        showBoard(board);


    }

    public static void markBoardHuman(Board b, Player p) {
        for (int x = 0; x < 6; x++) {		//Mark the appropriate location as a human Ship
            int row = 0, col = 0;
            row = p.ship[x].row;
            col = p.ship[x].column;
            b.coordinate[col][row].markPlayerShip();
        }
        for (int x = 0; x < 4; x++) {		//Mark the appropriate location as a human Grenade
            int row = 0, col = 0;
            row = p.grenade[x].row;
            col = p.grenade[x].column;
            b.coordinate[col][row].markPlayerGrenade();
        }
    }

    public static void markBoardComputer(Board b, Player p) {
        for (int x = 0; x < 6; x++) {		//Mark the appropriate location as a computer Grenade
            int row = 0, col = 0;
            row = p.ship[x].row;
            col = p.ship[x].column;
            b.coordinate[col][row].markComputerShip();
        }
        for (int x = 0; x < 4; x++) {		//Mark the appropriate location as a computer Ship
            int row = 0, col = 0;
            row = p.grenade[x].row;
            col = p.grenade[x].column;
            b.coordinate[col][row].markComputerGrenade();
        }
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
