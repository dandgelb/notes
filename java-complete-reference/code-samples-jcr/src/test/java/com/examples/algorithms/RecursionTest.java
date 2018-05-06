package com.examples.algorithms;

import org.junit.Test;

class Printer {
    void printAllBinaryHelper(int digits, String output) {
        //System.out.println("printHelper(" + digits + ", \"" + output + "\")");
        if(digits == 0) {
            //do nothing
            System.out.println(output);
        } else {
            //TODO
            //print n-digit binary number:
            //  print 0
            //System.out.print(0);
            //  print (n-1)-digit binary number
            printAllBinaryHelper(digits-1, output+"0");
            //  print 1
            //System.out.print(1);
            //  print (n-1)-digit binary number
            printAllBinaryHelper(digits-1, output+"1");
        }
    }
    void printAllBinary(int digits) {
        printAllBinaryHelper(digits, "");
    }

    void reverseStringHelper(int len, String input, String output) {
        System.out.println("reverseStringHelper(" + len + ", \"" + input + "\", \"" + output + "\")");
        if(len == 0) {
            System.out.println(output);
        } else {
            reverseStringHelper(len-1, input.substring(1), input.charAt(0) + output);
        }
    }
    void reverseString(String input) {
        reverseStringHelper(input.length(), input, "");
    }

    void printAllDecimalsHelper(int digits, String output) {
        //System.out.println("printHelper(" + digits + ", \"" + output + "\")");
        if(digits == 0) {
            System.out.println(output);
        } else {
            for(int i = 0; i <= 9; i++) {
                printAllDecimalsHelper(digits-1, output+i);
            }
        }
    }
    void printAllDecimals(int digits) {
        printAllDecimalsHelper(digits, "");
    }
}
public class RecursionTest {
    @Test
    public void testPrintAllBinary() {
        Printer print = new Printer();
        //print.printAllBinary(3);
        //print.reverseString("abc");
        print.printAllDecimals(2);
    }
}
