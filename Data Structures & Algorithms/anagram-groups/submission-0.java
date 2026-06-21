class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            String key = sort(str);
            
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        return new ArrayList<>(map.values());
    }

    private static String sort(String str) {
        int[] freq = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                res.append((char)(i + 'a'));
                freq[i]--;
            }
        }
        
        return res.toString();
    }
}