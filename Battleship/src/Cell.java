public class Cell {

    private boolean humanShipPresent, humanGrenadePresent;
    private boolean computerShipPresent, computerGrenadePresent;

    private boolean called;

    public Cell() {
        this.humanShipPresent = false;
        this.humanGrenadePresent = false;
        this.computerShipPresent = false;
        this.computerGrenadePresent = false;
        this.called = false;

    }

    // Getters
    public boolean hasHumanShip() {
        return this.humanShipPresent;
    }

    public boolean hasHumanGrenade() {
        return this.humanGrenadePresent;
    }

    public boolean hasComputerShip() {
        return this.computerShipPresent;
    }

    public boolean hasComputerGrenade() {
        return this.computerGrenadePresent;
    }

    public boolean hasCalled() {
        return this.called;
    }

    // Setters
    public void markHumanShip() {
        this.humanShipPresent = true;
    }

    public void markHumanGrenade() {
        this.humanGrenadePresent = true;
    }

    public void markComputerShip() {
        this.computerShipPresent = true;
    }

    public void markComputerGrenade() {
        this.computerGrenadePresent = true;
    }

    public void markCall() {
        this.called = true;
    }

    public String toString() {

        String indicator = " ";

        if (humanShipPresent) {
            indicator = "s";
        } else if (computerShipPresent) {
            indicator = "S";
        } else if (humanGrenadePresent) {
            indicator = "g";
        } else if (computerGrenadePresent) {
            indicator = "G";
        } else if (called) {
            indicator = "x";
        } else {
            indicator = "_";
        }

        return indicator;
    }


}
