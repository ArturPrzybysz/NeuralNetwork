package com.neural.network;

import com.neural.network.activationFunction.IActivationFunction;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private Layer previousLayer;
    private Layer nextLayer;

    private List<Neuron> neurons;
    private boolean isBiasUsed;
    private RealVector activations;
    private RealVector z;

    public Layer(IActivationFunction activationFunction, int numberOfNeurons, boolean ifBiasIsUsed,
                 int previousLayerDimension, Layer previousLayer, Layer nextLayer) {
        this.previousLayer = previousLayer;
        this.nextLayer = nextLayer;

        activations = new ArrayRealVector(numberOfNeurons);
        neurons = new ArrayList<Neuron>(numberOfNeurons);
        for (int i = 0; i < numberOfNeurons; i++) {
            neurons.add(i, new Neuron(activationFunction, ifBiasIsUsed, previousLayerDimension));
        }
    }

    public void updateWeightValues(RealVector errors, double learningRate) {
        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).updateWeightValues(errors.getEntry(i), previousLayer.activations, learningRate);
        }
    }

    public RealVector getActivationVector() {
        return activations;
    }

    public RealVector getDerivativesOfZ() {
        RealVector derivatives = new ArrayRealVector(neurons.size());
        for (int i = 0; i < neurons.size(); i++) {
            derivatives.setEntry(i, neurons.get(i).getZDerivative());
        }
        return derivatives;
    }

    public RealMatrix getWeightMatrix() {
        RealMatrix weights = new Array2DRowRealMatrix().createMatrix(neurons.get(0).getWeights().getDimension(), neurons.size());
        for (int i = 0; i < neurons.size(); i++) {
            weights.setColumnVector(i, neurons.get(i).getWeights());
        }
        return weights;
    }

    public void updateActivationValues(RealVector input) {
        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).updateActivationValues(input);
            activations.setEntry(i, neurons.get(i).getActivation());
        }
    }

    public Neuron getNeuron(int number) {
        return neurons.get(number);
    }
}
