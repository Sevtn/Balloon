package cz.spsmb.dominick.fxfirst2dgraphicsbasics;

import javafx.scene.image.Image;

import java.net.URL;

public class Player extends Rectangle {
    public static final String TEXTURE_RIGHT ="/images/player.png";
    public static final String TEXTURE_LEFT ="/images/player_left.png";
    Image[] images;




    public Player(int x, int y) {
        super(x, y);
        loadloadTextures();
    }

    public Player(int x, int y, int height, int width) {
        super(x, y, height, width);
        loadloadTextures();
    }

private void loadloadTextures(){
        images = new Image[2];
        URL imageURLLeft = getClass().getResource(TEXTURE_LEFT);
        URL imageURLRight = getClass().getResource(TEXTURE_RIGHT);
        if (imageURLLeft != null && imageURLRight != null) {
            images[0] = new Image(imageURLLeft.toString());
            images[1] = new Image(imageURLRight.toString());
            setWidth((int)images[0].getWidth()/2);
            setHeight((int)images[0].getHeight()/2);
        }
        else {
            System.out.println("Texture could not be loaded");
        }
}


    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }


}
