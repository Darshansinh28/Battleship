public class Board {
    protected final int NUM_ROW = 8, NUM_COL = 8;

    protected int points;

    protected Coordinate[][] coordinate;

    //Constructor
    public Board() {
        this.coordinate = new Coordinate[NUM_COL][NUM_ROW];
        for(int x = 0; x < NUM_ROW; x++) {	//When initializing an ARRAY OF OBJECTS you must initialize each of them separately!!!
            for (int y = 0; y < NUM_COL; y++) {
                coordinate[x][y] = new Coordinate();
            }
        }
        this.points = 6;
    }
}
