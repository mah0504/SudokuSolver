public class IntegerBoard implements GameBoard{
    Integer[][] puzzle;

    public IntegerBoard(Integer[][] puzzle){
        this.puzzle=puzzle;
    
    }

    @Override
    public Object getCell(int x, int y) throws IndexOutOfBoundsException {
        return puzzle[x][y];
    }

    @Override
    public void setCell(int x, int y, Object value) throws IndexOutOfBoundsException {

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
