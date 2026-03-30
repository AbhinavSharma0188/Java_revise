public class coin {
    public static void main(String[] args) {
        int arr[]={2,1,3,5};
        int amount=4;
        coinn(arr,amount,"",0);
    }
    public static void coinn(int arr[],int amount,String ans,int idx){
        if(amount<0){
            return;

        }
        if(amount==0){
            System.out.println(ans);
            return;
        }
        for(int i=idx;i<=arr.length-1;i++){
        if(amount>=arr[i]){

            coinn(arr, amount-arr[i], ans+arr[i],i);
        
        }
    }

    
}}