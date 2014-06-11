package de.mikadobrain.neuronetwork.application;

public class AbstractInterfaceLayer<T extends Neuron> extends Layer<T> {

	protected NeuronalInterfaceData<T> dataMap;

	public AbstractInterfaceLayer() {
		super();
	}

	public void setInterfaceMap(NeuronalInterfaceData<T> dataMap) {
		this.dataMap = dataMap;
	}
	
	public NeuronalInterfaceData<T> getInterfaceMap() {
		return dataMap;
	}

}