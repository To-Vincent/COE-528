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
public class Member extends Passenger
{
    int yearsOfMembership;
    
    public Member(String n, int a, int years)
    {
        super(n, a);
        this.yearsOfMembership = years;
    }
    
    public void setYears(int years)
    {
        this.yearsOfMembership = years;
    }
    
    public int getYears()
    {
        return(yearsOfMembership);
    }
    
    @Override
    public double applyDiscount(double p)
    {
        int member = getYears();
        
        if (member > 5)
        {
            return (p - (0.5 * p));
        }
        
        else if (member >= 1 && member <= 5)
        {
            return (p - (0.1 * p));
        }
        
        else
        {
            return (p);
        }
    }
}
