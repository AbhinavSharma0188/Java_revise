public class partitionRevise {
    public static void main(String[] args) {
        int arr[]={5,7,2,3,8,1,4};
        int si=0;
        int ei=arr.length-1;
        int item=arr[ei];
        int idx=si;
        for(int i=si;i<ei;i++){
            if(arr[i]<=item){
                int temp=arr[idx];
                arr[idx]=arr[i];
                arr[i]=temp;
                idx++;
            }

        }
        int temp=arr[idx];
        arr[idx]=arr[ei];
        arr[ei]=temp;
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }

    
}
