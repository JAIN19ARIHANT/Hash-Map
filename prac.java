import java.util.*;
public class prac {

    // we have to find the longest subarray which has the sum equal to the target (here , k = 5)
    // and then we have to return the starting and ending index of the subarray from  main array,
    // along with the length of the longest subarray.

    //  this question is very similar to LEETCODE-560 , Subarray sum equals K.

    public static void main(String[] args) {
        int k = 5;
        int start = 0, end =0 ,max =0;
        int[] arr = {2,3,2,1,1,1,5,8,3,2,1};
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(sum,0);
        for(int i = 0 ; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum - k)){
                if(i - map.get(sum-k) > max){
                    start = map.get(sum-k)+1;
                    end = i;
                    max = Math.max(max,i - map.get(sum-k));
                }
            }
            map.put(sum,i);
        }
        System.out.println("Starting index is " + start + " and ending index is " + end + " and the length is " + (end-start+1));
    }
}