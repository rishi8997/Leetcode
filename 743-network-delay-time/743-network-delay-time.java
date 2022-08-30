// Approach: Initialize a delay array of size n+1 with Max value to store the delay time for each node. Delay for souce is 0. Now call Dijkstra's algo to fill up delay and return the max from the array unless it is MAX_value. In dijkstra, Add source to min priority queue and while queue isn't empty, poll, update delays for all it's neighbors and add them in pq.

class Node {
    int val;
    int time;
    public Node(int val, int time){
        this.val = val;
        this.time = time;
    }
}
class Solution {
    HashMap<Integer, ArrayList<Node>> adj = new HashMap<Integer, ArrayList<Node>>();
    public void createAdjacency(int[][] times, int n){
        for(int[] time : times){
            if(!adj.containsKey(time[0])){
                adj.put(time[0], new ArrayList<Node>());
            }
            adj.get(time[0]).add(new Node(time[1], time[2]));
        }
    }
    
    public void dijkstra(int[] delay, int source){
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.time, node2.time));
        pq.add(new Node(source, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int val = node.val;
            int time = node.time;
            if(adj.containsKey(node.val)){
               for(Node it : adj.get(node.val)){
                if(delay[it.val] > delay[node.val] + it.time){
                    delay[it.val] = delay[node.val] + it.time;
                    pq.add(new Node(it.val, delay[it.val]));
                }
            }  
            }
           
        }
        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        createAdjacency(times, n);
        int[] delay = new int[n+1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[k] = 0;
        dijkstra(delay, k);
        int max = Integer.MIN_VALUE;
        for(int i=1; i<delay.length; i++){
            max = Math.max(max, delay[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
        
    }
}