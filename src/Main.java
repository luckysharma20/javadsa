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
static ArrayList<Integer> leaders(int[] arr) {
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
public int[] rearr(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int posIndex = 0, negIndex = 1;

    for (int i = 0; i < n; i++) {
        if (nums[i] > 0) {
            ans[posIndex] = nums[i];
            posIndex += 2;
        } else {
            ans[negIndex] = nums[i];
            negIndex += 2;
        }
    }
    return ans;
}
int majorityElement(int arr[]) {
    int ele=0;
    int cnt=0;
    int n=arr.length;
    for(int i=0;i<n;i++){
        if(cnt==0){
            ele=arr[i];
        }
        if(ele==arr[i]) cnt++;
        else cnt--;
    }
    for (int i=0;i<n;i++){
        if(arr[i]==ele) cnt++;
    }
    if(cnt>(n/2)) return ele;
    return -1;
}
public int maxSubArray(int[] arr) {
    int n=arr.length;
    int res=arr[0];
    int maxi=arr[0];
    for (int i=1;i<n;i++){
        maxi=Math.max(maxi+arr[i],arr[i]);
        res=Math.max(maxi,res);
    }
    return res;
}
public int longestConsecutive(int[] arr) {
    int n=arr.length;
    if (n==0) return 0;
    int longest=1;
    HashSet<Integer> st=new HashSet<>();
    for(int i=0;i<n;i++){
        st.add(arr[i]);
    }
    for (int it:st){
        if(!st.contains(it-1)){
            int cnt=1;
            int x=it;
            while(st.contains(x+1)){
                x++;
                cnt++;
            }
            longest=Math.max(longest,cnt);
        }
    }
    return longest;
}
public List<Integer> majorityElement2(int[] arr) {
    HashMap<Integer,Integer> ans=new HashMap<>();
    ArrayList<Integer> ls=new ArrayList<>();
    int n=arr.length;
    for (int i=0;i<n;i++){
        ans.merge(arr[i],1,Integer::sum);
    }
    for (Map.Entry<Integer,Integer> it:ans.entrySet()){
        if (it.getValue()>(n/3)){
            ls.add(it.getKey());
        }
        if (ls.size()==2) break;
    }
    Collections.sort(ls);
    return ls;
}
public List<List<Integer>> threeSum(int[] arr) {
    int n=arr.length;
    Arrays.sort(arr);
    List<List<Integer>> ans=new ArrayList<>();
    for (int i=0;i<n;i++){
        if (i>0 && arr[i]==arr[i-1]) continue;
        int j=i+1;
        int k=n-1;
        while(j<k){
            int sum=arr[i]+arr[j]+arr[k];
            if (sum<0){
                j++;
            }
            else if (sum>0){
                k--;
            }
            else{
                List<Integer> temp=new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k]));
                ans.add(temp);
                j++;
                k--;
                while(j<k && arr[j]==arr[j-1]) j++;
                while(j<k && arr[k]==arr[k+1]) k--;
            }
        }
    }
    return ans;
}

public void setZeroes(int[][] mat) {
    int n=mat.length;
    int m=mat[0].length;
    int[] row=new int[n];
    int[] col=new int[m];
    for (int i=0;i<n;i++){
        for (int j=0;j<m;j++){
            if (mat[i][j]==0){
                row[i]=1;
                col[j]=1;
            }
        }
    }
    for (int i=0;i<n;i++){
        for (int j=0;j<m;j++){
            if (row[i]==1 || col[j]==1){
                mat[i][j]=0;
            }
        }
    }
}

public void rotate(int[][] matrix) {
    int n=matrix.length;
    for (int i=0;i<n;i++){
        for (int j=i+1;j<n;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
    for (int i=0;i<n;i++){
        int left=0,right=n-1;
        while(left<right){
            int temp=matrix[i][left];
            matrix[i][left]=matrix[i][right];
            matrix[i][right]=temp;
            left++;
            right--;
        }
    }
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
    int[] arr012={1,0,0,2,1,0,2,0,2,0,1,0};
    sort012(arr012);
    for (int i:arr012){
        System.out.print(i+" ");
    }
    System.out.println();
    System.out.println(leaders(arr));
    int[] arr1={1,-2,4,3,4,5,-2,-1,-2};
    int[] result=rearr(arr1);
    for(int i:result) System.out.print(i+" ");
    System.out.println();
    System.out.println(majorityElement(arr1));
    System.out.println(maxSubArray(arr1));
    System.out.println(longestConsecutive(arr1));
    System.out.println(majorityElement2(arr012));
    System.out.println(threeSum(arr1));
}

