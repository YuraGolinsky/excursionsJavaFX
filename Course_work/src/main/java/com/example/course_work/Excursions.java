package com.example.course_work;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Excursions {
    private String Name;
    private String CountryandCity;
    private String transport;
    private double Trivality_of_excursions;
    private double Price;
    public Excursions(){}
    public Excursions(String Name, String CountryandCity, String transport, double Trivality_of_excursions, double Price) {

        this.Name = Name;
        this.CountryandCity = CountryandCity;
        this.transport = transport;

        this.Trivality_of_excursions = Trivality_of_excursions;
        this.Price = Price;

    }



    public String getCountryandCity(){ return CountryandCity;}

    public String getName(){ return Name;}

    public double getTrivality_of_excursions(){ return Trivality_of_excursions;}

    public String gettransport(){ return transport;}

    public double getPrice(){ return Price;}

    public void setCountryandCity(String CountryandCity) { this.CountryandCity = CountryandCity;}

    public void setName(String Name){ this.Name=Name;}

    public void settransport(String transport){ this.transport = transport;}

    public void setTrivality_of_excursions(double Trivality_of_excursions){
        this.Trivality_of_excursions = Trivality_of_excursions;}

    public void setPrice(double Price){ this.Price = Price;}

    public String toString(){ return
            Name+"\t\t"+CountryandCity+"\t\t"+transport+"\t\t"+Trivality_of_excursions+"\t\t"+Price+"\n";}

    public void writeData(PrintWriter printWriter){ printWriter.println(Name+"//"+CountryandCity+"//"+transport+"//"+Trivality_of_excursions+"//"+Price);
    }

    public void readData(String s, BufferedReader in) throws IOException {
        StringTokenizer t = new StringTokenizer(s,"//");
        Name = t.nextToken();
        CountryandCity = t.nextToken();
        transport = t.nextToken();
        Trivality_of_excursions = Double.parseDouble(t.nextToken());
        Price = Double.parseDouble(t.nextToken());

    }

}