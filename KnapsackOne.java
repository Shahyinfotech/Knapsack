import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KnapsackOne {
    public static int unboundedKnapsack(int a[], int k) {
		int n = a.length;
		int flag[] = new int[k + 1];
		int i, j;
		
		//0-1 Knapsack dynamic prog
		for (j=1; j <=k; j++) {
			for (i = 0; i < n; i++) {
				if (a[i] <= j) {
					flag[j] = Math.max(flag[j], flag[j-a[i]] + a[i]);
				}
			}
		}
		
		return flag[k];
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