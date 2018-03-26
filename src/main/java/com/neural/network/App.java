package com.neural.network;

import com.neural.network.activationFunction.IActivationFunction;
import com.neural.network.activationFunction.SigmoidFunction;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.math3.linear.ArrayRealVector;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Integer neuronsPerLayer[] = {2, 3, 1};
        IActivationFunction activationFunctions[] = {new SigmoidFunction(), new SigmoidFunction(), new SigmoidFunction()};
        Boolean ifLayerUsesBias[] = {false, false, false};


        NeuralNetwork neuralNetwork = new NeuralNetwork(
                new ArrayList<Integer>(Arrays.asList(neuronsPerLayer)),
                new ArrayList<IActivationFunction>(Arrays.asList(activationFunctions)),
                new ArrayList<Boolean>(Arrays.asList(ifLayerUsesBias)),
                1
        );
        neuralNetwork.showActivationValues();
        neuralNetwork.showWeightValues();

        double input[] = {1, 2};
        neuralNetwork.updateAllActivationLayers(new ArrayRealVector(input));

        neuralNetwork.showActivationValues();
    }
}
