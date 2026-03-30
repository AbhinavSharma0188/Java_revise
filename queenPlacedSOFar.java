public class queenPlacedSOFar {
    public static void main(String[] args) {
        int n=4;
        boolean arr[]=new boolean[n];
        int tq=2;
        permutations(arr,tq,0,"");
    }
    public static void permutations(boolean arr[],int tq,int qpsf,String ans){
        if(qpsf==tq){
            System.out.println(ans);
            return;
        }
        


        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]==false){
                arr[i]=true;
                permutations(arr, tq, qpsf+1, ans+"b"+(i+1)+"q"+(qpsf+1)+" "        );
                arr[i]=false;
            }
        }
    }

    
}