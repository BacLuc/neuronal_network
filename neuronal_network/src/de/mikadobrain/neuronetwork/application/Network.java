package de.mikadobrain.neuronetwork.application;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Network {

	protected InputLayer inputLayer;
	protected LinkedHashSet<Layer<Neuron>> hiddenLayers = new LinkedHashSet<Layer<Neuron>>();
	protected OutputLayer outputLayer;

	protected int mode = OPERATION_MODE_TESTING;
	public static final int OPERATION_MODE_LEARNING = 0;
	public static final int OPERATION_MODE_TESTING = 1;
	
	/**
	 * Lets the network perform one cycle, using the provided InputMap.
	 * @param inputMap
	 */
	public NeuronalInterfaceData<OutputNeuron> process(NeuronalInterfaceData<InputNeuron> inputMap) {
		inputLayer.setInterfaceMap(inputMap);
		runThroughAllLayers();
		return outputLayer.getInterfaceMap();
	}
	
	private void runThroughAllLayers() {
		inputLayer.fireUnits();
		
		for (Layer<Neuron> layer : hiddenLayers) {
			layer.fireUnits();
		}
		
		outputLayer.fireUnits();
	}
	
	public InputLayer getInputLayer() {
		return inputLayer;
	}
	
	public void setInputLayer(InputLayer inputLayer) {
		this.inputLayer = inputLayer;
	}
	
	private Set<Synapse> getConnectionsFromLayer(Layer<? extends Neuron> layer) {
		Set<Synapse> connections = new HashSet<Synapse>();
		
		for (Neuron unit : layer){
			connections.addAll(unit.connectionsIn);
			connections.addAll(unit.connectionsOut);
		}
		
		return connections;
	}
	
	public LinkedHashSet<Layer<Neuron>> getHiddenLayers() {
		return hiddenLayers;
	}
	
	public void setHiddenLayers(LinkedHashSet<Layer<Neuron>> hiddenLayers) {
		this.hiddenLayers = hiddenLayers;
	}

	public void addHiddenLayer(Layer<Neuron> layer) {
		this.hiddenLayers.add(layer);
	}
	
	public OutputLayer getOutputLayer() {
		return outputLayer;
	}
	
	public void setOutputLayer(OutputLayer outputLayer) {
		this.outputLayer = outputLayer;
	}
	
	public void setMode(int mode) {
		switch (mode) {
		case OPERATION_MODE_LEARNING:
			this.mode = mode;
			break;
		case OPERATION_MODE_TESTING:
			this.mode = mode;
			break;
		default:
			throw new InvalidParameterException("Supplied Parameter is no known operation mode for Network.");
		}
	}
	
	public Set<Synapse> getAllConnections() {
		Set<Synapse> connections = new HashSet<Synapse>();
		
		connections.addAll(getConnectionsFromLayer(inputLayer));
		for (Layer<Neuron> hiddenLayer : hiddenLayers) {
			connections.addAll(getConnectionsFromLayer(hiddenLayer));
		}
		connections.addAll(getConnectionsFromLayer(outputLayer));
		
		return connections;
	}
	

}
