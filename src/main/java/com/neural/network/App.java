package com.neural.network;

import com.neural.network.activationFunction.IActivationFunction;
import com.neural.network.activationFunction.SigmoidFunction;
import org.apache.commons.math3.linear.ArrayRealVector;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer neuronsPerLayer[] = {1, 3, 2};
        IActivationFunction activationFunctions[] = {new SigmoidFunction(), new SigmoidFunction(), new SigmoidFunction()};
        Boolean ifLayerUsesBias[] = {false, false, false};

        NeuralNetwork neuralNetwork = new NeuralNetwork(
                new ArrayList<Integer>(Arrays.asList(neuronsPerLayer)),
                new ArrayList<IActivationFunction>(Arrays.asList(activationFunctions)),
                new ArrayList<Boolean>(Arrays.asList(ifLayerUsesBias)),
                2
        );

        double input[] = {1, 2.2};
        neuralNetwork.updateAllActivationLayers(new ArrayRealVector(input));
        System.out.println(neuralNetwork.calculateErrors(new ArrayRealVector(input)));

    }
}
