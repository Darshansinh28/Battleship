/**
 * Class representing a cell in the game grid.
 * Each cell can contain various elements such as ships, grenades, and indicators for called positions.
 *
 * @author Darshansinh Dilipsinh Devda (40261713)
 * @author Pranaykumar Chauhan Rajeshkumar (40266722)
 * <p>
 * COMP6481
 * Assignment 1
 * Due Date : 16 Feb 2024
 */
public class Cell {

    // Attributes to track presence of different elements in the cell
    private boolean humanShipPresent; // Indicates if a human player's ship is present
    private boolean humanGrenadePresent; // Indicates if a human player's grenade is present
    private boolean computerShipPresent; // Indicates if a computer player's ship is present
    private boolean computerGrenadePresent; // Indicates if a computer player's grenade is present

    private boolean called; // Indicates if the cell has been called

    /**
     * Constructor to initialize a cell with default values.
     * By default, all elements are absent and the cell is not called.
     */
    public Cell() {
        this.humanShipPresent = false;
        this.humanGrenadePresent = false;
        this.computerShipPresent = false;
        this.computerGrenadePresent = false;
        this.called = false;
    }

    // Getters for element presence and call status

    /**
     * Check if a human player's ship is present in the cell.
     * @return True if a human player's ship is present, false otherwise.
     */
    public boolean hasHumanShip() {
        return this.humanShipPresent;
    }

    /**
     * Check if a human player's grenade is present in the cell.
     * @return True if a human player's grenade is present, false otherwise.
     */
    public boolean hasHumanGrenade() {
        return this.humanGrenadePresent;
    }

    /**
     * Check if a computer player's ship is present in the cell.
     * @return True if a computer player's ship is present, false otherwise.
     */
    public boolean hasComputerShip() {
        return this.computerShipPresent;
    }

    /**
     * Check if a computer player's grenade is present in the cell.
     * @return True if a computer player's grenade is present, false otherwise.
     */
    public boolean hasComputerGrenade() {
        return this.computerGrenadePresent;
    }

    /**
     * Check if the cell has been called.
     * @return True if the cell has been called, false otherwise.
     */
    public boolean hasCalled() {
        return this.called;
    }

    // Setters to mark presence of elements and call status

    /**
     * Mark the presence of a human player's ship in the cell.
     */
    public void markHumanShip() {
        this.humanShipPresent = true;
    }

    /**
     * Mark the presence of a human player's grenade in the cell.
     */
    public void markHumanGrenade() {
        this.humanGrenadePresent = true;
    }

    /**
     * Mark the presence of a computer player's ship in the cell.
     */
    public void markComputerShip() {
        this.computerShipPresent = true;
    }

    /**
     * Mark the presence of a computer player's grenade in the cell.
     */
    public void markComputerGrenade() {
        this.computerGrenadePresent = true;
    }

    /**
     * Mark the cell as called.
     */
    public void markCall() {
        this.called = true;
    }

    /**
     * Override toString method to represent the cell's contents as a string.
     * Returns a string representing the contents of the cell based on the presence of different elements.
     * 's' for human player's ship, 'S' for computer player's ship, 'g' for human player's grenade,
     * 'G' for computer player's grenade, 'x' for called position, '_' for empty position.
     * @return String representation of the cell's contents.
     */
    @Override
    public String toString() {
        if (humanShipPresent) {
            return "s";
        } else if (computerShipPresent) {
            return "S";
        } else if (humanGrenadePresent) {
            return "g";
        } else if (computerGrenadePresent) {
            return "G";
        } else if (called) {
            return "x";
        } else {
            return "_";
        }
    }
}
