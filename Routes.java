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
public class Routes implements IRoutes{

    @Override
    public ArrayList<String> getRoutes(String s1, String s2) {
        ArrayList<String> arr = new ArrayList<String>();
        for (int i=0 ; i<al.size(); i++){
           for (int j=0; j< al.size(); j++){
                if (al.get(i).contains(s1+"-") && al.get(j).contains("-" + s2) &&
                   al.get(i).substring(2).equals(al.get(j).substring(0,1)) ){
                   arr.add(al.get(i)+"-"+al.get(j));
               }
           }     
        }    
        return arr;
    }

    @Override
    public int findDirectRoute(String directRoute) {
                int ind=-1;
        for (int i=0; i<al.size(); i++){
            System.out.println("");
            if(al.get(i).equals(directRoute)) {
                ind = i;
                break;
            }
        }
        return ind;
    }
}
