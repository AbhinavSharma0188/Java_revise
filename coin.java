public class coin {
    public static void main(String[] args) {
        int arr[]={2,1,3,5};
        int amount=4;
        coinn(arr,amount,"");
    }
    public static void coinn(int arr[],int amount,String ans){
        if(amount<0){
            return;

        }
        if(amount==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<=arr.length-1;i++){
        if(amount>=arr[i]){

            coinn(arr, amount-arr[i], ans+arr[i]);
        
        }
    }

    
}}