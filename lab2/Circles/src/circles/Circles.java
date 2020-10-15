package circles;

import java.util.stream.Stream;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * A lab #2 exercise file.
 * @author Vincent
 */
public class Circles extends Application 
{
  //variables
  private int row;
  private int col;
  private Spinner<Integer> rowSpinner;
  private Spinner<Integer> colSpinner;
  private Spinner<Integer> xScaleSpinner;
  private Spinner<Integer> yScaleSpinner;
  private VBox root;
  private HBox controls;
  private Pane canvas;
  private Button starter;
  private Slider cellSlider;
  
  @Override
  public void start(Stage primaryStage) 
  {
    //vbox 
    root = new VBox();
    root.setAlignment(Pos.CENTER);
    
    //pane
    canvas = new Pane();
    canvas.setPrefSize(750, 750);
    
    //button
    starter = new Button("Circles");
    controls = new HBox(10);
    controls.setAlignment(Pos.CENTER);
    
    //spinners (min,max,start)
    rowSpinner = new Spinner<>(1, 5, 3);
    colSpinner = new Spinner<>(1, 5, 3);
    xScaleSpinner = new Spinner<>(-3, 3, 0);
    yScaleSpinner = new Spinner<>(-3, 3, 0);
    
    //spinner alignment
    rowSpinner.setPrefWidth(50);
    colSpinner.setPrefWidth(50);
    xScaleSpinner.setPrefWidth(50);
    yScaleSpinner.setPrefWidth(50);
    
    //spinner values
    rowSpinner.valueProperty().addListener(o -> launchCircles());
    colSpinner.valueProperty().addListener(o -> launchCircles());
    xScaleSpinner.valueProperty().addListener(o -> launchCircles());
    yScaleSpinner.valueProperty().addListener(o -> launchCircles());
    
    //slider & slider alignment
    cellSlider = new Slider(50, 150, 100);
    cellSlider.valueProperty().addListener(o -> launchCircles());
    Label cellLabel = new Label();
    cellLabel.setPrefWidth(20);
    cellLabel.textProperty().bind(Bindings.createStringBinding(() -> String.format("%3d", new Object[] 
    { (int)cellSlider.getValue()}), 
            new Observable[] { cellSlider.valueProperty() }));
    
    //labelling spinners and sliders
    controls.getChildren().addAll(new Node[] { makeLabeledNode("Rows", rowSpinner), 
    makeLabeledNode("Columns", colSpinner), 
    makeLabeledNode("Cell Size", new HBox(new Node[] { cellSlider, cellLabel })), 
    makeLabeledNode("X-Scale", xScaleSpinner), 
    makeLabeledNode("Y-Scale", yScaleSpinner) });
    addButtonHandler();
    
    //collect everything
    root.getChildren().addAll(new Node[] { canvas, controls });
    primaryStage.setTitle("Lab #2 Exercise");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
    launchCircles();
  }
  
  //vbox for labels
  private VBox makeLabeledNode(String label, Node node) 
  {
    VBox vb = new VBox(10, new Node[] { new Label(label), node });
    vb.setAlignment(Pos.CENTER);
    return vb;
  }
  
  //create circles
  private void launchCircles() 
  {
    canvas.getChildren().clear();
    addAllRowsToCanvas(makeAllRows());
  }
  
    /**
     * This method adds the handler to the button that gives
     * this application its behavior.
     */
  private void addButtonHandler() 
  {
    starter.setOnAction(e -> launchCircles());
  }
  
  //adding all rows to canvas
  private void addAllRowsToCanvas(Stream<Stream<Circle>> rows) 
  {
    row = 0;
    rows.forEach(r -> 
    {
        addRowToCanvas(r);
        row++;
    });
  }
  
  //max rows
  private Stream<Stream<Circle>> makeAllRows() 
  {
    return Stream.<Stream<Circle>>generate(() -> makeRow()).limit((rowSpinner.getValue()));
  }
  
  //creating row
  private Stream<Circle> makeRow() 
  {
    return Stream.<Circle>generate(() -> new Circle(cellSlider.getValue()/4)).limit((colSpinner.getValue()));
  }
  
  //adding additional rows
  private void addRowToCanvas(Stream<Circle> s) 
  {
    col = 0;
    s.forEach(c -> 
    {
        addToCanvas(c);
        col++;
    });
  }
  
  //canvas
  private void addToCanvas(Circle c) 
  {
    c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
    
    double toX = col * cellSlider.getValue() + cellSlider.getValue()/2;    
    double fromX = cellSlider.getValue() - cellSlider.getValue()/2;
    c.setCenterX(fromX);
    
    double toY = row * cellSlider.getValue() + cellSlider.getValue()/2;
    double fromY = cellSlider.getValue() - cellSlider.getValue()/2;
    c.setCenterY(fromY);
    
    canvas.getChildren().add(c);
    
    //transformations and translations
    TranslateTransition tTrans = new TranslateTransition(Duration.millis(500));
    tTrans.setNode(c);
    tTrans.setByX(toX - fromX);
    tTrans.setByY(toY - fromY);
    tTrans.play();
    
    ScaleTransition sTrans = new ScaleTransition(Duration.millis(500 * Math.random() + 500));
    sTrans.setNode(c);
    sTrans.setByX((xScaleSpinner.getValue()));
    sTrans.setByY((yScaleSpinner.getValue()));
    sTrans.setCycleCount(-1);
    sTrans.setAutoReverse(true);
    sTrans.play();
  }
  
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
    launch(args);
  }    
}
