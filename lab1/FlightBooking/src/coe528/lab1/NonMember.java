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
public class NonMember extends Passenger {
    
    public NonMember(String n, int a)
    {
        super (n,a);
    }
    
    @Override
    public double applyDiscount(double p)
    {
        int a = getAge();
        
        if (a > 65)
        {
            return (p - (0.1 * p));
        }
        
        else 
        {
            return(p);
        }
    }
}
