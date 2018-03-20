/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacade;

import java.util.ArrayList;
import static myfacade.MyFacade.al;

/**
 *
 * @author arash
 */
public class Distances implements IDistance{



    @Override
    public ArrayList<Integer> getDistances( String s1, String s2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0 ; i<al.size(); i++){
           for (int j=0; j< al.size(); j++){
               if (al.get(i).contains(s1+"-") && al.get(j).contains("-" + s2) &&
                      al.get(i).substring(2).equals(al.get(j).substring(0,1)) )
               {
 //                  System.out.println(MyFacade.alDistance.get(i)+MyFacade.alDistance.get(j));
                        arr.add(MyFacade.alDistance.get(i)+MyFacade.alDistance.get(j));
               }
           }     
        }    
        return arr;
    }   

    @Override
    public Integer[] getBestDistance(ArrayList<Integer> routeDistance) {
        Integer[] temp =new Integer[routeDistance.size()]; //ArrayList<Integer> temp= new ArrayList<Integer>();
        for (int i=0; i<routeDistance.size(); i++){
            temp[i]= routeDistance.get(i);
        }
      
        ArrayIndexComparator comparator = new ArrayIndexComparator(temp);
        return comparator.createIndexArray();        }
   
}
