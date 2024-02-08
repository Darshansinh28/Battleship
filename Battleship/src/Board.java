public class Board {
    protected final int NUM_ROW = 8, NUM_COL = 8;

    protected int points;

    protected Cell[][] cell;

    //Constructor
    public Board() {
        this.cell = new Cell[NUM_COL][NUM_ROW];
        for(int x = 0; x < NUM_ROW; x++) {	//When initializing an ARRAY OF OBJECTS you must initialize each of them separately!!!
            for (int y = 0; y < NUM_COL; y++) {
                cell[x][y] = new Cell();
            }
        }
        this.points = 6;
    }
}
