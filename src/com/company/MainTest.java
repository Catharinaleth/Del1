package com.company;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    //Unit test for klassen Container vessel:
    @Test //Tester hvorvidt det forventet antal containers er = det rigtige antal containers
    void testLoadingCargoContainer(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);
        c.loadingCargo(10,5);
        assertEquals(5, c.getNumbersOfContainer());
    }
    @Test //Tester, hvorvidt kapaciteten er den samme som den forventet
    void testLoadingCargoContainer2(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);
        c.loadingCargo(10,5);
        assertEquals(10,c.getContainerCapacity());
    }

    @Test //Testen om kapaciteten i %, er ens med den forventet kapacitet
    void testUtilityContainer(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);
        c.loadingCargo(10,5);
        assertEquals(50.0, c.utilityLevelOfCapacity());
    }

    //Unit test for klassen Tanker vessel:
    @Test //Tester om antallet af cargo er ens med det forventet antal cargo
    void testLoadingCargoTanker(){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        t.loadingCargo(10);
        assertEquals(10, t.getCargo());
    }

    @Test //Tester om det er sandt at vores random tal er mellem 1 og 10
    void testLoadingCargoTanker2(){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        assertTrue(t.getNumber()>=1 && t.getNumber()<=10);
    }
    @Test //Tester om det er sandt at vores valgte tal er det samme som antal cargo, der bliver loadet
    void TestUtilityTanker (){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        t.setNumber(8);
        t.loadingCargo(8);
        assertTrue(t.getNumber() == t.getCargo());
    }

    @Test //Tester om det er falsk at vores valgte tal er det samme som antal cargo, der bliver loadet
    void TestUtilityTanker2 (){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        t.loadingCargo(8);
        t.setNumber(7);
        assertFalse(t.getNumber() == t.getCargo());
    }
    //Unit test for klassen RoRo Vessel:
    @Test //Tester, hvorvidt det antal af cars er det samme som forventet
    void testLoadingCargoRoRo(){
        RoRoVessel r = new RoRoVessel("Kroatien",10,500,2000,1000);
        r.loadingCargo(4,7);
        assertEquals(4,r.getCars());
    }

    @Test //Tester, hvorvidt det antal af trucks er det samme som forventet
    void testLoadingCargoRoRo2(){
        RoRoVessel r = new RoRoVessel("Kroatien",10,500,2000,1000);
        r.loadingCargo(4,7);
        assertEquals(7,r.getTrucks());
    }

    @Test //Tester, om 24.2 er det samme som kapacaiteten
    void TestUtilityRoRo(){
        RoRoVessel r = new RoRoVessel("Kroatien",10,500,2000,1000);
        r.loadingCargo(4,7);
        assertEquals(24.2,r.utilityLevelOfCapacity());
    }

    //Test for position og fremtidig destination:
    @Test //Tester om den forventet position for x og y er den samme som den rigtige
    void TestPosition(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);
        c.setPositionX(40.0);
        c.setPositionY(50.6);
        assertEquals(40.0, c.getPositionX());
        assertEquals(50.6, c.getPositionY());
    }
    @Test //Tester, hvorvidt den forventet destination er den samme som den rigtige.
    void TestDestination(){
        ContainerVessel c = new ContainerVessel("Indien",4,60,240);
        c.futureDestination("Congo");
        assertEquals("Congo",c.getDestination());
    }

}
