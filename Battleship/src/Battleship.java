import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Hi,  let's play Battleship!");


        Player human = HumanPlayerActions.initializeHuman(new Player());
        Player computer = ComputerPlayerActions.initializeComputer(new Player());

        System.out.println("here");
    }

}
