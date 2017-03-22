package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import it.polito.tdp.spellchecker.model.*;

public class SpellCheckerController {
	
	Dictionary d= new Dictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private TextArea txtFrase;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label lblError;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lblTime;

    @FXML
    void doClearText(ActionEvent event) {
    	txtResult.clear();
    	txtFrase.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	Long t1= System.nanoTime();
    	String language= cmbLanguage.getValue();
    	
    	d.loadDictionary(language);
    	
    	String frase= txtFrase.getText().toLowerCase().replaceAll("[\\p{Punct}]", "");
    	
    	String array[]=frase.split(" ");
    	
    	
    	ArrayList <String>parole= new ArrayList<String>(Arrays.asList(array));
    	
    	List <RichWord>richWord = d.spellCheckText(parole);
    	
    	int numErrori=0;
    	for(RichWord r : richWord){
    		if(!r.isCorretta()){
    			numErrori++;
    		   txtResult.appendText(r.getParola()+"\n");
    	}}
    	
        Long t2= System.nanoTime();
    	lblError.setVisible(true);
    	lblError.setText("Frase con "+numErrori +" errori");
    	lblTime.setVisible(true);
    	lblTime.setText("Tempo impiegato: "+(t2-t1)/1e9);
    }

    @FXML
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtFrase != null : "fx:id=\"txtFrase\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblError != null : "fx:id=\"lblError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";

        cmbLanguage.getItems().addAll("English", "Italian");
        if(cmbLanguage.getItems().size()>0)
            cmbLanguage.setValue(cmbLanguage.getItems().get(0));

    }
    public void setModel(Dictionary model) {
   		this.d = model;
   	}
}

