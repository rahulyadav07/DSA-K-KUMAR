public class SetMatrixZeroes {

    public static void main(String[] args) {

    }
    // bhai dekh tereko ek matrix di usme tujhe agr koi elemetn 0 milta h toh tujhe uss row aur
    // ur colm ko 0 krna padega

    /**
     * Approch
     * pale traverses kr matrix pr aur check kr ki kaha kaha 0 hai toh usko mark kr le
     * uski row and colmn m kyoki tujab bhi baad m traverse karega toh 0 krne ke liye tohh ussi ke basi pr
     * pta krio ki 0 krna h ki nhi
     *
     */

    public static void setZeroes(int[][] matrix) {

        /**
         * pahle mark kr aur ek edge cases agr tu poora optimal ssulution m jata toh ki tujhe 0,0 poition wale number ko alag store krna h
         * kuki wo poora row khatam kr dega
         */

        int col =1;
        for(int i =0;i< matrix.length;i++) {
            for(int j =0;j< matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    // mark the colm
                    if (j != 0) {
                        matrix[0][j] = 0;
                    }else {
                        col = 0;
                    }
                }
            }
        }

        for(int i =0;i< matrix.length;i++) {
            for(int j =0;j< matrix[0].length;j++) {
                if (matrix[i][j] != 0) {
                   if (matrix[0][j]==0 ||matrix[i][0]==0) {
                       matrix[i][j] =0;
                   }
                }
            }
        }
        if (matrix[0][0] ==0) {
            for(int j =0;j< matrix[0].length;j++){
                matrix[0][j] =0;
            }
        }

        if (col ==0) {
            for (int i =0;i< matrix.length;i++) {
                matrix[i][0] =0;
            }
        }

    }

}
