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
int secondLargest(int[] arr){
    int largest=arr[0];
    int slargest=-1;
    for (int j : arr)
        if (j > largest) {
            slargest = largest;
            largest = j;
        } else if (j > slargest && largest > j) {
            slargest = j;
        }
    return slargest;
}
boolean sorted(int[] arr){
    for(int i=1;i<arr.length;i++){
        if(arr[i]<arr[i-1]) return false;
    }
    return true;
}
boolean sorRot(int [] arr){
    int count=0;
    int n=arr.length;
    for(int i=0;i<n;i++){
        if(arr[i]>arr[(i+1)%n]) count++;
    }
    return count<=1;
}
static void reverse(int[] arr,int start,int end){
    while(start<=end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        start++;
        end--;
    }
}
static void rotateLeft(int[] arr,int k){
    int n=arr.length;
    k=k%n;
    reverse(arr,0,k-1);
    reverse(arr,k,n-1);
    reverse(arr,0,n-1);
}
static void movezeroestoend(int[] arr){
    int n = arr.length;
    int j = -1;
    for (int i = 0; i<n; i++) {
        if (arr[i] == 0) {
            j = i;
            break;
        }
    }
    if (j == -1)
        return;
    for (int i = j + 1; i<n; i++) {
        if (arr[i] != 0) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        }
    }
}
int missingnumber(int[] arr){
    int xor1=0;
    int xor2=0;
    int n=arr.length+1;
    for (int i=0;i<n-1;i++){
        xor2=xor2^arr[i];
        xor1=xor1^(i+1);
    }
    xor1=xor1^n;
    return xor2^xor1;
}
int numberonce(int[] arr){
    int xor1=0;
    int n=arr.length;
    for (int i=0;i<n;i++) xor1 = xor1 ^ arr[i];
    return xor1;
}
static int max(int a,int b){
    if (a>b) return a;
    else return b;
}
static int maxConsecBits(int[] arr) {
    // code here
    int maxcount=0;
    int count=1;
    for (int i=1;i<arr.length;i++){
        if(arr[i]==arr[i-1]) count++;
        else{
            maxcount=max(maxcount,count);
            count=1;
        }
    }
    return max(maxcount,count);
}
static int longestSubarray(int[] arr, int k) {
    // code here
    HashMap<Integer,Integer> mp=new HashMap<>();
    int n=arr.length;
    int maxlen=0,s=0;
    for (int i=0;i<n;i++){
        s+=arr[i];

        if(s==k){
            maxlen=Math.max(maxlen,i+1);
        }
        int rem=s-k;
        if(mp.containsKey(rem)){
            int len=i-mp.get(rem);
            maxlen=Math.max(maxlen,len);
        }
        mp.putIfAbsent(s,i);
    }
    return maxlen;
}
static void sort012(int[] arr) {
    // code here
    int n=arr.length;
    int left=0,mid=0,right=n-1;
    while(mid<=right){
        if (arr[mid]==0){
            int temp=arr[left];
            arr[left]=arr[mid];
            arr[mid]=temp;
            left++;
            mid++;
        }
        else if(arr[mid]==1){
            mid++;
        }
        else{
            int temp=arr[mid];
            arr[mid]=arr[right];
            arr[right]=temp;
            right--;
        }
    }
}
static ArrayList<Integer> leaders(int arr[]) {
    ArrayList<Integer> ans=new ArrayList<>();
    int maxi=Integer.MIN_VALUE;
    int n = arr.length;
    for (int i = n - 1; i >= 0; i--) {
        if (arr[i] >= maxi) {
            ans.add(arr[i]);
            maxi=arr[i];
        }
    }
    Collections.reverse(ans);
    return ans;
}

void main() {
    int[] arr={12,0,34,0,563,0,23,34};
    int n=arr.length;
    IO.println("largest numbers:"+findLargest(arr));
    IO.println("second largest:"+secondLargest(arr));
    IO.println("array is sorted:"+sorted(arr));
    IO.println("array is sorted and rotated:"+sorRot(arr));
    reverse(arr,0,n-1);
    for (int i:arr){
        System.out.print(i+" ");
    }
    System.out.println();
    rotateLeft(arr,4);
    for (int i:arr){
        System.out.print(i+" ");
    }
    System.out.println();
    movezeroestoend(arr);
    for(int i:arr){
        System.out.print(i+" ");
    }
    System.out.println();
    int[] nums={1,2,4,5};
    System.out.println(missingnumber(nums));
    int[] nums1={1,1,2,2,4,5,5};
    System.out.println(numberonce(nums1));
    int[] nums2={1,1,1,0,1,0,0};
    System.out.println(maxConsecBits(nums2));
    System.out.println(longestSubarray(nums2,3));
    int[] arr012={1,0,0,2,1,0,2,0,2,0,1,1,0};
    sort012(arr012);
    for (int i:arr012){
        System.out.print(i+" ");
    }
    System.out.println();
    System.out.println(leaders(arr));
}
