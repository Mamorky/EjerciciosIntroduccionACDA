package com.example.mamorky.ejerciciost1accesoadatos.Ejercicio1;

/**
 * Created by mamorky on 29/09/17.
 */

public class Conversor {

    public double getDolares() {
        return dolares;
    }

    public void setDolares(double dolares) {
        this.dolares = dolares;
    }

    public double getEuros() {
        return euros;
    }

    public void setEuros(double euros) {
        this.euros = euros;
    }

    public enum TipoCambio {
        euroDolar,
        dolarEuro
    };

    private double dolares;
    private double euros;

    public Conversor(double cantidad,TipoCambio tipo,double cambio){
        if(tipo.equals(TipoCambio.dolarEuro)){
            setDolares(cantidad);
            setEuros((double)(Math.round(cantidad/cambio*100d)/100d));
        }
        if(tipo.equals(TipoCambio.euroDolar)){
            setEuros(cantidad);
            setDolares((double)(Math.round(cantidad*cambio*100d)/100d));
        }
    }
}
