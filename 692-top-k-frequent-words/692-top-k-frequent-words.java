class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            
            public int compare(String word1, String word2){
                int frequency1 = map.get(word1);
                int frequency2 = map.get(word2);
                if(frequency1 == frequency2) return word2.compareTo(word1);
                return frequency1 - frequency2;
            }
        });
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()) list.add(pq.poll());
        
        Collections.reverse(list);
        return list;
    }
}