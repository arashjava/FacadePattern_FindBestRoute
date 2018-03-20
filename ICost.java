/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacade;

import java.util.ArrayList;

/**
 *
 * @author arash
 */
public interface ICost {
    public Integer[] getBestCost(ArrayList<Integer> routeCost);
    public ArrayList<Integer> getCosts( String s1, String s2);
}
