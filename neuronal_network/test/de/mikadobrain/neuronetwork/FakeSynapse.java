package de.mikadobrain.neuronetwork;

public class FakeSynapse extends Synapse{

	public double transmittedValue;

	public FakeSynapse(Neuron preSynapticNeuron, Neuron postSynapticNeuron) {
		super(preSynapticNeuron, postSynapticNeuron);
	}
	
	@Override
	public void transmit(double value) {
		transmittedValue = value;
	}
}
