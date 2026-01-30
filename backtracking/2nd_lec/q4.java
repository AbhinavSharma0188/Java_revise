class q4{
    public static void main(String[] args) {
        int coin[]={2,1,3,5};
        int amount=4;
        back(coin,amount,"",0);
    }
    public static void back(int coin[],int amount,String ans,int index){
        if(amount==0){
            System.out.println(ans);
            return;
        }
        for(int i=index;i<=coin.length-1;i++){
            if(amount>=coin[i]){
                back(coin, amount-coin[i], ans+coin[i],i);
            }
        }
    }
}