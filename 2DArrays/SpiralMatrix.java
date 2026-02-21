public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int minrow=0;
        int maxrow=arr.length-1;
        int mincol=0;
        int maxcol=arr[0].length-1;

        while(minrow<=maxrow && mincol<=maxcol){

            // top row
            for(int i=mincol;i<=maxcol;i++){
                System.out.print(arr[minrow][i]+" ");
            }
            minrow++;

            // right column
            for(int i=minrow;i<=maxrow;i++){
                System.out.print(arr[i][maxcol]+" ");
            }
            maxcol--;

            // bottom row
            if(minrow<=maxrow){
                for(int i=maxcol;i>=mincol;i--){
                    System.out.print(arr[maxrow][i]+" ");
                }
                maxrow--;
            }

            // left column
            if(mincol<=maxcol){
                for(int i=maxrow;i>=minrow;i--){
                    System.out.print(arr[i][mincol]+" ");
                }
                mincol++;   
            }
        }
    }
}