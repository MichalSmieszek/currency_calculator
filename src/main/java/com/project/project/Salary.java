package com.project.project;


import static java.lang.Math.round;


public class Salary {

    Currency currency=new Currency();

    Salary(){
    }

    public String polishMoney(double dailyMoney){
        double salary=(dailyMoney*22-1200)*0.81;
        salary=((double)(round(100*salary)))/100;
        return (Double.toString(salary));
    }
    public String germanMoney(double dailyMoney){
        double salary=(dailyMoney*22-800)*0.8*currency.getCurrency("EUR");
        salary=((double)(round(100*salary)))/100;
        return(Double.toString(salary));
    }
    public String britishMoney(double dailyMoney){
        double salary=(dailyMoney*22-600)*0.75*currency.getCurrency("GBP");
        salary=((double)(round(100*salary)))/100;
        return(Double.toString(salary));
    }

}