package de.mikadobrain.neuronetwork.presentation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import de.mikadobrain.neuronetwork.Layer;
import de.mikadobrain.neuronetwork.Network;
import de.mikadobrain.neuronetwork.Neuron;

public class NetworkPanel extends JPanel {
	
	Network network;
	VisualizedNetwork visualizedNetwork;
	NetworkVisualizer visualizer = new NetworkVisualizer();
	Image buffer;
	
	public NetworkPanel(Network network) {
		setNetwork(network);
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
		this.visualizedNetwork = visualizer.visualize(network);
	}

	public NetworkVisualizer getVisualizer() {
		return visualizer;
	}

	public void setVisualizer(NetworkVisualizer visualizer) {
		this.visualizer = visualizer;
	}	
	
	@Override
	public void paintComponent( Graphics g ){
		updateScreen();
	}
	
	public void updateScreen() {
		Graphics g = this.getGraphics();
		g.drawImage(buffer, 0, 0, null);
	}
	
	public void renderScreen() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		for (Shape shape : visualizedNetwork.values()) {
			g.draw(shape);
		}
	}
}
