class CustomStack {
    List<Integer> stack;
    int max;
    public CustomStack(int maxSize) {
        stack = new ArrayList<>();
        max = maxSize;
    }
    
    public void push(int x) {
        if(stack.size() < max) {
            stack.add(x);
        }
    }
    
    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            return stack.remove(stack.size()-1);
        }
    }
    
    public void increment(int k, int val) {
        if(k >= stack.size()) {
            k = stack.size();
        }
        for(int i = 0; i < k; i++) {
            stack.set(i, stack.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */