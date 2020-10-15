/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vincent
 */
public class JUnitTest {
    
    @Test
    public void testConstructor()
    {
        Flight xyz = new Flight(2150, "Sydney" , "Hong Kong", "2:30", 800, 3500);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor()
    {
        Flight abc = new Flight(1420, "Tokyo", "Tokyo", "1:00", 100, 2000);
    }
    
    @Test
    public void testMethods()
    {
        Flight xyz = new Flight(2150, "Sydney" , "Hong Kong", "2:30", 800, 3500);
        
        xyz.getCapacity();
        xyz.getDestination();
        xyz.getDepartureTime();
        xyz.getFlightNumber();
        xyz.getNumberOfSeatsLeft();
        xyz.getOrigin();
        xyz.getOriginalPrice();
        
        xyz.setCapacity(800);
        xyz.setDestination("Hong Kong");
        xyz.setDepartureTime("2:30");
        xyz.setFlightNumber(2150);
        xyz.setNumberOfSeatsLeft(126);
        xyz.setOrigin("Sydney");
        xyz.setOriginalPrice(3500);
    } 
    
}
