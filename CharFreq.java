import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class CharFreq {

    public static void main(String[] args) {
        CharFreq cf = new CharFreq();
        cf.CharFreqPrint("My Mon is a teacher");
    }

    public void CharFreqPrint(String word) {
        String[] w = word.split("\\s");
        Map<Character, Integer> counter = new HashMap();
        List<Map.Entry<Character, Integer>> cc = new LinkedList<>();
        Map<Character, Integer> index = new HashMap();

        for (int i = 0; i < w.length; i++) {
            Character current = Character.toLowerCase(w[i].charAt(0));
            counter.put(current, counter.getOrDefault(current, 0) + 1);

            if (index.containsKey(current) == false) {
                index.put(current, i);
            }
        }
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            cc.add(entry);
        }


        Collections.sort(cc, new Comparator<Map.Entry<Character, Integer>>() {
           @Override
           public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 1  * (index.get(o1.getKey()) - index.get(o2.getKey()));
                }
                return o1.getValue() - o2.getValue();
           } 
        });

        for (Map.Entry<Character, Integer> entry : cc) {
            System.out.println(entry);
        }

        return;
    }
    
}
