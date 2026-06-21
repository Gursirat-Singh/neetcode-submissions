class Solution {
    HashMap<String,List<String>> map = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();
    public String encode(List<String> strs) {
       String str = "";
       for(String s : strs){
        str += s;
       }
       list.add(str);
       map.put(str,strs);
       return str;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
