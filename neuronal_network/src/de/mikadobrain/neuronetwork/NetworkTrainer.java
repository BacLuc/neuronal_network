package de.mikadobrain.neuronetwork;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NetworkTrainer implements Runnable{
	
	private Network network;
	private Set<Synapse> connections = new HashSet<Synapse>();
	private NeuronalTrainigDataSet trainingData;
	
	Map.Entry<NeuronalInterfaceData<InputNeuron>, NeuronalInterfaceData<OutputNeuron>> currentDataset;
	
	private AbstractLearningRule learningRule;
	
	public void setTrainingData(NeuronalTrainigDataSet trainingData) {
		this.trainingData = trainingData;
	}

	public NeuronalTrainigDataSet getTrainingData() {
		return trainingData;
	}
	
	public void train(Network network, AbstractLearningRule learningRule) {
		this.network = network;
		this.learningRule = learningRule;
		this.connections = network.getAllConnections();
		
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		
		for (Map.Entry<NeuronalInterfaceData<InputNeuron>, NeuronalInterfaceData<OutputNeuron>> currentDataset : trainingData.entrySet()) { 
			this.currentDataset = currentDataset;
			trainCurrentDataset();
		}
	}
	
	private void trainCurrentDataset() {
		NeuronalInterfaceData<InputNeuron> inputData = currentDataset.getKey();
		NeuronalInterfaceData<OutputNeuron> targetOutputData= currentDataset.getValue();
		NeuronalInterfaceData<OutputNeuron> outputData = network.process(inputData);
		
		Set<OutputNeuron> errorUnits = new HashSet<OutputNeuron>();
		for (Map.Entry<OutputNeuron, Double> unitOutput : outputData.entrySet() ) {
			OutputNeuron outputNeuron = unitOutput.getKey();
			Double targetValue = targetOutputData.get(outputNeuron);
			Double outputValue = unitOutput.getValue();
			
			if (! outputValue.equals(targetValue)) {
				errorUnits.add(outputNeuron);
			}
		}
		
		for (Synapse connection : connections) {
			connection.adapt(learningRule);
		}
	}

}
