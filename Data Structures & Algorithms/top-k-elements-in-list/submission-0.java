class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i =0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());

        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int [] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i]= entries.get(i).getKey();
        }
        return res;
        
    }
}
