public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int target=4;

        int si=0;
        int ei=arr.length-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==target){
                System.out.println("Program started");
               System.out.println(mid);
               return;
            }
            else if(arr[mid]>target){
                ei=mid-1;;
 
            }
            else{
                si=mid+1;

            }
        }
    }

    
}