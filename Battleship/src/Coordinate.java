public class Coordinate {

    private boolean playerHasShip, playerHasGrenade;
    private boolean computerHasShip, computerHasGrenade;

    public Coordinate() {
        this.playerHasShip = false;
        this.playerHasGrenade = false;
        this.computerHasShip = false;
        this.computerHasGrenade = false;

    }

    // Getters
    public boolean hasPlayerShip() {
        return this.playerHasShip;
    }

    public boolean hasPlayerGrenade() {
        return this.playerHasGrenade;
    }

    public boolean hasComputerShip() {
        return this.computerHasShip;
    }

    public boolean hasComputerGrenade() {
        return this.computerHasGrenade;
    }

    // Setters
    public void markPlayerShip() {
        this.playerHasShip = true;
    }

    public void markPlayerGrenade() {
        this.playerHasGrenade = true;
    }

    public void markComputerShip() {
        this.computerHasShip = true;
    }

    public void markComputerGrenade() {
        this.computerHasGrenade = true;
    }
}
