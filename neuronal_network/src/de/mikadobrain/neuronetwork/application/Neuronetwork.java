package de.mikadobrain.neuronetwork.application;

import javax.swing.SwingUtilities;

import de.mikadobrain.neuronetwork.presentation.NetworkFrame;



public class Neuronetwork {

	public static void main(String[] args) {

		Network network = new Network();
		
		InputLayer inputLayer = new InputLayer();
		Layer<Neuron> hiddenLayer = new Layer<Neuron>();
		OutputLayer outputLayer = new OutputLayer();
		
		InputNeuron in_1 = new InputNeuron();
		InputNeuron in_2 = new InputNeuron();
		Neuron hidden_1 = new Neuron();
		OutputNeuron out_1 = new OutputNeuron();

		Synapse con_1 = new Synapse(in_1, hidden_1);
		con_1.setWeight(1d);
		Synapse con_2 = new Synapse(in_2, hidden_1);
		con_2.setWeight(1d);
		Synapse con_3 = new Synapse(hidden_1, out_1);
		con_3.setWeight(1d);
		Synapse con_4 = new Synapse(hidden_1, out_1);
		con_4.setWeight(1d);
		
		inputLayer.add(in_1);
		inputLayer.add(in_2);
		hiddenLayer.add(hidden_1);
		outputLayer.add(out_1);
		
		network.setInputLayer(inputLayer);
		network.addHiddenLayer(hiddenLayer);
		network.setOutputLayer(outputLayer);

		SwingUtilities.invokeLater(
				()-> {new NetworkFrame(network);}
				);
		
		NeuronalInterfaceData<InputNeuron> inputMap = new NeuronalInterfaceData<InputNeuron>(inputLayer);
		inputMap.put(in_1, 0.4d);
		inputMap.put(in_2, 0d);
		

		NeuronalTrainigDataSet trainingData = new NeuronalTrainigDataSet();
		
		NeuronalInterfaceData<InputNeuron> trainingInputMap = new NeuronalInterfaceData<InputNeuron>(inputLayer);
		trainingInputMap.put(in_1, 0.2d);
		trainingInputMap.put(in_2, -0.1d);
		
		NeuronalInterfaceData<OutputNeuron> trainingOutputMap = new NeuronalInterfaceData<OutputNeuron>(outputLayer);
		trainingOutputMap.put(out_1, 0.0d);
		
		trainingData.put(trainingInputMap, trainingOutputMap);
		
		
		NetworkTrainer trainer = new NetworkTrainer();
		trainer.setTrainingData(trainingData);
		
		trainer.train(network, new LearningRuleHebb());
		
		NeuronalInterfaceData<OutputNeuron> outputMap = network.process(inputMap);
		
		for (Double value : outputMap.values()) {
			System.out.println(value);
		}
		
	}

}
