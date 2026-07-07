//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
int findLargest(int[] numbers){
    int max=numbers[0];
    for(int num:numbers){
        if(num>max){
            max=num;
        }
    }
    return max;
}


void main() {
    int[] arr={12,34,563,23,34};
    IO.println("largest numbers:"+findLargest(arr));
}
