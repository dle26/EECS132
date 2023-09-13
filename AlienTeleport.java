//Author: Dung Le
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class AlienTeleport extends Application {
   Region r1 = new Region(100, 100, 150);
   Region r2 = new Region(500, 500, 150);
   Region r3 = new Region(200, 200, 100);
   Image alien = new Image("alien.png");
   ImageView image = new ImageView(alien);
 
 public void start(Stage primaryStage) { 
   image.setX(r3.getX());
   image.setY(r3.getY());
   
   Rectangle rec1 = new Rectangle(r1.getX(), r1.getY(), r1.getSize(), r1.getSize());
   rec1.setFill(Color.BLACK);
   Rectangle rec2 = new Rectangle(r2.getX(), r2.getY(), r2.getSize(), r2.getSize());
   rec2.setFill(Color.BLACK);
   
   Group root = new Group(rec1, rec2, image);

   Scene scene = new Scene(root, 900, 900, Color.WHITE);
  
   scene.setOnKeyPressed(this::processKeyPress);
   
   primaryStage.setTitle("Problem 3");
   primaryStage.setScene(scene);
   primaryStage.show();
 }

 public void processKeyPress(KeyEvent event) {
    switch (event.getCode()) {
      case UP:
        r3.move(0, -10);
        image.setX(r3.getX());
        image.setY(r3.getY());
        break;
      case DOWN:
        r3.move(0, 10);
        image.setX(r3.getX());
        image.setY(r3.getY());
        break;
      case RIGHT:
        r3.move(10, 0);
        image.setX(r3.getX());
        image.setY(r3.getY());
        break;
      case LEFT:
        r3.move(-10, 0);
        image.setX(r3.getX());
        image.setY(r3.getY());
        break;
      default:
        break;  // do nothing if it's not an arrow key
        }
    
    if (r3.inRegion(r2)) {
      r3.moveImageViewIntoRegion(image, r1);
    } else if (r3.inRegion(r1)) {
         r3.moveImageViewIntoRegion(image, r2);
      } 
 }
 
 
 public static void main(String[] args) {
   launch(args);
 }

}

