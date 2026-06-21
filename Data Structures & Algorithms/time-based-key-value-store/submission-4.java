class Pair {
    String value;
    int timestamp;
    public Pair(String val, int ts) {
        this.value = val;
        this.timestamp = ts;
    }
}
class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair> list = map.get(key);
            int left = 0;
            int right = list.size() - 1;
            String ans = "";
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).timestamp <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if(right<0)return "";
            return list.get(right).value;
        } else
            return "";
    }
}
