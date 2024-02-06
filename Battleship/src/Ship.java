public class Ship {
    protected int row,column;

    public Ship(){
        this.row = 0;
        this.column = 0;
    }

    public void setPosition(int row,int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return  this.row;
    }
    public int getColumn(){
        return  this.column;
    }

}
