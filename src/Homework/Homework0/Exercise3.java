package Homework.Homework0;

/**
 * @author JiazhenZhao
 * 2023/12/13
 * 类说明：
 */
public class Exercise3 {
    /**
     * Returns a max number in an array.
     * @param nums a array.
     * */
    public static int MaxInArray(int[] nums){
        int res = nums[0];
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] > res)
                    res = nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int max = MaxInArray(nums);
        System.out.println("Max num in nums is " + max);
    }
}
