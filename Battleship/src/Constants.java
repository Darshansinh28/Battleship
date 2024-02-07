import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Constants {
    public  static  int mapCharacterToIntColumn(Character charactercolumn){
        int Integercolumn = 0;
        
        switch (charactercolumn) {
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

    public  static  char mapIntColumnToCharacter(int Integercolumn){
        Character charactercolumn = ' ';

        switch (Integercolumn) {
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
    public static int randomInt (int min, int max) {

        Random randomizer = new Random();
        int randomInt = 0;
        randomInt = randomizer.nextInt((max-min) + 1) + min;
        return randomInt;
    }
}
