package main;

public class Functions {

    public void calculateElectricity(){

    }

    public Double calculateGas(Double cubicMeter, Double pcs, Double priceMc){
        Double result=pcs*cubicMeter*priceMc;
        return result;
    }

    public Double calculateElec(Double index,Double price){
        Double result=index*price;
        return result;
    }




}
