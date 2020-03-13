//TC : O(n), SC: O(n) where n is the length of ratings
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int candies[] = new int[ratings.length];
        
        Arrays.fill(candies,1);
        
        //Left Pass
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        
        //Right Pass
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i],candies[i+1]+1);
        }
        
        int sum = 0;
        for(int el :candies)
            sum +=el;
        
        return sum;
    }
}