import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sriram on 11/5/16.
 * 436. Find Right Interval   QuestionEditorial Solution  My Submissions
 Total Accepted: 1704
 Total Submissions: 3999
 Difficulty: Medium
 Contributors: love_FDU_llp
 Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

 For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 You may assume none of these intervals have the same start point.
 Example 1:
 Input: [ [1,2] ]

 Output: [-1]

 Explanation: There is only one interval in the collection, so it outputs -1.
 Example 2:
 Input: [ [3,4], [2,3], [1,2] ]

 Output: [-1, 0, 1]

 Explanation: There is no satisfied "right" interval for [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point;
 For [1,2], the interval [2,3] has minimum-"right" start point.
 Example 3:
 Input: [ [1,4], [2,3], [3,4] ]

 Output: [-1, 2, -1]

 Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class FindRightInterval {

      //Definition for an interval.
      public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    public static class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            Wrapper[] vals=new Wrapper[intervals.length*2];
            int[] rightIntervals=new int[intervals.length];
            int k=0;
            for(int i=0;i<intervals.length;i++){
                vals[k++]=new Wrapper(intervals[i].start,true,i);
                vals[k++]=new Wrapper(intervals[i].end,false,i);
            }
            //sort(vals);
            Arrays.sort(vals,new Comparator<Wrapper>(){
                @Override
                public int compare(Wrapper w1, Wrapper w2){
                    if(w1.val>w2.val){
                        return 1;
                    }
                    else if(w1.val==w2.val && w1.start==true){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            });
            for (int i = 0; i < vals.length; i++) {
//                System.out.println(vals[i]);
            }

            int current_start=-1;
            for(int i=vals.length-1;i>=0;i--){
                if(vals[i].start==true){
                    current_start=vals[i].index;
                }
                else{
                    rightIntervals[vals[i].index]=current_start;
                }
            }
            return rightIntervals;
        }

        class Wrapper {
            boolean start;
            int index;
            int val;
            public Wrapper(int v,boolean s,int i){
                val=v;start=s;index=i;
            }
            public String toString(){
                return String.valueOf(val);
            }
        }
    }

    public static void main(String[] args){
        Solution soln=new Solution();
        Interval[] intervals = new Interval[3];
        intervals[0]=new Interval(3,4);
        intervals[1]=new Interval(2,3);
        intervals[2]=new Interval(1,2);
        int items[] = soln.findRightInterval(intervals);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}
