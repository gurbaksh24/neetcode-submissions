class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []cnt = new int[26];

        for(char t : tasks) {
            cnt[t-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int c: cnt) {
            if(c > 0)
                pq.add(c);
        }

        Queue<int[]> cooldown = new LinkedList<>();

        int minCycles = 0;

        while(!pq.isEmpty() || !cooldown.isEmpty()) {
            minCycles++;
            if(pq.isEmpty()) {
                minCycles = cooldown.peek()[1];
            }
            else {
                int count = pq.poll();
                count--;
                if(count > 0)
                    cooldown.add(new int[]{count, minCycles+n});
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == minCycles) 
                pq.add(cooldown.poll()[0]);
        }
        return minCycles;
    }
}
