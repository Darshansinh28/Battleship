import java.util.Scanner;

public class HumanPlayerActions {
    public static Player initializeHuman(Player player){
        Scanner sc = new Scanner(System.in);
        int counter = 1;

        while (counter < 7) {
            System.out.println("Enter the coordinates of your ship #" + counter +" : \n");
            for (Ship s : player.ship) {

                String shipColAlpha = sc.next();
                shipColAlpha = shipColAlpha.toLowerCase();

                int inputshipColumn= Constants.map(shipColAlpha.substring(0,1));
                int inputshipRow =Integer.parseInt(shipColAlpha.substring(1,2));
                inputshipRow = inputshipRow - 1;
                s.setPosition(inputshipRow,inputshipColumn);
                counter++;
            }

            System.out.println(" ");
        }


        counter = 1;
        while (counter < 4) {
            System.out.println("Enter the coordinates of your grenades #" + counter +" : \n");
            for (Grenade g : player.grenade) {

                String grenadeColAlpha = sc.next();
                grenadeColAlpha = grenadeColAlpha.toLowerCase();

                int inputgrenadeColumn= Constants.map(grenadeColAlpha.substring(0,1));
                int inputgrenadeRow =Integer.parseInt(grenadeColAlpha.substring(1,2));


                inputgrenadeRow = inputgrenadeRow - 1;

                g.setPosition(inputgrenadeRow, inputgrenadeColumn);
                counter++;
            }
        }
        System.out.println(" ");
        return player;
    }
}
