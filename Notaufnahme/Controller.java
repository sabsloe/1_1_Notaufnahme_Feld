
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class Controller {

    Warteliste warteliste;

    @FXML
    private ListView listView;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblMeldung;

    public Controller()
    {
        warteliste = new Warteliste();
    }

    // Aufruf eines weiteren Patienten
    // Meldung im entspeichenden Feld
    @FXML
    public void aufruf(ActionEvent event) {
        Patient pat = warteliste.entfernen();
        if (pat != null)
        {  
            listView.getItems().remove(pat.getName());
            lblMeldung.setText("Nächster Patient: " + pat.getName());
        }
        else { 
            lblMeldung.setText("Kein Patient");
        }

    }     

    // Einfügen per Button einfügen
    @FXML
    public void einfuegen(Event event) {
        patientEinfuegen();
    }

    // Einfügen per Return
    @FXML
    public void handleTxtEinfuegen(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
        {
            patientEinfuegen();
        }

    }

    public void patientEinfuegen()
    {
        String name = txtName.getText();
        if (name.equals("")){
            lblMeldung.setText("Kein Name?");
        }
        else {
            if (warteliste.istVoll())
            {
                lblMeldung.setText("Alle Plätze sind belegt!");
            }
            else
            {
                Patient pat = new Patient(name);
                warteliste.einfuegen(pat);
                listView.getItems().add(name);
                txtName.setText("");
            }
        }
    }

    

}