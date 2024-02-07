public class Coordinate {

    private boolean playerHasShip, playerHasGrenade;
    private boolean computerHasShip, computerHasGrenade;

    private boolean called;
    public Coordinate() {
        this.playerHasShip = false;
        this.playerHasGrenade = false;
        this.computerHasShip = false;
        this.computerHasGrenade = false;
        this.called = false;

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

    public void markCall() {
        this.called = true;
    }

    public String toString() {

        String indicator = " ";

        if (called) {
            indicator = "x";
        }
        else if (playerHasShip) {
            indicator = "s";
        }
        else if (computerHasShip) {
            indicator = "S";
        }
        else if (playerHasGrenade) {
            indicator = "g";
        }
        else if (computerHasGrenade) {
            indicator = "G";
        }
        else if (!called) {
            indicator = "_";
        }
        return indicator;
    }


}
