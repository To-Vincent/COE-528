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
public class Ticket 
{
    Passenger p;
    Flight flight;
    double price;
    int ticketNumber;    
    
    public Ticket(Passenger p, Flight flight, double price)
    {
        this.p = p;
        this.flight = flight;
        this.price = price;
    }
    
    public void setFlight(Flight f)
    {
        this.flight = f;
    }
        
    public void setPassenger(Passenger p)
    {
        this.p = p;
    }
        
    public void setTicketNumber(int tktNum)
    {
        this.ticketNumber = tktNum;
    }
        
    public Passenger getPassenger()
    {
        return(p);
    }
        
    public Flight getFlight()
    {
        return(flight);
    }
        
    public double getPrice()
    {
        return (price);
    }
        
    public int getTicketNumber()
    {
        return(ticketNumber);
    }
        
    @Override
    public String toString()
    {
        return (p.getName() + ", Flight Number: " + flight.getFlightNumber() + ", Origin: " + flight.getOrigin() + ", Destination: " + flight.getDestination() + ", Capacity: " + flight.getCapacity() + ", Original Price: $" + flight.getOriginalPrice() + ", Ticket Price: $" + price);
    }
}

