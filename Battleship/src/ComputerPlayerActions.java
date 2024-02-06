import java.util.Random;
public class ComputerPlayerActions {
    public static Player initializeComputer(Player player){

        for (int i = 0; i < 6; i++) {
            player.ship[i].column = randInt(0,7);
            player.ship[i].row = randInt(0,7);
        }
        for (int i = 0; i < 4; i++) {
            player.grenade[i].column = randInt(0,7);
            player.grenade[i].row = randInt(0,7);
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
