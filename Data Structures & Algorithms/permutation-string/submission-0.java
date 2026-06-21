class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int s1Freq[] = new int[26];
        int windowFreq[] = new int [26];
        for(int i = 0;i<s1.length();i++){
            s1Freq[s1.charAt(i)-'a']++;
        }
        for(int right = 0;right<s2.length();right++){
            windowFreq[s2.charAt(right)-'a']++;
            while(right-left+1>s1.length()){
                windowFreq[s2.charAt(left)-'a']--;
                left++;
            }
            boolean match = true;
            for(int i = 0 ;i<26;i++){
                if(s1Freq[i]!=windowFreq[i])match = false;
            }
            if(match)return true;
        } 
        return false;
    }
}
