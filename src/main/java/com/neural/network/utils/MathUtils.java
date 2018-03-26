package com.neural.network.utils;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class MathUtils {
    public static RealVector randomFilledVector(int vectorSize) {
        ArrayRealVector vector = new ArrayRealVector(vectorSize);

        for (int i = 0; i < vectorSize; i++) {
            vector.setEntry(i, Math.random());
        }
        return vector;
    }
}
