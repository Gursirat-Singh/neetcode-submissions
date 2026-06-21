class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);
        if(!min.isEmpty() && min.peek()>val){
            min.push(val);
        }else{
            if(min.isEmpty())min.push(val);
            else min.push(min.peek());
        }
    }
    
    public void pop() {
        if(main.isEmpty() || min.isEmpty()) return;
        main.pop();
        min.pop();
    }
    
    public int top() {
        if(main.isEmpty())return -1;
        return main.peek();
    }
    
    public int getMin() {
        if(min.isEmpty())return -1;
        return min.peek();
    }
}
