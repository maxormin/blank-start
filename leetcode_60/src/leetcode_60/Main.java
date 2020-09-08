package leetcode_60;
import java.util.*;

public class Main {
	static String getPermutation(int n, int k) {
		int[] a = new int[n];
		int[] b = new int[n+1];
		int m,i,j,t,z,mn,temp_t;
		m = 1;
		for(i=3;i<=n;i++)
			m = m * (i - 1);
		i = 0;
		z = n;
		while(true){
			t = (int) Math.ceil((float)k / m);
			mn = 0;
			temp_t = 0;
			while(temp_t != t){
				mn++;
				mn = mn % (n+1);
				if(b[mn]!=1)
					temp_t++;
			}
			a[i] = mn;
			b[mn] = 1;
			k = k % m;
			if(k == 0){
				j = i+1;
				break;
			}
			m = m / (z - 1);
			z--;
			i++;
		}
		if(j<n)
			for(i=n;i>=1;i--){
				if(b[i]==1)
					continue;
				a[j] = i;
				j++;
				if(j==n)
					break;
			}
		String s = "";
		for(i=0;i<n;i++)
			s += a[i];
		System.out.print(s);
		return s;
	}
	public static void main(String[] args) {
		int n,k;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		getPermutation(n,k);
	}

}
