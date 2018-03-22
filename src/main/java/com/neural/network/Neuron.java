package com.neural.network;

import com.neural.network.utils.MathUtils;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class Neuron {
    private IActivationFunction activationFunction;
    private RealVector weights;
    private double bias;
    boolean ifBiasIsUsed;
    private double z;
    private double activation;

    public Neuron(IActivationFunction activationFunction, boolean ifBiasIsUsed, int previousLayerDimension) {
        this.activationFunction = activationFunction;
        this.ifBiasIsUsed = ifBiasIsUsed;

        weights = MathUtils.randomFilledVector(previousLayerDimension);

        if (ifBiasIsUsed) {
            bias = Math.random();
        } else {
            bias = 0;
        }
    }

    public void updateActivationValues(RealVector input) {
        z = weights.dotProduct(input);
        activation = activationFunction.activationValue(z) + bias;
    }

    public double getZDerivative() {
        return activationFunction.activationDerivativeValue(z);
    }

    public double getActivation() {
        return activation;
    }
}
