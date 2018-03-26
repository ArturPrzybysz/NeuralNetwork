package com.neural.network;

import com.neural.network.activationFunction.IActivationFunction;
import org.apache.commons.math3.linear.ArrayRealVector;
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

    public RealVector getDerivativesOfZ() {
        RealVector derivatives = new ArrayRealVector(neurons.size());

        for (int i = 0; i < neurons.size(); i++) {
            derivatives.setEntry(i, neurons.get(i).getZDerivative());
        }
        return derivatives;
    }

    private RealVector z;

    public Layer(IActivationFunction activationFunction, int numberOfNeurons, boolean ifBiasIsUsed, int previousLayerDimension) {
        activations = new ArrayRealVector(numberOfNeurons);
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

    public Neuron getNeuron(int number) {
        return neurons.get(number);
    }


}
