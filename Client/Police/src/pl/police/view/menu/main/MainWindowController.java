/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import pl.police.FrontController;
import pl.police.Interfaces.gui.SetableScene;
import pl.police.MainApp;

/**
 *
 * @author Bartosz
 */
public class MainWindowController implements SetableScene, Initializable {

    @FXML
    private TextArea textArea;
    private Sphere earth;
    private PhongMaterial material;
    private PointLight sun;
    private final DoubleProperty sunDistance = new SimpleDoubleProperty(100);
    private final BooleanProperty sunLight = new SimpleBooleanProperty(true);
    private final BooleanProperty diffuseMap = new SimpleBooleanProperty(true);
    private final BooleanProperty specularMap = new SimpleBooleanProperty(true);
    private final BooleanProperty bumpMap = new SimpleBooleanProperty(true);
    private final BooleanProperty selfIlluminationMap = new SimpleBooleanProperty(true);
    private Node node;
    private MainApp mainApp;
    private String caret;

    public MainWindowController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/menu/main/MainWindow.fxml"));
            loader.setController(this);
            Parent pane = null;
            pane = loader.load();
            setNode(pane);
            caret = FrontController.getInstance().getSettingsController().getServerCaret();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Parent createContent() throws Exception {
        Image dImage = new Image(getClass().getClassLoader().getResource("resources/earth-d.jpg").toExternalForm());
        Image nImage = new Image(getClass().getClassLoader().getResource("resources/earth-n.jpg").toExternalForm());
        Image sImage = new Image(getClass().getClassLoader().getResource("resources/earth-s.jpg").toExternalForm());
        Image siImage = new Image(getClass().getClassLoader().getResource("resources/earth-l.jpg").toExternalForm());

        material = new PhongMaterial();
        material.setDiffuseColor(Color.WHITE);
        material.diffuseMapProperty().bind(
                Bindings.when(diffuseMap).then(dImage).otherwise((Image) null));
        material.setSpecularColor(Color.TRANSPARENT);
        material.specularMapProperty().bind(
                Bindings.when(specularMap).then(sImage).otherwise((Image) null));
        material.bumpMapProperty().bind(
                Bindings.when(bumpMap).then(nImage).otherwise((Image) null));
        material.selfIlluminationMapProperty().bind(
                Bindings.when(selfIlluminationMap).then(siImage).otherwise((Image) null));

        earth = new Sphere(5);
        earth.setMaterial(material);
        earth.setRotationAxis(Rotate.Y_AXIS);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(0, 0, -20));
        sun = new PointLight(Color.rgb(255, 243, 234));
        sun.translateXProperty().bind(sunDistance.multiply(-0.82));
        sun.translateYProperty().bind(sunDistance.multiply(-0.41));
        sun.translateZProperty().bind(sunDistance.multiply(-0.41));
        sun.lightOnProperty().bind(sunLight);

        AmbientLight ambient = new AmbientLight(Color.rgb(1, 1, 1));
        Group root = new Group();
        root.getChildren().add(camera);
        root.getChildren().add(earth);
        root.getChildren().add(sun);
        root.getChildren().add(ambient);

        RotateTransition rt = new RotateTransition(Duration.seconds(24), earth);
        rt.setByAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setCycleCount(Animation.INDEFINITE);

        TranslateTransition tT
                = new TranslateTransition(Duration.seconds(24), earth);
        tT.setFromX(-3);
        tT.setToX(3);
        tT.setAutoReverse(true);
        tT.setCycleCount(Timeline.INDEFINITE);

        
        ParallelTransition sq = new ParallelTransition();
        sq.getChildren().addAll(
                rt, tT);
        sq.setCycleCount(Animation.INDEFINITE);
        sq.play();

        SubScene subScene = new SubScene(root, 800, 400, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.TRANSPARENT);
        subScene.setCamera(camera);
        subScene.minWidth(0);
        subScene.minHeight(0);
        return new Group(subScene);
    }

    @Override
    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public Node getNode() {
        BorderPane n = (BorderPane) node;
        try {
            n.setCenter(createContent());
            return n;
        } catch (Exception ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    public void writeMessage(String message) {
        if (textArea != null) {
            textArea.appendText(caret + message + System.getProperty("line.separator"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

}
