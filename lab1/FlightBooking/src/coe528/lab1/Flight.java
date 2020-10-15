/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author Vincent
 */
public class Flight 
{
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight(int fnum, String org, String dest, String destTime, int cap, double ogPrice)
    {
        flightNumber = fnum;
        origin = org;
        destination = dest;
        departureTime = destTime;
        capacity = cap;
        originalPrice = ogPrice;        
           
        setNumberOfSeatsLeft(cap);
        
        if (org.equals(dest))
        {
            throw new IllegalArgumentException("Destination and Origin are the same!");          
        }      
    }
    
    public boolean bookASeat()
    {
        int seats = getNumberOfSeatsLeft();
        
        if (seats > 0)
        {
            seats = seats - 1;
            setNumberOfSeatsLeft(seats);
            return true;
        }
        
        else
        {
            return false;
        }  
    }
    
    public void setFlightNumber(int flightNumber)
    {
        this.flightNumber = flightNumber;
    }
    
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    
    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }
    
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft)
    {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    public void setOriginalPrice(double originalPrice)
    {
        this.originalPrice = originalPrice;
    }
    
    public int getFlightNumber()
    {
        return flightNumber;
    }
    
    public String getOrigin()
    {
        return origin;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public String getDepartureTime()
    {
        return departureTime;
    }
    
    public int getCapacity()
    {
        return capacity;
    }
    
    public int getNumberOfSeatsLeft()
    {
        return numberOfSeatsLeft;
    }
    
    public double getOriginalPrice()
    {
        return originalPrice;
    }
    
    @Override
    public String toString()
    {
        return ("Flight #: " + getFlightNumber() + ", " + getOrigin() + " to " + getDestination() + ", " + getDepartureTime() + ", Original Price: $" + getOriginalPrice());
    }
    
    public static void main (String[] args){
    }
}
