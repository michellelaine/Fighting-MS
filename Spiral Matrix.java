/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }//boundary check to see whether can go forward to the recursion
        spiralHelper(res, matrix, 0, matrix.length -1, 0, matrix[0].length - 1);
        return res;
    }
    
    private void spiralHelper(List<Integer> res, int[][] matrix, int x1, int x2, int y1, int y2) {
        // int m = matrix[0].length;
        // int n = matrix.length;
        // x2 = x1 + n - 1;
        // y2 = y1 + m - 1;
        int n = x2 - x1 + 1;
        int m = y2 - y1 + 1;
        
        //corner case I
        if (x1 > x2 || y1 > y2 ) {
            return ;
        }
        //conrer case II
         if (x1 == x2 && y1 == y2) {
            res.add(matrix[x1][y1]);
            return;
        }
        //corner case III
        if(y1 == y2) {
            for(int i = x1; i <= x2; i++){
                res.add(matrix[i][y1]);
            }
            return;
        }
        //corner case IV
        if(x1 == x2) {
            for(int i = y1; i <= y2; i++) {
                res.add(matrix[x1][i]); 
            }
            return;
        }
        
        /*----->*/
        for(int i = y1; i <= y2; i++) {
            res.add(matrix[x1][i]);
        }
        /* from up right to down right*/
        for(int i = x1 + 1; i < x2; i++) {
            res.add(matrix[i][y2]);
        }
        /*<-----*/
        for(int i = y2; i >= y1; i--) {
            res.add(matrix[x2][i]);
        }
        /*from down left to up left*/
        for(int i = x2 - 1; i > x1; i-- ) {
            res.add(matrix[i][y1]);
        }
        
        spiralHelper(res, matrix, x1 + 1,  x2 - 1, y1 + 1, y2 - 1);
    
    }
}
