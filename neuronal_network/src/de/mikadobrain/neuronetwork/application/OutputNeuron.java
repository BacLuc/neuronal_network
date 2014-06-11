package de.mikadobrain.neuronetwork.application;

public class OutputNeuron extends Neuron {
	
	public double getOutput() {
		calculateActivityLevel();
		return activityLevel;
	}
	
}
