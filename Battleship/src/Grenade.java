/**
 * Class representing a grenade in the game.
 * Grenades have a position on the game grid defined by row and column coordinates.
 *
 *  @author Darshansinh Dilipsinh Devda
 *  @author Pranaykumar Chauhan Rajeshkumar
 *
 */
public class Grenade {
    // Attributes to store grenade position
    protected int row; // Row coordinate of the grenade
    protected int column; // Column coordinate of the grenade

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
