class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagMap = new HashMap();

        for(String s : strs) {
            char[] currWord = s.toCharArray();

            Arrays.sort(currWord);
            String sortedWord = new String(currWord);
            anagMap.computeIfAbsent(sortedWord, x -> new ArrayList<>());
            anagMap.get(sortedWord).add(s);
        }

        List<List<String>> ans = new ArrayList();

        for(Map.Entry<String, List<String>> entry : anagMap.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
