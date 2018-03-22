package com.neural.network;

import exceptions.MismatchingVectorSizeException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.List;

public class Backpropagation {
    public void learn(NeuralNetwork neuralNetwork, ArrayRealVector input, ArrayRealVector desiredOutput) throws MismatchingVectorSizeException {
        verifyLearnParameters(neuralNetwork, input.getDimension(), desiredOutput.getDimension());

        // Feedforward
        neuralNetwork.updateAllActivationLayers(input);

        // Output errors

        List<RealVector> errors = new ArrayList<RealVector>();
        errors.add(neuralNetwork.calculateOutputError(desiredOutput));

        for (int i = 1; i < neuralNetwork.getLayers().size(); i++) {
            errors.add(i, neuralNetwork.calculateError(errors.get(i - 1), ))
        }

        // Gradient descent

    }

    private void verifyLearnParameters(NeuralNetwork neuralNetwork, int inputSize, int outputSize) throws MismatchingVectorSizeException {
        if (outputSize != neuralNetwork.getOutputSize() || inputSize != neuralNetwork.getInputSize()) {
            throw new MismatchingVectorSizeException();
        }
    }

}
