/**
 * Class representing the game grid.
 * The grid contains cells, each representing a position in the game.
 *
 * @author Darshansinh Dilipsinh Devda (40261713)
 * @author Pranaykumar Chauhan Rajeshkumar (40266722)
 * <p>
 * COMP6481
 * Assignment 1
 * Due Date : 16 Feb 2024
 */
public class Grid {
    /** Number of rows in the grid. */
    protected final int NUM_ROW = 8;

    /** Number of columns in the grid. */
    protected final int NUM_COL = 8;

    /** Player's points in the game. */
    protected int points;

    /** 2D array of cells representing the grid. */
    protected Cell[][] cell;

    /**
     * Constructs a new Grid object and initializes it.
     * Initializes the grid with cells and sets the player's points.
     */
    public Grid() {
        // Initialize the grid with cells
        this.cell = new Cell[NUM_COL][NUM_ROW];
        for (int x = 0; x < NUM_ROW; x++) {
            for (int y = 0; y < NUM_COL; y++) {
                cell[x][y] = new Cell(); // Initialize each cell separately
            }
        }
        // Initialize player's points
        this.points = 6; // Assuming 6 points to start with
    }
}
