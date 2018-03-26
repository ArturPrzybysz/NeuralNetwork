package com.neural.network.activationFunction;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class SigmoidFunction implements IActivationFunction {
    public double activationValue(double value) {
        return Math.exp(value) / (Math.exp(value) + 1);
    }

    public RealVector activationValue(RealVector vector) {
        RealVector activationVector = new ArrayRealVector(vector.getDimension());
        for (int i = 0; i < vector.getDimension(); i++) {
            activationVector.setEntry(i, activationValue(vector.getEntry(i)));
        }
        return activationVector;
    }

    public double activationDerivativeValue(double singleValue) {
        double sigmoidValue = activationValue(singleValue);
        return sigmoidValue * (1 - sigmoidValue);
    }

    public RealVector activationDerivativeValue(RealVector vector) {
        RealVector activationDerivativeVector = new ArrayRealVector(vector.getDimension());
        for (int i = 0; i < vector.getDimension(); i++) {
            activationDerivativeVector.setEntry(i, activationDerivativeValue(vector.getEntry(i)));
        }
        return activationDerivativeVector;
    }
}
