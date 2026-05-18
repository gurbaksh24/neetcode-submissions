class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        char[] charArray = s.toCharArray();
        while(l<r) {
            while(l<r && !Character.isLetterOrDigit(charArray[l]))
                l++;
            
            while(l<r && !Character.isLetterOrDigit(charArray[r]))
                r--;


            if(l<r && (Character.toLowerCase(charArray[l]) != Character.toLowerCase(charArray[r])))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
