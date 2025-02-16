import java.util.ArrayList;
import java.util.List;

class wellordered {
    public static void main(String[] a) {
        wellordered w = new wellordered();
        w.solution(2);
    }


    List<String> ans = new ArrayList<>();
    public void helper(String prefix, int n, int start) {
        if (prefix.length() == n) {
            ans.add(prefix);
            System.out.println(prefix);
            return;
        }
        for (int i = start; i <= 25; i++) {
            helper(prefix + String.valueOf((char)('a' + i)), n, start + i + 1);
            helper(prefix + String.valueOf(Character.toUpperCase((char)('a' + i))), n, start + i + 1);
        }
    }
    public List<String> solution(int digit) {
        helper("", digit, 0);
        return ans;
    }
}