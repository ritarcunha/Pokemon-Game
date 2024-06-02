package game.Player;

public class Position {
private int col;
private int row;

public int getCol (){
    return this.col;
}

public void setCol(int col){
    this.col=col;
}

public int getRow(){
    return this.row;
}

public void setRow(int row){
    this.row=row;
}

public Position (int col, int row){
    this.col=col;
    this.row=row;

}


}
