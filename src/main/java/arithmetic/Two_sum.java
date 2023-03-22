package arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * Keafmd
 *
 * @ClassName: Two_sum
 * @Description: 两数之和
 * @author: liuchen
 * @date: 2023/3/22 9:31
 * @Blog:
 */

public class Two_sum {

    //以下是对这段代码的优化建议：
    //
    //不需要使用HashMap来记录所有的数值及其下标，只需要在循环中遍历每个数值时，检查其是否与之前的数值相加等于目标值，如果没有则将其存储在HashMap中，这样可以减少空间复杂度。
    //
    //如果目标值比数组中的最小值还小或比最大值还大，则可以直接返回空结果，这样可以减少不必要的计算。
    //
    //由于题目要求返回的是两个数的下标，因此可以将查找另一个数值的操作放到HashMap中，这样可以将时间复杂度降到O(n)。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        int [] j = new int[2];
        int i=0;
        for (int num : nums) {
            map.put(num, i);
            i++;
        }
        for(i =0;i<nums.length;i++){
            if(null!=map.get(target-nums[i])&&i!=map.get(target-nums[i])) {
                j[0]=i;j[1]=map.get(target-nums[i]);
                break;
            }
        }
        return j;
    }
    //优化后
    public int[] twoSum_optimize(int[] nums, int target) {

        Map<Integer,Integer> map =new HashMap<>();

        for(int i =0;i<nums.length;i++){
            // int a = target-nums[i];
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
