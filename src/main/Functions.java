package main;

public interface Functions {

    static void calculateElectricity(){

    }

    static Double calculateGas(Double cubicMeter, Double pcs, Double priceMc){
        Double result=pcs*cubicMeter*priceMc;
        return result;
    }

    static Double calculateElec(Double index,Double price){
        Double result=index*price;
        return result;
    }




}
