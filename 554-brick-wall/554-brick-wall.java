class Solution {
    public int leastBricks(List<List<Integer>> walls) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxJoint = 0;
        for(List<Integer> layer:walls){
            int sum = 0;
            for(int i = 0;i<layer.size()-1;i++){
                sum+=layer.get(i);
                map.put(sum, map.getOrDefault(sum,0)+1);
                maxJoint = Math.max(maxJoint, map.get(sum));
            }
        }
        return walls.size()-maxJoint;
    }
}