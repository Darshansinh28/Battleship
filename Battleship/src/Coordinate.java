public class Coordinate {

    private boolean HumanHasShip, HumanHasGrenade;
    private boolean computerHasShip, computerHasGrenade;

    private boolean called;
    public Coordinate() {
        this.HumanHasShip = false;
        this.HumanHasGrenade = false;
        this.computerHasShip = false;
        this.computerHasGrenade = false;
        this.called = false;

    }

    // Getters
    public boolean hasHumanShip() {
        return this.HumanHasShip;
    }

    public boolean hasHumanGrenade() {
        return this.HumanHasGrenade;
    }

    public boolean hasComputerShip() {
        return this.computerHasShip;
    }

    public boolean hasComputerGrenade() {
        return this.computerHasGrenade;
    }

    // Setters
    public void markHumanShip() {
        this.HumanHasShip = true;
    }

    public void markHumanGrenade() {
        this.HumanHasGrenade = true;
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
        else if (HumanHasShip) {
            indicator = "s";
        }
        else if (computerHasShip) {
            indicator = "S";
        }
        else if (HumanHasGrenade) {
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
