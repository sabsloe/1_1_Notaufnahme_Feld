
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
        if (warteliste.istLeer()==false)
        {
            Patient pat = warteliste.entfernen();
            listeAktualisieren();
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
                listeAktualisieren();
                txtName.setText("");
            }
        }
    }

    public void listeAktualisieren()
    {
        listView.getItems().clear();
        Patient[] liste = warteliste.getListe();
        for (int i = 0; i < warteliste.getAnzahl(); i++)
        {
            listView.getItems().add(liste[i].getName());
        }
    }

}