package com.neural.network;

import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Neuron> neurons;

    private boolean isBiasUsed;

    public RealVector getActivationVector() {
        return activations;
    }

    private RealVector activations;

    public Layer(IActivationFunction activationFunction, int numberOfNeurons, boolean ifBiasIsUsed, int previousLayerDimension) {
        neurons = new ArrayList<Neuron>(numberOfNeurons);
        for (int i = 0; i < numberOfNeurons; i++) {
            neurons.add(i, new Neuron(activationFunction, ifBiasIsUsed, previousLayerDimension));
        }
    }

    public void updateActivationValues(RealVector input) {
        for (Neuron n : neurons) {
            n.updateActivationValues(input);
        }
    }


}
