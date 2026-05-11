class Solution {

    public boolean isAnagram(String a , String b) {
        HashMap<Character, Integer> map = new HashMap<>();

        if(a.length() != b.length()) {
            return false;
        }

        for(int i=0;i<a.length(); i++) {
            char ch = a.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0;i<b.length(); i++) {
            char ch = b.charAt(i);
            map.put(ch, map.getOrDefault(ch, -1) -1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int val = entry.getValue();

            if(val != 0) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int arr[][] = new int[1][1000];
        List<List<String>> list = new ArrayList<>();

        for(int i=0; i< strs.length-1; i++) {

            if(strs[i] !="$") {
                List<String> anagrams = new ArrayList<>();

                for(int j=i+1; j<strs.length; j++) {

                    boolean val = isAnagram(strs[i], strs[j]);
                    if(val) {
                        anagrams.add(strs[j]);
                        strs[j] = "$";
                    }
                }
                anagrams.add(strs[i]);
                list.add(anagrams);
            }
        }

        if(strs[strs.length -1] != "$") {
    
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[strs.length-1]);
            list.add(anagrams);
        }

        return list;
    }
}
