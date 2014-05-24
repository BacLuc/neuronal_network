package de.mikadobrain.neuronetwork;

public class InputNeuron extends Neuron {
	
	@Override
	public boolean receptionComplete(){
		return inputCounter == 1;
	}
	
}
