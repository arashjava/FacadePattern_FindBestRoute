/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacade;

import java.util.Scanner;

/**
 *
 * @author arash
 */
public class WhereTo {
    protected String source;
    protected String destination;
    
    public void getRoute(){
        Scanner sc= new Scanner(System.in); 
        System.out.print("Please enter departure: A~Z are valid.");
        source = sc.nextLine().toUpperCase();
        System.out.println("----------------");
        System.out.print("Please enter destination: A~Z are valid.");
        destination = sc.nextLine().toUpperCase();
    }
    
}
