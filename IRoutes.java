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
public interface IRoutes {
    public int findDirectRoute(String directRoute);
    public ArrayList<String> getRoutes(String s1, String s2);
}
