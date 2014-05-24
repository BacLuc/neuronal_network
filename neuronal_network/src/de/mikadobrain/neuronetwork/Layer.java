package de.mikadobrain.neuronetwork;

import java.util.HashSet;

public class Layer<T extends Neuron> extends HashSet<T>{
	
	public void fireUnits() {
		for(T unit : this) {
			unit.fire();
		}
	}
}
