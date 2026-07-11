public ArrayList<Integer> nextLargerElement(int[] arr) {
    int n=arr.length;
    Stack<Integer> s=new Stack<>();
    ArrayList<Integer> v=new ArrayList<>();
    for (int i=n-1;i>=0;i--){
        while(s.size()>0 && s.peek()<=arr[i]){
            s.pop();
        }
        if(s.empty()) v.add(-1);
        else v.add(s.peek());
        s.push(arr[i]);
    }
    Collections.reverse(v);
    return v;
}

public class stackjava {
}

void main() {
    int[] arr={1,5,4,6,7};
    ArrayList<Integer> result=nextLargerElement(arr);
    for (Integer integer : result) {
        System.out.print(integer + " ");
    }
}
