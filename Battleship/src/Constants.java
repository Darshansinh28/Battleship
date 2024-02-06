import java.util.HashMap;
import java.util.Map;
public class Constants {
    public  static  int map(String column){
        Map<String, Integer> columnMap = new HashMap<>();
        columnMap.put("a", 0);
        columnMap.put("b", 1);
        columnMap.put("c", 2);
        columnMap.put("d", 3);
        columnMap.put("e", 4);
        columnMap.put("f", 5);
        columnMap.put("g", 6);
        columnMap.put("h", 7);


       return columnMap.get(column);
    }
}
