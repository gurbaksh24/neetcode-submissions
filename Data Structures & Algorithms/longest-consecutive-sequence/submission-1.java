class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        int maxConsecutive = 1;

        Set<Integer> numbers = new HashSet(
            Arrays.stream(nums).boxed().collect(Collectors.toSet()));

        for(int n : numbers) {
            if(!numbers.contains(n-1)) {
                int currentCount = 1;
                while(numbers.contains(++n)) {
                    currentCount++;
                }
                maxConsecutive = Math.max(maxConsecutive, currentCount);
            }
        }
        return maxConsecutive;
    }
}
