/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

/**
 *
 * @author arash
 */
public class MyFacade {

    /**
     * @param args the command line arguments
     */
    static ArrayList<String> al= new ArrayList<String>();
    static ArrayList<Integer> alDistance= new ArrayList<Integer>();
    static ArrayList<Integer> alCost= new ArrayList<Integer>();
    public static void main(String[] args) {
        makeDistancesCosts();
        
        // Facede class
        WhereTo wt= new WhereTo();
        wt.getRoute();
        
        findRoutes(wt.source,wt.destination);
    }
 
    private static void findRoutes(String s1, String s2){ 
        String directRoute=s1+"-"+s2;
        IRoutes routes= new Routes();
        ArrayList<String> testRoute= routes.getRoutes( s1, s2);

        int _ind=routes.findDirectRoute(directRoute);
        if (_ind<0) {
            System.out.println("There is no routes specified like this..Please try another one...");
            return;
        }
        System.out.println("For direct route: "+ directRoute+ " distance= "+alDistance.get(_ind)+ " km with cost $"+alCost.get(_ind));
        System.out.println("-------------------------------------");
        ICost costs= new Costs();
        ArrayList<Integer> testRouteCost= costs.getCosts( s1, s2);
        IDistance distance= new Distances();
        ArrayList<Integer> testRouteDistance= distance.getDistances(s1, s2);
        
        Integer[] indexes = costs.getBestCost(testRouteCost);
        showBestCosts( indexes, testRoute, testRouteCost, testRouteDistance);
 
        Integer[] indexes1 = distance.getBestDistance(testRouteDistance);
        showBestDistances(indexes1, testRoute, testRouteDistance, testRouteCost);
        
        System.out.println("-------------------------------------");
        System.out.println("All the one connection routes: ");
        System.out.println("-------------------------------------");
       for(int i=0; i< testRoute.size(); i++){
            System.out.println(testRoute.get(i)+ " Cost: $"+ testRouteCost.get(i)+ " Distance: "+ testRouteDistance.get(i)+" km");
        }
    }
 
   
    private static void showBestCosts(Integer[] indexes, ArrayList<String> routes, ArrayList<Integer> routeCost, ArrayList<Integer> routeDistance){

        System.out.println("The other cheapest routes with one connection are: ");
        int priority;
        for (int i=0; i<indexes.length; i++){
            if (indexes[i]<3){
                priority=indexes[i]+1;
                System.out.println("\t "+priority+":"+ routes.get(i)+ " --> $"+routeCost.get(i) +", distance="+ routeDistance.get(i)+" km");
            }
        }
    }

    private static void showBestDistances(Integer[] indexes, ArrayList<String> routes, ArrayList<Integer> routeDistance, ArrayList<Integer> routeCost){

        System.out.println("The other shortest routes with one connection are: ");
        int priority;
        for (int i=0; i<indexes.length; i++){
            if (indexes[i]<3){
                priority=indexes[i]+1;
                System.out.println("\t "+priority+":"+ routes.get(i)+ " --> "+routeDistance.get(i)+" km,  $" + routeCost.get(i));
            }
        }
    }
    
    private static void makeDistancesCosts(){
        String[] str= {"A", "B" , "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
             "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X" ,"Y", "Z"};

          int temp;
          for (int i=0; i< str.length; i++){
              for(int j=0; j<str.length; j++){
                  if (str[i]!= str[j]){
                      al.add(str[i]+"-"+str[j]);
                      alDistance.add((int)(Math.random() * 10000));
                      temp=(int)(Math.random() * 2000);
//                      while(temp==0){
//                          temp=(int)(Math.random() * 10);
//                      }
                      alCost.add(temp);
                  }
              }
          } 
    }
}
