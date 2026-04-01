import java.util.HashMap;

public class intersection {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr1[] = {1,2,2,1};
        int arr2[] = {2,2};
        for(int i=0;i<=arr1.length-1;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i])+1);
            }
            else{
                map.put(arr1[i],1);
            }
           

        }
         System.out.print(map);


        
    }
}