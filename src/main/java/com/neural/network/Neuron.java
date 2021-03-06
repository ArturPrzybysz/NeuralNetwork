package com.neural.network;

import com.neural.network.activationFunction.IActivationFunction;
import com.neural.network.utils.MathUtils;
import org.apache.commons.math3.linear.RealVector;

public class Neuron {
    private IActivationFunction activationFunction;
    private RealVector weights;
    private boolean ifBiasIsUsed;
    private double z;
    private double activation;

    public void updateWeightValues(double error, RealVector previousLayerActivations, double learningRate) {
        for (int i = 0; i < weights.getDimension(); i++) {
            weights.setEntry(i, weights.getEntry(i) + learningRate * previousLayerActivations.getEntry(i) * error);
        }
    }

    public Neuron(IActivationFunction activationFunction, boolean ifBiasIsUsed, int previousLayerDimension) {
        this.activationFunction = activationFunction;
        this.ifBiasIsUsed = ifBiasIsUsed;

        if (ifBiasIsUsed) {
            previousLayerDimension++;
        }
        weights = MathUtils.randomFilledVector(previousLayerDimension);
    }

    public void updateActivationValues(RealVector input) {
        z = weights.dotProduct(input);
        activation = activationFunction.activationValue(z);
    }

    public RealVector getWeights() {
        return weights;
    }

    public double getZDerivative() {
        return activationFunction.activationDerivativeValue(z);
    }

    public double getActivation() {
        return activation;
    }
}
