package com.example.assignment_1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML
    private TextField poly1;
    @FXML
    private TextField poly2;
    @FXML
    private TextField result;
    @FXML
    private RadioButton addition;
    @FXML
    private RadioButton subtract;
    @FXML
    private RadioButton multiply;
    @FXML
    private RadioButton divide;
    @FXML
    private RadioButton derivate;
    @FXML
    private RadioButton integrate;
    @FXML
    private ToggleGroup opp;


    protected Polynomial addPolynomial(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial temp = new Polynomial();
        for(Map.Entry<Integer, Double> monomial: polynomial1.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(), monomial.getValue());
        }
        for(Map.Entry<Integer, Double> monomial: polynomial2.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(),monomial.getValue() + temp.monomials.getOrDefault(monomial.getKey(), 0.0));
        }
        return temp;
    }

    protected Polynomial subtractPolynomial(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial temp = new Polynomial();
        for(Map.Entry<Integer, Double> monomial: polynomial1.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(), monomial.getValue());
        }
        for(Map.Entry<Integer, Double> monomial: polynomial2.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(),temp.monomials.getOrDefault(monomial.getKey(), 0.0) - monomial.getValue());
        }
        return temp;
    }

    protected Polynomial multiplyPolynomial(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial temp = new Polynomial();
        for(Map.Entry<Integer, Double> monomial: polynomial1.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(), monomial.getValue());
        }
        for(Map.Entry<Integer, Double> monomial: polynomial2.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(),temp.monomials.getOrDefault(monomial.getKey(), 0.0) * monomial.getValue());
        }
        return temp;
    }

    protected Polynomial dividePolynomial(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial temp = new Polynomial();
        for(Map.Entry<Integer, Double> monomial: polynomial1.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(), monomial.getValue());
        }
        for(Map.Entry<Integer, Double> monomial: polynomial2.monomials.entrySet()){
            temp.monomials.put(monomial.getKey(),temp.monomials.getOrDefault(monomial.getKey(), 0.0) / monomial.getValue());
        }
        return temp;
    }

    protected Polynomial derivatePolynomial(Polynomial polynomial1){
        Polynomial temp = new Polynomial();
        for(Map.Entry<Integer, Double> monomial: polynomial1.monomials.entrySet()){
            temp.monomials.put(monomial.getKey()-1, monomial.getValue()* monomial.getKey());
        }
        return temp;
    }

    protected Polynomial integratePolynomial(Polynomial polynomial1){
        Polynomial temp = new Polynomial();
        for(Map.Entry<Integer, Double> monomial: polynomial1.monomials.entrySet()){
            temp.monomials.put(monomial.getKey()+1, monomial.getValue()/ (monomial.getKey()+1));
        }
        return temp;
    }

    @FXML
    protected void calculateButton() {
        if(addition.isSelected()) {
            Polynomial polynomial1 = new Polynomial(poly1.getText());
            Polynomial polynomial2 = new Polynomial(poly2.getText());
            Polynomial temp = addPolynomial(polynomial1,polynomial2);
            result.setText(temp.toText());
        } else if (subtract.isSelected()) {
            Polynomial polynomial1 = new Polynomial(poly1.getText());
            Polynomial polynomial2 = new Polynomial(poly2.getText());
            Polynomial temp = subtractPolynomial(polynomial1,polynomial2);
            result.setText(temp.toText());
        } else if (multiply.isSelected()) {
            Polynomial polynomial1 = new Polynomial(poly1.getText());
            Polynomial polynomial2 = new Polynomial(poly2.getText());
            Polynomial temp = multiplyPolynomial(polynomial1,polynomial2);
            result.setText(temp.toText());
        } else if (divide.isSelected()) {
            Polynomial polynomial1 = new Polynomial(poly1.getText());
            Polynomial polynomial2 = new Polynomial(poly2.getText());
            Polynomial temp = dividePolynomial(polynomial1,polynomial2);
            result.setText(temp.toText());
        } else if (derivate.isSelected()) {
            Polynomial polynomial1 = new Polynomial(poly1.getText());
            Polynomial temp = derivatePolynomial(polynomial1);
            result.setText(temp.toText());
        } else {
            Polynomial polynomial1 = new Polynomial(poly1.getText());
            Polynomial temp = integratePolynomial(polynomial1);
            result.setText(temp.toText());
        }
    }
}