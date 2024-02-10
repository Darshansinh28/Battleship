/**
 * Class representing the game grid.
 * The grid contains cells, each representing a position in the game.
 *
 *  @author Darshansinh Dilipsinh Devda
 *  @author Pranaykumar Chauhan Rajeshkumar
 *
 */
public class Grid {
    // Constants for grid dimensions
    protected final int NUM_ROW = 8; // Number of rows in the grid
    protected final int NUM_COL = 8; // Number of columns in the grid

    // Player's points in the game
    protected int points;

    // 2D array of cells representing the grid
    protected Cell[][] cell;

    // Constructor to initialize the grid
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
