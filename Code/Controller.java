import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button userOk;

    @FXML
    private TextField userWeight;

    @FXML
    private TextField userHeight;

    @FXML
    private TextField valueOutput;

    @FXML
    private TextField statusOutput;

    @FXML
    void calculate(ActionEvent event) {

        try {
            Double weightValue = Double.parseDouble((userWeight.getText()));
            Double heightValue = Double.parseDouble(userHeight.getText());
            Double bmiValue = weightValue/((heightValue/100)*(heightValue/100));
            setResult(bmiValue);
        }
        catch (Exception e){
        }
    }

    private void setResult(Double bmiValue) {
        
        try {
            File file = new File("newFile.txt");
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            pw.print("Weight: "+userHeight.getText()+" height: ");
            pw.println(userWeight.getText());
            pw.close();
        }catch (IOException e){
            System.out.println("Error" + e);
        }
        
        valueOutput.setText(bmiValue.toString());
        if(bmiValue <= 18.5){
            statusOutput.setText("Under weight");
        }else if(18.6 <= bmiValue && bmiValue <=24.9){
            statusOutput.setText("Normal weight");
        }else if(25<=bmiValue && bmiValue <= 29.9){
            statusOutput.setText("overweight");
        }else {
            statusOutput.setText("Obesity");
        }
    }

    @FXML
    void initialize() {

    }
}
