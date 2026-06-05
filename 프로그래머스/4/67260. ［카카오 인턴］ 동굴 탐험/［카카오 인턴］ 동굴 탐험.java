import java.util.*;
class Solution {
    List<List<Integer>> graph;
    int[] prev, unlock;
    boolean[] visited, wait;
    public void BFS(int sn) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(sn);
        visited[sn] = true;
        
        while(!q.isEmpty()) {
            int fn = q.poll();
            
            if(unlock[fn] != -1 && wait[unlock[fn]]) { //어떤 방에 왔을 때, 해금될 방이 wait에 있으면
                if(visited[unlock[fn]]) continue;
                q.offer(unlock[fn]);
                visited[unlock[fn]] = true;
            }
            
            for(int next : graph.get(fn)) {
                if(visited[next]) continue;
                if(prev[next] != -1 && !visited[prev[next]]) {
                    wait[next] = true; //wait에 next 갈 뻔했다고 표시
                    continue;
                }
                
                q.offer(next);
                visited[next] = true;
            }
        }
    }
    public boolean solution(int n, int[][] path, int[][] order) {
        graph = new ArrayList<>();
        
        prev = new int[n];
        unlock = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(unlock, -1);
        
        visited = new boolean[n];
        wait = new boolean[n];
        
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for(int[] i : path) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        
        for(int[] i : order) {
            prev[i[1]] = i[0]; //prev[8] = 5, 8번갈거면 5갔어야함
            unlock[i[0]] = i[1];
        } 
        
        if(prev[0] != -1) return false;
        
        BFS(0);
        for(int i = 0; i < n; i++) if(!visited[i]) return false;
        return true;
    }
}