// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>(); // no duplicates in res
        for(int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if(set.contains(substring)) {
                res.add(substring);
            }
            set.add(substring);
        }
        return new ArrayList<>(res); // imp
    }
}