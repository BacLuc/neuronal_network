package de.mikadobrain.neuronetwork;

import java.util.HashMap;

public class NeuronalInterfaceData<K extends Neuron> extends HashMap<K, Double> {

	public NeuronalInterfaceData(Layer<K> interfaceLayer) {
		for (K unit : interfaceLayer) {
			this.put(unit, 0d);
		}
	}
	public Double getDataFor(Object key) {
		return get(key);
	}
	
}
