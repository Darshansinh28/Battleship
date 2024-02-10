import java.util.Random;
/**
 * Class containing common utility functions used in the Battleship game.
 *
 *  @author Darshansinh Dilipsinh Devda
 *  @author Pranaykumar Chauhan Rajeshkumar
 *
 */
public class CommonFunctions {

    /**
     * Maps a character representing a column to its corresponding integer index.
     * @param characterColumn The character representing the column ('a' to 'h').
     * @return The integer index corresponding to the column (0 to 7).
     */
    public  static  int mapCharacterToIntColumn(char characterColumn){
        int Integercolumn = 0;
        
        switch (characterColumn) {
            case 'a': Integercolumn = 0;
                break;
            case 'b': Integercolumn = 1;
                break;
            case 'c': Integercolumn = 2;
                break;
            case 'd': Integercolumn = 3;
                break;
            case 'e': Integercolumn = 4;
                break;
            case 'f': Integercolumn = 5;
                break;
            case 'g': Integercolumn = 6;
                break;
            case 'h': Integercolumn = 7;
                break;
        };
        return Integercolumn;
    }

    /**
     * Maps an integer index representing a column to its corresponding character.
     * @param integerColumn The integer index representing the column (0 to 7).
     * @return The character representing the column ('a' to 'h').
     */
    public  static  char mapIntColumnToCharacter(int integerColumn){
        Character charactercolumn = ' ';

        switch (integerColumn) {
            case 0 : charactercolumn = 'a';
                break;
            case 1 : charactercolumn = 'b';
                break;
            case 2 : charactercolumn = 'c';
                break;
            case 3 : charactercolumn = 'd';
                break;
            case 4 : charactercolumn = 'e';
                break;
            case 5 : charactercolumn = 'f';
                break;
            case 6 : charactercolumn =  'g';
                break;
            case 7 : charactercolumn =  'h';
                break;
        };

        return charactercolumn;
    }

    /**
     * Generates a random integer within the specified range.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random integer within the specified range.
     */
    public static int randomInt (int min, int max) {

        Random randomizer = new Random();
        int randomInt = 0;
        randomInt = randomizer.nextInt((max-min) + 1) + min;
        return randomInt;
    }
}




