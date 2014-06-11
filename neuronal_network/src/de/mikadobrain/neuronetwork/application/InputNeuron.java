package de.mikadobrain.neuronetwork.application;

public class InputNeuron extends Neuron {
	
	@Override
	public boolean receptionComplete(){
		return inputCounter == 1;
	}
	
}
