public class IntegerBoard<T> implements GameBoard<T>{
    T[][] puzzle; 




    public IntegerBoard(GameBoard<Integer> board) {
        int width = board.getWidth();
        int height = board.getHeight();
    }

    
    public IntegerBoard(T[][] puzzle){
        this.puzzle= puzzle;
    }
     
    @Override
    public T getCell(int x, int y) throws IndexOutOfBoundsException {
        return puzzle[x][y];
    }

    @Override
    public void setCell(int x, int y, T value) throws IndexOutOfBoundsException {
        puzzle[x][y]=value ; //pas sure 
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

    // public IntegerBoard<T> copy() {
    //     T[][] newPuzzle = (T[][]) new Object[getWidth()][getHeight()]; // nvl instanciation :( 

    
    //     for (int i = 0; i < getWidth(); i++) {
    //         for (int j = 0; j < getHeight(); j++) {
    //             newPuzzle[i][j] = this.getCell(i, j);
    //         }
    //     }
    //     return new IntegerBoard<>(newPuzzle);
    // }
    public IntegerBoard copy() {
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, grid[i].length);
        }
        return new IntegerBoard(newGrid);
    }

    
    
    


}
