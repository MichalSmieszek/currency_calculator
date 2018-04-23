package com.project.project;


import static java.lang.Math.round;


public class Salary {

    Currency currency=new Currency();

    Salary(){
    }
    // Obliczamy pensje z algorytmu z maila  i zaokrąglamy do dwóch miejsc po kropce.
    public double polishMoney(double dailyMoney){
        double salary;
        salary=(dailyMoney*22-1200)*0.81;
        salary=((double)(round(100*salary)))/100;
        return (salary);
    }
    public double germanMoney(double dailyMoney){
        double salary;
        salary=(dailyMoney*22-800)*0.8*currency.getCurrency("EUR");
        salary=((double)(round(100*salary)))/100;
        return(salary);
    }
    public double britishMoney(double dailyMoney){
        double salary;
        salary=(dailyMoney*22-600)*0.75*currency.getCurrency("GBP");
        salary=((double)(round(100*salary)))/100;
        return(salary);
    }

}