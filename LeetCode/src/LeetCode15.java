import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15
{

    public static void main(String args[]) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;

            int target=0-nums[i];
            
            int lo=i+1; int hi=nums.length-1;
            while(lo<hi){
                int tempSum=nums[lo]+nums[hi];
                if(tempSum==target){
                    list.add(Arrays.asList(new Integer[]{nums[i],nums[lo],nums[hi]}));
                    lo++;
                    while(lo<hi&&nums[lo]==nums[lo-1]){
                        lo++;
                    }
                    hi--;
                    while(lo<hi&&nums[hi]==nums[hi+1]){
                        hi--;
                    }
                }else if(tempSum<target){
                    lo++;
                }else{
                    hi--;
                }

            }

        }
        return list;
    }
}
