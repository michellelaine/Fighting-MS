/* 
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

public class Solution {
    public final String[] lessThanTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public final String[] lessThanTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy","Eighty", "Ninety"};
    //public final String[] lessThanThousand = {""};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num);
    }
    
    public String helper(int num){
        String result = "";
        if(num < 10){
            result = lessThanTen[num];
        }else 
        if(num < 20) {
            result =  lessThanTwenty[num - 10];
        }else 
        if(num < 100) {
            result = tens[num / 10] + " " + helper(num % 10);
        }else 
        if(num < 1000) {
            result = lessThanTen[num / 100] + " Hundred " + helper(num % 100);
        }else
        if(num < 1000000) {
            result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        }else 
        if(num < 1000000000) {
            result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        }else {
            result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        return result.trim();
    }
}
