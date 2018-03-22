package com.neural.network;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class App {
    public static void main(String[] args) {
        double[] arr1 = {1, 2, 3};
        double[] arr2 = {1, 2, 2};
        RealVector v1 = new ArrayRealVector(arr1);
        RealVector v2 = new ArrayRealVector(arr2);

        System.out.println(v1 + " " +  v1.getDimension());


    }
}
