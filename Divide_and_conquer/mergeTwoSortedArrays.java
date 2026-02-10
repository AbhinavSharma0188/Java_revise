public class mergeTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[]={2,3,5,7,11};
        int arr2[]={1,2,3,7,12,13,14,15};
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

      for(int a=0;a<=newArray.length-1;a++){
        System.out.print(newArray[a]+" ");
      }

    }
}
