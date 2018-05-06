package com.examples.algorithms;

import org.junit.Test;

import java.util.Vector;

class Util {

    public void permute(Vector<String> v) {
        
    }
    public void permuteHelper(Vector<String> v, Vector<String> chosen) {

    }

}
public class PermutationTest {
    @Test
    public void noTest() {
        //Vector of strings as a parameter
        //output all possible rearrangements/permutations of the strings in vector
        //What is the vector that is easy to permute - empty vector - super easy
        Util util  = new Util();
        Vector<String> v = {"M", "A", "R", "T", "y"};
        util.permute(v);
    }
}