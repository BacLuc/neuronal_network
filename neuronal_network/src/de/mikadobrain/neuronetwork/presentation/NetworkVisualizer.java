package de.mikadobrain.neuronetwork.presentation;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import de.mikadobrain.neuronetwork.Layer;
import de.mikadobrain.neuronetwork.Network;
import de.mikadobrain.neuronetwork.Neuron;
import de.mikadobrain.neuronetwork.Synapse;

public class NetworkVisualizer {

	Network network;
	VisualizedNetwork visualizedNetwork;
	
	public VisualizedNetwork visualize(Network network) {
		this.network = network;
		visualizedNetwork = new VisualizedNetwork();

		visualizeUnits();
		visualizeConnections();
		
		return visualizedNetwork;
	}
	
	private void visualizeUnits() {
		int layerNumber= 0;

		visualizeLayer(network.getInputLayer(), layerNumber);
		
		for (Layer<Neuron> layer : network.getHiddenLayers()) {
			++layerNumber;
			visualizeLayer(layer, layerNumber);
		}
		
		++layerNumber;
		visualizeLayer(network.getOutputLayer(), layerNumber);
	}
	
	private void visualizeLayer(Layer<? extends Neuron> layer, int layerNumber) {
		int neuronCounter = 0;
		for (Neuron unit : layer) {
			Ellipse2D.Double neuronVisualization = new Ellipse2D.Double(neuronCounter * 30, layerNumber * 30, 30, 30);
			visualizedNetwork.put(unit, neuronVisualization);
			++neuronCounter;
		}
	}
	
	private void visualizeConnections() {
		Shape shapeBuffer; 
		for (Synapse connection : network.getAllConnections()) {
			shapeBuffer = visualizedNetwork.get(connection.getPreSynapticNeuron());
			Ellipse2D.Double visualizedPreSynaptic = (Ellipse2D.Double) shapeBuffer;
			shapeBuffer = visualizedNetwork.get(connection.getPostSynapticNeuron());
			Ellipse2D.Double visualizedPostSynaptic = (Ellipse2D.Double) shapeBuffer;
			
			Line2D.Double visualizedConnection = new Line2D.Double(visualizedPreSynaptic.getCenterX(), 
					visualizedPreSynaptic.getCenterY(), 
					visualizedPostSynaptic.getCenterX(), 
					visualizedPostSynaptic.getCenterY());
			
			visualizedNetwork.put(connection, visualizedConnection);
		}
	}
	
}
