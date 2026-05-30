import java.util.*;
class Solution {
    List<int[]> rst;
    public void hanoi(int from, int sub, int to, int n) {
        if(n == 1) {
            rst.add(new int[]{from, to});
            return;
        }
        hanoi(from, to, sub, n - 1);
        rst.add(new int[]{from, to});
        hanoi(sub, from, to, n - 1);
    }
    public List<int[]> solution(int n) {
        rst = new ArrayList<>();
        hanoi(1, 2, 3, n);
        return rst;
    }
}