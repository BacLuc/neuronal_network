package de.mikadobrain.neuronetwork.application;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Neuron {

	protected int identifier;
	protected double input = 0d;
	protected double activityLevel = 0d;
	protected Set<Synapse> connectionsIn = new HashSet<Synapse>();
	protected Set<Synapse> connectionsOut = new HashSet<Synapse>();
	protected int inputCounter = 0;
	protected boolean hasFired = false;
	
	public Neuron() {
	}

	public Neuron(int identifier) {
		setIdentifier(identifier);
	}
	
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public void receiveInput(double input) {
		this.input += input;
		++inputCounter;
	}
	
	public void fire() {
		calculateActivityLevel();

		if ( receptionComplete() ) {
			feedAllConnections();
			hasFired = true;
		}
	}
	
	protected void calculateActivityLevel() {
		activityLevel = this.input;
	}
	
	public boolean receptionComplete() {
		 return inputCounter == connectionsIn.size();
	}

	private void feedAllConnections() {
		for (Synapse connection : connectionsOut) {
			connection.transmit(activityLevel);
		}
	}
	
	public void resetInput() {
		input = 0d;
		inputCounter = 0;
	}
	
	public void addConnectionIn(Synapse synapse) {
		this.connectionsIn.add(synapse);
	}

	public void addConnectionOut(Synapse synapse) {
		this.connectionsOut.add(synapse);
	}
	
	double getActivityLevel() {
		return activityLevel;
	}
	
}
