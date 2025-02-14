import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class colorfulNumber {
    

    public static void main(String[] aStrings) {
        System.out.println(isColorful(3245));
        System.out.println(isColorful(326));
    }

    public static boolean isColorful(int number) {
        String num = String.valueOf(number);
        if (num.length() <= 2) return true;
        char[] str_num = num.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str_num.length; i++) {
            map.put(str_num[i], map.getOrDefault(str_num[i], 0) + 1);
        }
        HashSet<Integer> prod = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
            if (entry.getValue() == 0) {
                return false;
            }
            prod.add(entry.getKey() - '0');
        }

        for (int i = 0; i < str_num.length; i++) {
            int product = (str_num[i] - '0');
            for (int j = i + 1; j < str_num.length; j++) {
                product *= (str_num[j] - '0');
                if (prod.contains(product) == true) {
                    return false;
                }
                prod.add(product);
            }
        }
        return true;

    }
}
