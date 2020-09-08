package leetcode_347;

import java.util.*;

public class Main {
    static int[] topKFrequent(int[] nums, int k) {
        int len,i,a,j,temp;
        int[] array = new int[k];
        List<Integer> m = new ArrayList<Integer>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        len = nums.length;
        
        for(i=0;i<len;i++){
        	Integer t = map.get(nums[i]);
        	if(t==null){
        		a = 0;
        		map.put(nums[i],a+1);
        	}else{
        		a = map.get(nums[i]);
        		map.put(nums[i],a+1);
        	}
        }
        int[][] my_sort = new int[2][map.size()];
        i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			my_sort[0][i] =  entry.getKey();
			my_sort[1][i] =  entry.getValue();
			i++;
		}
		for(i=0;i<k;i++){
			for(j=i+1;j<map.size();j++){
				if(my_sort[1][i] < my_sort[1][j]){
					temp = my_sort[1][i];
					my_sort[1][i] = my_sort[1][j];
					my_sort[1][j] = temp;
					temp = my_sort[0][i];
					my_sort[0][i] = my_sort[0][j];
					my_sort[0][j] = temp;
				}
			}
			array[i] = my_sort[0][i];
		}
        return array;
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] nums = new int[]{1,2,3};
		int k = 1;
		topKFrequent(nums,k);
	}

}
