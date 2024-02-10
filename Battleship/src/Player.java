/**
 * Class representing a player in the game.
 * Each player has ships and grenades.
 *
 *  @author Darshansinh Dilipsinh Devda
 *  @author Pranaykumar Chauhan Rajeshkumar
 *
 */
public class Player {
    // Array to store the player's ships
    protected Ship[] ship;
    // Array to store the player's grenades
    protected Grenade[] grenade;

    /**
     * Constructor to initialize a player with default ships and grenades.
     */
    Player() {
        // Initialize the array of ships with default ships
        this.ship = new Ship[6];
        for (int i = 0; i < 6; i++) {
            ship[i] = new Ship();
        }

        // Initialize the array of grenades with default grenades
        this.grenade = new Grenade[4];
        for (int i = 0; i < 4; i++) {
            grenade[i] = new Grenade();
        }
    }

    /**
     * Get a ship at a specific index from the player's ships array.
     * @param x The index of the ship to retrieve.
     * @return The ship at the specified index.
     */
    public Ship getShip(int x) {
        return this.ship[x];
    }

    /**
     * Get a grenade at a specific index from the player's grenades array.
     * @param x The index of the grenade to retrieve.
     * @return The grenade at the specified index.
     */
    public Grenade getGrenade(int x) {
        return this.grenade[x];
    }
}
