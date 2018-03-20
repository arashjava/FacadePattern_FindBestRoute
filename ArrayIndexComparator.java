/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacade;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author arash
 */
public class ArrayIndexComparator {

    private Integer[] array=null;

    public ArrayIndexComparator(Integer[] temp) {
        array=new Integer[temp.length];
        int minAmt, minIndex ; 
        int index=0;
        while (true){

            minAmt =  Collections.min(Arrays.asList(temp));

            if (minAmt==999999999) break;
            minIndex= Arrays.asList(temp).indexOf(minAmt);
            while(minIndex>=0){
                array[minIndex]=index;
                temp[minIndex]=999999999;
                minIndex= Arrays.asList(temp).indexOf(minAmt);
            }
            index++;
        }
    }

    public Integer[] createIndexArray()
    {
        return array;
    }

  
}
