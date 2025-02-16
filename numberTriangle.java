import java.util.ArrayList;
import java.util.List;

public class numberTriangle {

    public static void main(String[] args) {
        numberTriangle nt = new numberTriangle();
        nt.soltion(new int[] {4, 7, 3, 6, 7});
    }


    public List<List<Integer>> helper(List<Integer> nums) {
        List<List<Integer>> tt = new ArrayList();
        if (nums.size() == 1) {
            tt.add(nums);
            return tt;
        }
        List<Integer> current = new ArrayList();
        for (int i = 0; i < nums.size() - 1; i++) {
            current.add(nums.get(i) + nums.get(i + 1));
        }
        tt.add(current);
        List<List<Integer>> sub = helper(current);
        for (List l : sub) {
            tt.add(l);
        }
        return tt;
    }
    public List<List<Integer>> soltion(int[] nums) {
        List<Integer> t = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            // List<Integer> t = new ArrayList();
            t.add(nums[i]);
        }
        List<List<Integer>> h = helper(t);
        for (int i = 0; i < h.size(); i++) {
            for (int mm : h.get(i)) {
                System.out.print(mm);
                System.out.print(" ");
            }
            System.out.println();
        }
        return h;
    }
    
}
