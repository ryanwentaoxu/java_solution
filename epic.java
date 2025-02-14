import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class epic {
  



  public boolean isAdditiveNumber(String num) {
    int n = num.length();
    for (int i = 1; i <= n / 2; i++) {
        if (num.charAt(0) == '0' && i > 1) return false;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
            if (num.charAt(i) == '0' && j > 1) break;   
            BigInteger x2 = new BigInteger(num.substring(i, i + j));
            if (isValid(x1, x2, j + i, num)) return true;
        }
    }
    return false;
  }

  public boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
    if (start == num.length()) return true;
    x2 = x2.add(x1);
    x1 = x2.subtract(x1);
    String sum = x2.toString();
    return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
  }


  public int[] findRightInterval(int[][] intervals) {
        List<int[]> inter = new ArrayList();
        Map<int[], Integer> map = new HashMap();
        for (int i = 0; i < intervals.length; i++) {
            inter.add(intervals[i]);
            map.put(intervals[i], i);
        }
        Collections.sort(inter, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] >= b[0]) return 1;
                return -1;
            }
        });
        int[] ans = new int[inter.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = -1;
        for (int i = 0; i < inter.size(); i++) {
            if (inter.get(i)[0] == inter.get(i)[1]) {
                ans[i] = map.get(inter.get(i));
                continue;
            }
            for (int j = i + 1; j < inter.size(); j++) {
                if (inter.get(j)[0]>= inter.get(i)[1]) {
                    ans[map.get(inter.get(i))] = map.get(inter.get(j));
                    break;
                }
            }
        }
        return ans;
    }

    int ans = Integer.MAX_VALUE;
    int t;
    public void threeSumClosetHelper(int[] nums, int target, int start) {
        int one = nums[start];
        int left = start + 1;
        int right = nums.length - 1;
        while(left < right) {
            
            int low = nums[left];
            int high = nums[right];
            int tmp = low + high + one;

            if (Math.abs(tmp - target) <  Math.abs(ans)) {
                t = tmp;
                ans = Math.abs(tmp - target);
            }
            if (tmp < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // if (i != 0 && nums[i] == nums[i - 1]) continue;
            threeSumClosetHelper(nums, target, i);
        }
        return t;
    }

}
