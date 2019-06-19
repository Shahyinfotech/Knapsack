import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KnapsackTwo {
	
	public static int unboundedKnapsack(int a[], int k) {
		int n = a.length; 
		boolean[][] matx = new boolean[n+1][k+1];
            for (int i = 0; i <= n; ++i) {
                matx[i][0] = true;
            }
            
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j <= k; ++j) {
                    int r = j;
                    while (r >= 0) {
                        if (matx[i-1][r]) {
                            matx[i][j] = true;
                            break;
                        }
                        r -= a[i-1];
                    }
                }
            }
            
            for (int j = k; j >= 0; --j) {
                if (matx[n][j]) {
                    return j;
                }
            }
		
		return 0;
	}

    public static void main(String[] args) {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int arr[];
		try {
			int tc = Integer.parseInt(b.readLine());	//reading test cases
			
			while(tc-- > 0) {
				String nk[] = b.readLine().split(" ");	//reading array length and target sum
				int n = Integer.parseInt(nk[0]);
				int k = Integer.parseInt(nk[1]);
				
				arr = new int[n];
				String numbers[] = b.readLine().split(" ");

				for (int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(numbers[i]);
				}
				System.out.println(unboundedKnapsack(arr, k));
			}
		}  catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
}