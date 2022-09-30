import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    private static final Map<Character, Integer> romanToInt = new HashMap<Character, Integer>(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s){
        int sum = 0;
        for (int i = 0 ; i < s.length(); i++){
            if (i + 1 < s.length() && romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i+1))){
                sum += (romanToInt.get(s.charAt(i+1)) - romanToInt.get(s.charAt(i)));
                i++;
            }
            else{
                sum+=romanToInt.get(s.charAt(i));
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
