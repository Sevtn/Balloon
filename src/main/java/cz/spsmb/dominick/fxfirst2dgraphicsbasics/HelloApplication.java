package cz.spsmb.dominick.fxfirst2dgraphicsbasics;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {
    public static final int SCREEN_WIDTH = 1900;
    public static final int SCREEN_HEIGHT = 960;

    Player player;


    GraphicsContext graphicsContext;
    Random random = new Random();


    Direction direction = Direction.down;


    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();



        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            KeyCode key = event.getCode();
            switch (key) {
                case W -> {
                    System.out.println("w");
                    direction = Direction.up;
                }
                case A -> {
                    System.out.println("A");
                    direction = Direction.left;
                }
                case S -> {
                    System.out.println("S");
                    direction = Direction.down;
                }
                case D -> {
                    System.out.println("D");
                    direction = Direction.right;
                }
            }
        });

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            System.out.println(String.format("Clicked on %s   %s",x,y));

            boolean clickedOnBalloon = isInColision(player, x, y);
            if (clickedOnBalloon){
                player = new Player(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT));
                System.out.println(clickedOnBalloon);
            }

        });



        stage.setTitle("Baloon Demo!");
        stage.setScene(scene);
        stage.show();


        player = new Player(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT));



        AnimationTimer animationTimer = new AnimationTimer() {
            long lastTick = 0;

            @Override
            public void handle(long now) {

                if (now - lastTick > 1000000) {
                    lastTick = now;
                    tick();
                }
            }
        };
        animationTimer.start();



    }

    private boolean isInColision(Player player, double x, double y) {
        //return x >= player.x && x <= player.x+ player.width && y >= player.y && y <= player.y+ player.height;
        return (player.x <= x && player.x+player.width >= x && player.y <= y && player.y + player.height >= y);

    }

    private void tick() {




        clearScreen();
        // kazde preklesleni obrazovky

        Image currentPlayerTexture = player.getImages()[0];
        switch (direction) {

            case up:
                player.decrementY();
                break;
            case down:
                player.incrementY();
                break;
            case left:
                player.decrementX();
                currentPlayerTexture = player.getImages()[1];
                break;
            case right:
                player.incrementX();
                currentPlayerTexture = player.getImages()[0];
                break;
        }

//   currentPlayerTexture = player.getImages()[0];
  ;
        graphicsContext.drawImage(currentPlayerTexture, player.x, player.y, player.height, player.height);




    }




    private void clearScreen() {

        graphicsContext.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public static void main(String[] args) {
        launch();
    }
}