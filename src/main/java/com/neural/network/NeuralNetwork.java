package com.neural.network;

import com.neural.network.activationFunction.IActivationFunction;
import com.sun.istack.internal.NotNull;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private List<Layer> layers;

    private int inputSize;
    private int outputSize;

    public RealVector calculateError(RealVector nextLayersError, int layersIndex) {
//        nextLayersError.tra
        return null;
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

    public NeuralNetwork(@NotNull List<Integer> neuronsPerLayers,
                         @NotNull List<IActivationFunction> activationFunctions,
                         @NotNull List<Boolean> ifLayerUsesBias,
                         int inputSize) {

        System.out.println(neuronsPerLayers);
        System.out.println(activationFunctions);
        System.out.println(ifLayerUsesBias);
        layers = new ArrayList<Layer>();
        // TODO TUTAJ JEST BŁĄD, MA BYĆ ODWROTNA KOLEJNOSC DODAWANIA
        layers.add(
                new Layer(
                        activationFunctions.get(0),
                        neuronsPerLayers.get(0),
                        ifLayerUsesBias.get(0),
                        inputSize));

        if (neuronsPerLayers.size() >= 1) {
            for (int i = 1; i < neuronsPerLayers.size(); i++) {
                layers.add(new Layer(
                        activationFunctions.get(i),
                        neuronsPerLayers.get(i),
                        ifLayerUsesBias.get(i),
                        neuronsPerLayers.get(i - 1)));
            }
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

    public void showActivationValues() {
        for (int i = 0; i < layers.size(); i++) {
            System.out.print("Layer nr " + i + "\n");
            System.out.println(layers.get(i).getActivationVector());
        }
    }

    public void showWeightValues() {
        for (int l = 0; l < layers.size(); l++) {
            System.out.println("Layer: " + l + " weights:");
            for (int j = 0; j < layers.get(l).getActivationVector().getDimension(); j++) {
                System.out.println(layers.get(l).getNeuron(j).getWeights());
            }
        }
    }

}
