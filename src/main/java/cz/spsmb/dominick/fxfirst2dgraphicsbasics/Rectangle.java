package cz.spsmb.dominick.fxfirst2dgraphicsbasics;

public class Rectangle {
    int x;
    int y;
    int height;
    int width;

   public boolean isInCollision(Rectangle other){
       boolean colX = this.getX()<other.getX()+ other.width && this.getX() + this.width > other.getX();
       boolean colY =  this.getY()<other.getX()+ other.height && this.getY() + this.height > other.getY();;
       return colX && colY;
   }


    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
        this.height=25;
        this.width=25;
    }


    public Rectangle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

public void incrementX(){
        x++;
}

    public void incrementY(){
y++;
    }

    public void decrementX(){
x--;
    }

    public void decrementY(){
y--;
    }



}
