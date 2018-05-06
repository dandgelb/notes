package com.examples.algorithms;

import org.junit.Test;

import java.util.Vector;

class Dice {
    public void diceSumHelper(int dice, int desiredSum, Vector<Integer> chosen) {
        System.out.println("diceSum(" + dice + ", \"" + desiredSum +"\", " + chosen +  ")" );
        //TODO
        if(dice == 0) {
            //do nothing
            //base case
            if(desiredSum == 0) {
                System.out.println(chosen);
            }
        } else  {
            //i will handle 1 die;
            //try all possible values - 1 through 6 - to see if they can work
            for (int i = 1; i <= 6; i++) {
                //"choose" i
                chosen.add(i);
                //"explore" what could follow that
                diceSumHelper(dice -1, desiredSum - i, chosen);
                //"un-choose" i
                //TODO
                chosen.remove(chosen.size() - 1);

            }
        }
    }
    public void diceSum(int dice, int desiredSum) {
        Vector<Integer> v = new Vector<>();
        diceSumHelper(dice, desiredSum, v);
    }
}

public class BacktrackingTest {
    @Test
    public void diceSumTest() {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(4);
        System.out.println(v);
        v.remove(0);
        System.out.println(v);
        v.remove(0);
        System.out.println(v);
        
        Dice dice = new Dice();
        dice.diceSum(3, 7);
    }       
}
