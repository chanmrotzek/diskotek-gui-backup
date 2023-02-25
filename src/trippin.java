import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class trippin extends Application {

    private static final int SCENE_WIDTH = 400;
    private static final int SCENE_HEIGHT = 400;

    private Box cube;
    private Rectangle background;

    @Override
    public void start(Stage stage) {

        // Create the cube
        cube = new Box(50, 50, 50);
        cube.setTranslateX(SCENE_WIDTH / 0.5);
        cube.setTranslateY(SCENE_HEIGHT / 0.5);

        // Create the background
        background = new Rectangle(0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        background.setFill(Color.BLACK);

        // Add the cube and background to a group
        Group root = new Group(background, cube);

        // Create the animation timeline
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        // Add a keyframe to move the cube around the screen
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(3), new KeyValue(cube.translateXProperty(), SCENE_WIDTH * Math.random()),
                        new KeyValue(cube.translateYProperty(), SCENE_HEIGHT * Math.random()))
        );

        // Add a keyframe to change the background color to a random gradient
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(3), event -> {
                    background.setFill(new javafx.scene.paint.LinearGradient(Math.random(), Math.random(), Math.random(), Math.random(), true, javafx.scene.paint.CycleMethod.REPEAT,
                            new javafx.scene.paint.Stop(0, Color.color(Math.random(), Math.random(), Math.random())),
                            new javafx.scene.paint.Stop(1, Color.color(Math.random(), Math.random(), Math.random()))));
                })
        );

        // Start the animation
        timeline.play();

        // Set up the stage and show it
        Scene scene = new Scene(new Pane(root), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
