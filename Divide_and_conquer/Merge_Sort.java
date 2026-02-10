public class Merge_Sort {
    public static void main(String[] args) {
        int arr[]={5,1,3,4,2};
      int res[] = Sort(arr,0,arr.length-1);
      for(int i=0;i<=res.length-1;i++){
        System.out.print(res[i]+" ");
      }
        
        
    }
    public static int[] Sort(int arr[],int si,int ei){
        if(si==ei){
            int bs[]=new int[1];
            bs[0]=arr[si];
            return bs;
        }
        int mid=(si+ei)/2;
        int fs[]=Sort(arr,si,mid);
        int ss[]=Sort(arr,mid+1,ei);
        return MergeSortedArrays(fs,ss);
    }
    public static int[] MergeSortedArrays(int arr1[],int arr2[]){
        int m=arr1.length;
        int n=arr2.length;
        int newArray[]=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m&&j<n){
            if(arr1[i]<arr2[j]){
                newArray[k]=arr1[i];
                i++;
                k++;

            }
            else{
                newArray[k]=arr2[j];
                k++;
                j++;
            }

        }
      while(i<m){
        newArray[k]=arr1[i];
        i++;
        k++;
      }
      while(j<n){
        newArray[k]=arr2[j];
        j++;
        k++;
      }


     return newArray;
    }

    
}
