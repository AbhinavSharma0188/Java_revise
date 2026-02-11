public class partition {
    public static void main(String[] args) {
        int arr[]={8,7,3,1,4};
        partition(arr,0,arr.length-1);
    }
    public static void partition(int arr[],int si,int ei){
        int item=arr[ei];
        int idx=si;
        for(int i=si;i<ei;i++){
            if(arr[i]<=item){
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
                idx++;
            }


        }
        int temp=arr[ei];
        arr[ei]=arr[idx];
        arr[idx]=temp;
       for(int i=0;i<=arr.length-1;i++){
        System.out.print(arr[i]+" ");
       }
    }
    
}
