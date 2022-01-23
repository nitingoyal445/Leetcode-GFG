class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
    for(int i=0;i<26;i++){
        map.put((char)('a'+i), new ArrayList<>());
    }
    
    for(String word: words){
        int mask =0;
        for(char ch : word.toCharArray()){
            int bit = ch - 'a';
            mask = mask | (1<<bit);
        }
        HashSet<Character> set = new HashSet<>(); // for no duplicate entry
        for(char ch : word.toCharArray()){
            if(set.contains(ch)){
                continue;
            }
            set.add(ch);
            map.get(ch).add(mask);
        }
    }
    List<Integer> res = new ArrayList<>();
    HashMap<String,Integer> set2 = new HashMap<>();
    for(String puzzle : puzzles){
        if(set2.containsKey(puzzle)){
            res.add(set2.get(puzzle));
            continue;
        }
        int mask =0;
        for(char ch : puzzle.toCharArray()){
            int bit = ch - 'a';
            mask = mask | (1<<bit);
        }
        int count = 0;
        
        ArrayList<Integer> list = map.get(puzzle.charAt(0));
        for(int wmask: list){
            if((mask & wmask) == wmask){
                count++;
            }
        }
        set2.put(puzzle, count);
        res.add(count);
    }
    return res;
    }
}