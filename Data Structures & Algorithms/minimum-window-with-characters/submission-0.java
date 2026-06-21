class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        HashMap<Character,Integer> tmap = new HashMap<>();
        HashMap<Character,Integer> smap = new HashMap<>();
        int start = 0;
        int min = Integer.MAX_VALUE;
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        int have = 0,left = 0;
        int need = tmap.size();
        for(int right = 0;right<s.length();right++){
            smap.put(s.charAt(right),smap.getOrDefault(s.charAt(right),0)+1);
            if(tmap.containsKey(s.charAt(right)) && tmap.get(s.charAt(right)).intValue() == smap.get(s.charAt(right)).intValue()){
                have++;
            }
            while(have==need){
                if(right-left+1<min){
                    min = right-left+1;
                    start = left;
                }
                smap.put(s.charAt(left),smap.get(s.charAt(left))-1);
                if(tmap.containsKey(s.charAt(left)) && tmap.get(s.charAt(left)).intValue() > smap.get(s.charAt(left)).intValue()){
                have--;
                }
                left++; 
                
            }
        }
        return (min ==Integer.MAX_VALUE) ?"" : s.substring(start,start+min);   
    }
}
