package com.example.assignment_1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    HashMap<Integer, Double> monomials = new HashMap<>();

    protected HashMap<Integer, Double> stringToPolynomial(String poly){
        HashMap<Integer, Double> temp = new HashMap<>();
        poly = poly.replaceAll("-", "+-");
        String[] terms = poly.replaceAll("\\s+", "").split("\\+");
        for(String term : terms){
            if(term.contains("*x^")){
                String[] monomial = term.split("\\*x\\^");
                temp.put(Integer.parseInt(monomial[1]), Double.parseDouble(monomial[0]));
            } else if (term.contains("x^")) {
                String[] monomial = term.split("x\\^");
                temp.put(Integer.parseInt(monomial[1]), 1.0);
            } else if (term.contains("*x")) {
                temp.put(1, Double.parseDouble(term.substring(0,term.indexOf("*"))));
            } else if (term.contains("-x")) {
                temp.put(1,-1.0);
            } else if (term.contains("x")) {
                temp.put(1,1.0);
            } else {
                temp.put(0,Double.parseDouble(term));
            }
        }
        return temp;
    }

    protected String toText(){
        TreeMap<Integer, Double> sorted = new TreeMap<>(java.util.Collections.reverseOrder());
        sorted.putAll(this.monomials);
        StringBuilder temp = new StringBuilder();
        for(Map.Entry<Integer, Double> monomial: sorted.entrySet()){
            int grade = monomial.getKey();
            double coef = monomial.getValue();
            if(coef != 0) {
                if (coef > 0) temp.append(" + ");
                else temp.append(" - ");
                if (coef * coef != 1) {
                    temp.append(Math.abs(coef));
                    if (grade != 0)
                        temp.append(" * ");
                }
                if (grade != 0) {
                    temp.append("x");
                    if (grade != 1) {
                        temp.append(" ^ ").append(grade);
                    }
                }
                if(grade == 0 && coef == 1)
                    temp.append(coef);
            }
        }
        return temp.toString();
    }

    public Polynomial(String text) {
        this.monomials = stringToPolynomial(text);
    }

    public Polynomial(){
        this.monomials = new HashMap<>();
    }


}
