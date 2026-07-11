ArrayList<Integer> nextgreaterelement(int[] arr){
    int n=arr.length;
    ArrayList<Integer> result=new ArrayList<>();
    Stack<Integer> s=new Stack<>();
    for (int i=n-1;i>=0;i--){
        while(!s.isEmpty() && s.peek()<=arr[i]){
            s.pop();
        }
        if(s.empty()) result.add(-1);
        else result.add(s.peek());
        s.push(arr[i]);
    }
    Collections.reverse(result);
    return result;
}
void main() {
    int[] arr={2,3,4,4,1,23,4};
    ArrayList<Integer> result=nextgreaterelement(arr);
    for (Integer integer : result) {
        System.out.print(integer + " ");
    }
}
