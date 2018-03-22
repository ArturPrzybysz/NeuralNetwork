package com.neural.network;

import exceptions.MismatchingVectorSizeException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class Backpropagation {
    public void learn(NeuralNetwork neuralNetwork, ArrayRealVector input, ArrayRealVector desiredOutput) throws MismatchingVectorSizeException {
        verifyLearnParameters(neuralNetwork, input.getDimension(), desiredOutput.getDimension());

        neuralNetwork.updateAllActivationLayers(input);


    }

    private void verifyLearnParameters(NeuralNetwork neuralNetwork, int inputSize, int outputSize) throws MismatchingVectorSizeException {
        if (outputSize != neuralNetwork.getOutputSize() || inputSize != neuralNetwork.getInputSize()) {
            throw new MismatchingVectorSizeException();
        }
    }

}
