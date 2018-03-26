package com.neural.network.activationFunction;

import org.apache.commons.math3.linear.RealVector;

public interface IActivationFunction {
    double activationValue(double singleValue);
    RealVector activationValue(RealVector vector);

    double activationDerivativeValue(double singleValue);
    RealVector activationDerivativeValue(RealVector vector);
}
