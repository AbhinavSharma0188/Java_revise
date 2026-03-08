// class Solution {
//     public String removeOuterParentheses(String str) {
//         String ans="";
//         int counter=0;
//         for(int i=0;i<=str.length()-1;i++){
//             if(str.charAt(i)==')'){
//                 counter--;
//             }
//             if(counter!=0){
//                ans+=str.charAt(i);
//             }
//             if(str.charAt(i)=='('){
//                 counter++;
//             }
//         }
//         return ans;

        
//     }
// }