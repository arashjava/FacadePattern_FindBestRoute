/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacade;

import java.util.ArrayList;
import static myfacade.MyFacade.al;
import static myfacade.MyFacade.alCost;

/**
 *
 * @author arash
 */
public class Costs implements ICost{

    @Override
    public Integer[] getBestCost(ArrayList<Integer> routeCost) {
        Integer[] temp =new Integer[routeCost.size()]; //ArrayList<Integer> temp= new ArrayList<Integer>();
        for (int i=0; i<routeCost.size(); i++){
            temp[i]= routeCost.get(i);
         }
      
        ArrayIndexComparator comparator = new ArrayIndexComparator(temp);
        return comparator.createIndexArray();    
    }

    @Override
    public ArrayList<Integer> getCosts( String s1, String s2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0 ; i<al.size(); i++){
           for (int j=0; j< al.size(); j++){
               if (al.get(i).contains(s1+"-") && al.get(j).contains("-" + s2) &&
                      al.get(i).substring(2).equals(al.get(j).substring(0,1)) )
               {

                        arr.add(alCost.get(i)+alCost.get(j));
               }
           }     
        }    
        return arr;
    }   
   
}
