package com.examples.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.Vector;

class Util {

    public void permute(Vector<String> v) {
        Vector<String> chosen = new Vector<>();
        permuteHelper(v, chosen);
    }
    //{a, b, c, d}
    public void permuteHelper(Vector<String> v, Vector<String> chosen) {
        System.out.println("permute v = " + v + ", chosen = " + chosen);
        if(v.isEmpty()) {
            //base case
            System.out.println(chosen);
        } else {
            //for each choice:
            for (int i = 0; i < v.size(); i++) {
                // - choose
                String s = v.get(i);
                chosen.add(s);   // {a}
                v.remove(i);            // {b, c, d}
                // - explore
                permuteHelper(v, chosen);
                // - un-choose
                chosen.remove(chosen.size() - 1);
                v.insertElementAt(s, i);
            }
        }
    }

}
public class PermutationTest {
    @Test
    public void noTest() {
        //Vector of strings as a parameter
        //output all possible rearrangements/permutations of the strings in vector
        //What is the vector that is easy to permute - empty vector - super easy
        Util util  = new Util();
        String [] array = {"M", "A", "R", "T", "Y"};
        Vector<String> v = new Vector<>(Arrays.asList(array));
        util.permute(v);
    }
}