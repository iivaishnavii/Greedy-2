//TC : O(n) where n is the length of characters
//SC : O(n) where n is the length of characters
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0 || tasks == null)
            return 0;
        int maxFrequency = 0, maxCount = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<tasks.length;i++){
            char c = tasks[i];
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            int cnt = map.get(c)+1;
            map.put(c,cnt);
            maxFrequency = Math.max(cnt,maxFrequency);
        }
        
        for( int val: map.values()){
            if(val == maxFrequency){
                maxCount++;
            }
        }
        
        int partitions = maxFrequency - 1;
        int emptySlots = (n - (maxCount-1)) * partitions;
        int pendingElements =tasks.length - maxCount * maxFrequency;
        int idle = Math.max(0,emptySlots - pendingElements);
        
        return tasks.length+idle;
        
    }
}