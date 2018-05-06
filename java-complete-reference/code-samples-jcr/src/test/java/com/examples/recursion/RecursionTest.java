package com.examples.recursion;

import org.junit.Test;

class Printer {
    void printAllBinary(int digits) {
        if(digits == 0) {
            //do nothing
        } else {
            //TODO
            //print 3 digit binary number:
            //  print 0
            //  print 2-digit binary number
            //  print 1
            //  print 2-digit binary number
        }
    }
}
public class RecursionTest {
    @Test
    public void testPrintAllBinary() {
        Printer print = new Printer();
        print.printAllBinary(3);
    }
}
