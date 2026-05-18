class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int max = 0;
        Map<Character, Integer> indexMap = new HashMap();
        char[] word = s.toCharArray();
        while(r<s.length()) {
            if(indexMap.containsKey(word[r])) {
                l = Math.max(indexMap.get(word[r]),l);
            }
            indexMap.put(word[r], r+1);
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
