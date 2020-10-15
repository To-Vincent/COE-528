/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;
import java.util.*;

/**
 *
 * @author Vincent
 */
public class Manager
{
    public Manager(){   
    }
    
    ArrayList<Flight> flightlist = new ArrayList<Flight>();
    
    public void createFlights()
        //flight num, origin, dest, time, cap, price
    {
        flightlist.add(new Flight(0001, "Toronto", "Vancouver", "8:30", 100, 600));
        flightlist.add(new Flight(0002, "Montreal", "New York", "7:20", 200, 700));
        flightlist.add(new Flight(0003, "Toronto", "Tokyo", "3:50", 700, 3000));
        flightlist.add(new Flight(0004, "Seoul", "Ho Chi Minh", "1:40", 500, 2500));
        flightlist.add(new Flight(0005, "Bejing", "Shanghai", "5:00", 300, 1000));
        flightlist.add(new Flight(0006, "Austin", "Los Angles", "2:20", 100, 450));
        flightlist.add(new Flight(0007, "Hong Kong", "Toronto", "4:20", 800, 2000));
    }
    
    public void displayAvailableFlights(String origin, String destination) 
    {
        Flight f = null;
        for (int i = 0; i < flightlist.size(); i++) 
        {
            if (flightlist.get(i).getOrigin().equals(origin) && flightlist.get(i).getDestination().equals(destination)) 
            {
                if (flightlist.get(i).getNumberOfSeatsLeft() > 0) 
                {
                    f = flightlist.get(i);
                } 
                
                else 
                {
                    System.out.println("Flight is full");
                }
            }
        }
        if (f == null) 
        {
            System.out.println("This flight does not exsist");
        } 
        
        else 
        {
            System.out.println(f.toString());
        }

    }
   
        public Flight getFlight(int flightNumber) 
        {
        for (int i = 0; i < flightlist.size(); i++) 
        {
            if (flightlist.get(i).getFlightNumber() == flightNumber) 
            {
                return (flightlist.get(i));
            }
        }
        return null;
    }
        
    public void bookSeat(int flightNumber, Passenger p) 
    {
        double newticketprice;
        Ticket t;
        Flight f = getFlight(flightNumber);
        
        if (f == null) 
        {
            System.out.println("This flight doesn't exsist");
        } 
        else 
        {
            if (f.bookASeat()) 
            {
                newticketprice = p.applyDiscount(f.getOriginalPrice());
                t = new Ticket(p, f, newticketprice);
                System.out.println(t.toString());
            }
        }
    }
    
    public static void main(String[] args) 
        {
        Manager m = new Manager();
        m.createFlights();
        //name, age, memb years
        Passenger Sono = new Member("Sono Khan", 45, 12);
        Passenger Renier = new NonMember("Renier Moyano", 22);
        Passenger Alex = new NonMember("Alex Allen", 66);
        Passenger Aidan = new Member("Aidan Naimool", 20, 2);

        m.displayAvailableFlights("Toronto", "Halifax");
        m.displayAvailableFlights("Montreal", "New York");
        m.displayAvailableFlights("Toronto", "Tokyo");

        m.bookSeat(0002, Sono);
        m.bookSeat(0003, Renier);
        m.bookSeat(0005, Alex);
        m.bookSeat(0007, Aidan);

    }
}
