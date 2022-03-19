class FreqStack {
    List<Stack<Integer>> stackList;
    Map<Integer, Integer> map;

    public FreqStack() {
        stackList = new ArrayList();
        map = new HashMap<Integer, Integer>();
    }
    
    public void push(int x) {
        if (!map.containsKey(x)) {
            map.put(x, 0);
        }
        map.put(x, map.get(x) + 1);
        if (stackList.size() < map.get(x)) {
            stackList.add(new Stack<Integer>());
        }
        stackList.get(map.get(x) - 1).push(x);
    }
    
    public int pop() {
        int res = stackList.get(stackList.size() - 1).pop();
        map.put(res, map.get(res) - 1);
        if (stackList.get(stackList.size() - 1).isEmpty()) {
            stackList.remove(stackList.size() - 1);
        }
        return res; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */