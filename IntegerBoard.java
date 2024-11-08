public class IntegerBoard<T> implements GameBoard<T>{
    T[][] puzzle; 




    public IntegerBoard(GameBoard<Integer> board) {
        int width = board.getWidth();
        int height = board.getHeight();
    }

    
    public IntegerBoard(T[][] puzzle){
        this.puzzle=puzzle;
    }

    
    @Override
    public T getCell(int x, int y) throws IndexOutOfBoundsException {
        return puzzle[x][y];
    }

    @Override
    public void setCell(int x, int y, Object value) throws IndexOutOfBoundsException {
        value= puzzle[x][y] ; //pas sure 
    }

    @Override
    public int getWidth() {
        return puzzle.length;
    }

    @Override
    public int getHeight() { 
        return puzzle[0].length;
    }

    @Override
    public void display() {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }


}
