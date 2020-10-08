public class Sudoko {
    int board [][]= new int[9][9];
    public Sudoko(int puzzle[][]){
        for (int i = 0 ;i<9 ;i++){
            for (int j = 0; j <9 ; j++) {
                board[i][j]=puzzle[i][j];
            }
        }
    }
    public void printSoduko(){
        for (int i = 0 ; i<9 ;i++){
            if (i%3==0&&i!=0) {
                System.out.print("______________________");
                System.out.println();
            }
            for (int j = 0 ; j<9;j++){
                if (j%3==0&&j!=0)
                    System.out.print("| ");
                if (board[i][j] != 0)
                    System.out.print(board[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    private boolean inRow(int row , int num){
        for (int i = 0; i <9 ; i++) {
            if(board[row][i]==num)
                return true;
        }
        return false;
    }
    private boolean inColumn(int column , int num){
        for (int i = 0; i <9 ; i++) {
            if (board[i][column]==num){
                return true;
            }
        }
        return false;
    }
    private boolean inRegion (int row , int column , int num){
        int rbox=row/3;
        int colbox = column/3;
        for (int i = rbox*3 ; i<rbox*3+3;i++){
            for (int j = colbox*3 ; j<colbox*3+3 ;j++){
                if (board[i][j]==num)
                    return true;
            }
        }
        return false;
    }
    private boolean ConstraintsSatsfied(int row,int col , int num){
        return !(inColumn(col,num)||inRow(row, num)||inRegion(row, col, num));
    }
    public boolean solve(){
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if(board[i][j]==0){
                    for (int num = 1 ; num<=10 ; num++){
                        if(ConstraintsSatsfied(i,j,num)){
                            board[i][j]=num;
                            if(solve())
                                return true;
                            board[i][j]=0;
                        }
                    } return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int [][] puzzle ={
                { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
                { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
                { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
                { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };;
Sudoko s = new Sudoko(puzzle);
s.printSoduko();
System.out.println("ـــــــــــــــــــــــ");
s.solve();
s.printSoduko();
    }
}
