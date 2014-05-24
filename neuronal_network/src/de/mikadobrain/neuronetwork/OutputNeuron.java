package de.mikadobrain.neuronetwork;

public class OutputNeuron extends Neuron {
	
	public double getOutput() {
		calculateActivityLevel();
		return activityLevel;
	}
	
}
