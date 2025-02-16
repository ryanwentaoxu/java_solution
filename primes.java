import java.util.ArrayList;
import java.util.List;

public class primes {

    int[] primes;


    public static void main(String[] args) {
        primes tp = new primes();
        tp.solution(10);
    }

    public void solution(int num) {
        generatePrimes(num);
    } 

    public void generatePrimes(int num) {
        int max_num = 10000;
        primes = new int[(int)(Math.sqrt(max_num))];
        for (int i = 1; i < primes.length; i++) {
            for (int j = (i * (i + 1)) * 2; j < primes.length; j = j + i * 2 + 1) {
                primes[j] = 11;
            }
        }

        List<Integer> prime_num = new ArrayList();

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] != 11) {
                prime_num.add(2 * i + 1);
                System.out.println(2 * i + 1);
            }
        }
    }
}
