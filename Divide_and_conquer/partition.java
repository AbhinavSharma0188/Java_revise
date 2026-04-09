public class partition {
    public static void main(String[] args) {
        int arr[]={8,7,3,1,4};
       int idx= partition(arr,0,arr.length-1);
        System.out.println(idx);
    }
    public static int partition(int arr[],int si,int ei){
        int item=arr[ei];
        int idx=si;
        for(int i=si;i<ei;i++){
            if(arr[i]<=item){
                int temp=arr[i];;
                arr[i]=arr[idx];
                arr[idx]=temp;
                idx++;
            }


        }
        int temp=arr[ei];
        arr[ei]=arr[idx];
        arr[idx]=temp;
     return idx;
    }
    
}
