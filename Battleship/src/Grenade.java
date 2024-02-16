/**
 * Class representing a grenade in the game.
 * Grenades have a position on the game grid defined by row and column coordinates.
 *
 * @author Darshansinh Dilipsinh Devda (40261713)
 * @author Pranaykumar Chauhan Rajeshkumar (40266722)
 * <p>
 * COMP6481
 * Assignment 1
 * Due Date : 16 Feb 2024
 */
public class Grenade {
    /**
     * Row coordinate of the grenade.
     */
    protected int row;

    /**
     * Column coordinate of the grenade.
     */
    protected int column;

    /**
     * Constructor to initialize a grenade with default position (0,0).
     */
    public Grenade() {
        this.row = 0;
        this.column = 0;
    }

    /**
     * Set the position of the grenade.
     * @param row The row coordinate of the grenade.
     * @param column The column coordinate of the grenade.
     */
    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the row coordinate of the grenade.
     * @return The row coordinate of the grenade.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Get the column coordinate of the grenade.
     * @return The column coordinate of the grenade.
     */
    public int getColumn() {
        return this.column;
    }
}
