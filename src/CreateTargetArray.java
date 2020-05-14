import java.util.ArrayList;

public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index)
    {
        ArrayList targetList=new ArrayList();
        for(int i=0;i<nums.length;i++)
        {
            targetList.add(index[i],nums[i]);
        }
        int output[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            output[i] = (int) targetList.get(i);
        }
        return output;
    }
}
