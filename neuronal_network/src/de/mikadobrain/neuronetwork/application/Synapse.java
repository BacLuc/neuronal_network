package de.mikadobrain.neuronetwork.application;

public class Synapse {

	protected Neuron preSynapticNeuron;
	protected Neuron postSynapticNeuron;
	protected double weight = 0d;
	
	public Synapse(Neuron preSynapticNeuron, Neuron postSynapticNeuron) {
		connect(preSynapticNeuron, postSynapticNeuron);
	}
	
	public void connect(Neuron preSynapticNeuron, Neuron postSynapticNeuron) {
		setPreSynapticNeuron(preSynapticNeuron);
		setPostSynapticNeuron(postSynapticNeuron);
		
	}
	
	public void setPreSynapticNeuron(Neuron preSynapticNeuron) {
		preSynapticNeuron.addConnectionOut(this);
		this.preSynapticNeuron = preSynapticNeuron;
	}

	public void setPostSynapticNeuron(Neuron postSynapticNeuron) {
		postSynapticNeuron.addConnectionIn(this);
		this.postSynapticNeuron = postSynapticNeuron;
	}
	
	public void transmit(double value) {
		postSynapticNeuron.receiveInput( value * weight );
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void changeWeight(double delta) {
		weight += delta;
	}
	
	public void adapt(AbstractLearningRule learningRule) {
		learningRule.applyTo(this);
	}

	public Neuron getPreSynapticNeuron() {
		return preSynapticNeuron;
	}

	public Neuron getPostSynapticNeuron() {
		return postSynapticNeuron;
	}
	
}
