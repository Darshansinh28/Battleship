/**
 * Class representing a ship in the game.
 * Ships have a position on the game grid defined by row and column coordinates.
 *
 *  @author Darshansinh Dilipsinh Devda
 *  @author Pranaykumar Chauhan Rajeshkumar
 *
 */
public class Ship {
    // Attributes to store ship position
    protected int row; // Row coordinate of the ship
    protected int column; // Column coordinate of the ship

    /**
     * Constructor to initialize a ship with default position (0,0).
     */
    public Ship() {
        this.row = 0;
        this.column = 0;
    }

    /**
     * Set the position of the ship.
     * @param row The row coordinate of the ship.
     * @param column The column coordinate of the ship.
     */
    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the row coordinate of the ship.
     * @return The row coordinate of the ship.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Get the column coordinate of the ship.
     * @return The column coordinate of the ship.
     */
    public int getColumn() {
        return this.column;
    }
}
