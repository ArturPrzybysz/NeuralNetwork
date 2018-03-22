package com.neural.network;

import org.apache.commons.math3.linear.RealVector;

import java.util.List;

public class NeuralNetwork {
    private List<Layer> layers;

    private int inputSize;
    private int outputSize;

    public RealVector calculateError(RealVector nextLayersError, int layersIndex) {
        nextLayersError.tra
    }

    public RealVector calculateOutputError(RealVector expectedOutput) {
        RealVector vector1 = layers.get(layers.size() - 1).getActivationVector().subtract(expectedOutput);
        RealVector vector2 = layers.get(layers.size() - 1).getDerivativesOfZ();

        return vector1.ebeMultiply(vector2);
    }

    public void updateAllActivationLayers(RealVector input) {
        layers.get(0).updateActivationValues(input);

        for (int i = 1; i < layers.size(); i++) {
            layers.get(i).updateActivationValues(layers.get(i - 1).getActivationVector());
        }
    }

    public NeuralNetwork(List<Integer> neuronsPerLayers, List<IActivationFunction> activationFunctions, List<Boolean> ifLayerUsesBias, int inputSize) {
        layers.add(new Layer(activationFunctions.get(0), neuronsPerLayers.get(0), ifLayerUsesBias.get(0), inputSize));

        for (int i = 1; i < neuronsPerLayers.size(); i++) {
            layers.add(new Layer(activationFunctions.get(i), neuronsPerLayers.get(i), ifLayerUsesBias.get(i), neuronsPerLayers.get(i - 1)));
        }

        this.inputSize = inputSize;
        this.outputSize = layers.get(layers.size() - 1).getActivationVector().getDimension();
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public RealVector getOutput(RealVector input) {
        updateAllActivationLayers(input);
        return layers.get(layers.size() - 1).getActivationVector();
    }

    public int getInputSize() {
        return inputSize;
    }

    public int getOutputSize() {
        return outputSize;
    }

}
