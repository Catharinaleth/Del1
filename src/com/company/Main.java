//Portfolio del 1
package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Opretter container vessel
        ContainerVessel c = new ContainerVessel("Danmark", 5.5, 10.0, 20.5); //objekt
        c.loadingCargo(10,5);
        System.out.println("The capacity of the container vessel is " + c.utilityLevelOfCapacity()+ "%");

        //Opretter Tanker vessel
        TankerVessel t = new TankerVessel("Tyskland", 5, 20, 40); //objekt
        t.loadingCargo(8);
        System.out.println("Numbers of compartments: " + t.getNumber());
        t.utilityLevelOfCapacity();

        //Opretter RoRo vessel
        RoRoVessel r = new RoRoVessel("Kroatien", 10, 500, 2000, 1000);
        r.loadingCargo(4,7);
        System.out.println(r.utilityLevelOfCapacity() + " % of the lane is used");
    }
}
abstract class Vessels {
    private String flagNation;
    private double draft;
    private double width;
    private double length;


    //Constructor, som kan anvendes i de forskellige klasser
    public Vessels (String flagNation, double draft, double width, double length){
        this.flagNation = flagNation;
        this.draft = draft;
        this.width = width;
        this.length = length;
    }
}

class ContainerVessel extends Vessels {
    private double containerCapacity;
    private int numbersOfContainer;
    private double positionX;
    private double positionY;
    private String destination;

    public ContainerVessel(String flagNation, double draft, double width, double length) {
        super(flagNation, draft, width, length);
    }
    //Getters og setters så vi kan tilgå klassens private værdier:
    public double getContainerCapacity(){return containerCapacity;}
    public int getNumbersOfContainer(){return numbersOfContainer;}
    public void loadingCargo(int containerCapacity, int numbersOfContainer ) {
        this.containerCapacity = containerCapacity;
        this.numbersOfContainer = numbersOfContainer;
    }
    public double utilityLevelOfCapacity() {
        return (numbersOfContainer/containerCapacity)*100;
    }

    //Metoder til unit test + udvidelse af programmet:
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(double positionY) { //tilføjet
        this.positionY = positionY;
    }
    public double getPositionX(){return positionX;}
    public double getPositionY(){return positionY;}
    public String getDestination(){return destination;}
    public void futureDestination(String destination){
        this.destination = destination;
    }
}
class TankerVessel extends Vessels {
    private int cargo;
    private int compartments;
    private boolean isCompartmentFilled = false;
    Random r = new Random();
    private int number = r.nextInt(10 + 1);


    public TankerVessel(String flagNation, double draft, double width, double length) { //constructor
        super(flagNation, draft, width, length);
        compartments = number; //Et random antal compartments mellem 1-10
    }
    public int getCargo() {
        return cargo;
    }
    public void setNumber(int number) { //tilføjet
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    //Metoder som anvendes til unit test:
    public void loadingCargo(int cargo) {
        //ingen sikkerheds tjek for at se om der er plads?
        this.cargo = cargo;
    }
    public boolean setCompartmentFilled(boolean isCompartmentFilled) {
        this.isCompartmentFilled = isCompartmentFilled;
        return isCompartmentFilled;
    }
    public void utilityLevelOfCapacity () {
        if(compartments == cargo ){
            setCompartmentFilled(true);
            System.out.println("All the compartments are full");
        }
        else if (compartments > cargo){
            setCompartmentFilled(false);
            int n = compartments - cargo;
            System.out.println(n + " of the compartments are empty!");
        }
        else {
            setCompartmentFilled(false);
            int h = cargo - compartments;
            System.out.println("There is not room for the last " + h + " cargos");
        }
    }
}
class RoRoVessel extends Vessels {
    private double laneMeters;
    private int cars; //8 meter
    private int trucks; //30 meters

    public RoRoVessel(String flagNation, int draft, int width, int length, double laneMeters){
        super(flagNation, draft, width, length);
        this.laneMeters = laneMeters;
    }
    //Tilgå klassens variabler:
    public int getTrucks(){return trucks;}
    public int getCars(){return cars;}

    //Metoder til unit test
    public void loadingCargo (int cars, int trucks) {
        this.cars = cars;
        this.trucks = trucks;
    }
    public double utilityLevelOfCapacity() {
        return (cars*8+trucks*30) / laneMeters*100;
    }
}