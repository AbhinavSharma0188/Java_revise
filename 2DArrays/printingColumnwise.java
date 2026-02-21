import java.util.Scanner;

public class printingColumnwise {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int arr[][]=new int[r][c];
        for(int i=0;i<=r-1;i++){
            for(int j=0;j<=c-1;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int col=0;col<=c-1;col++){
            if(col%2==0){
                for(int row=0;row<=r-1;row++){
                    System.out.print(arr[row][col]+" ");
                }
                

            }
            else{
                for(int row=r-1;row>=0;row--){
                    System.out.print(arr[row][col]+" ");
                }
            }
        }
    }

    
}