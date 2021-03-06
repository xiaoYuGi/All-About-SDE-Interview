package org.gnuhpc.interview.leetcode.solutions;

import org.gnuhpc.interview.leetcode.utils.Utils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739 {
    //求更大的数值，使用递减栈
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> s = new LinkedList<>();
        int[] ans = new int[T.length];
        int i = 0;
        while (i < T.length) {
            if (s.isEmpty() || T[i] <= T[s.peek()])//可能会更小，因此往后走
                s.push(i++);//如果只关注数值可以直接存入数值，如果关注idx之间的距离，也就是和最值的距离，则存入idx
            else {
                //另外注意在处理最值的时候是不动i的
                int tp = s.pop();  // store the top index
                ans[tp] = i - tp;
            }
        }

        return ans;
    }


    @Test
    public void test() {
        Utils.printArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
