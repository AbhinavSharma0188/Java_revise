package SlidingWindow;

public class maxSizedSubarray {
    public static void main(String[] args) {
         int arr[]={1, 2, 3, 1, 1, 1, 1};
    int k=6;
    int sum=0;
    int ans=0;
    
    for(int i=0;i<=k-1;i++){
        sum=sum+arr[i];

        
    }
    ans=sum;

    for(int i=k;i<=arr.length-1;i++){
        sum=sum+arr[i]-arr[i-k];

        ans=Math.max(ans, sum);


    }
    System.out.println(ans);
    }
   
}
