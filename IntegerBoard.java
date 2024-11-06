public class IntegerBoard<T> implements GameBoard<T>{
    T[][] puzzle; 

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
        
    }


}
