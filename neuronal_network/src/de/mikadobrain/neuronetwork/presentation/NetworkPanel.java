package de.mikadobrain.neuronetwork.presentation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import de.mikadobrain.neuronetwork.application.Layer;
import de.mikadobrain.neuronetwork.application.Network;
import de.mikadobrain.neuronetwork.application.Neuron;

public class NetworkPanel extends JPanel {
	
	Network network;
	VisualizedNetwork visualizedNetwork;
	NetworkVisualizer visualizer = new NetworkVisualizer();
	Image buffer;
	
	public NetworkPanel(Network network) {
		setNetwork(network);
		setVisible(true);
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
		super.paintComponent(g);
		updateScreen(g);
	}
	
	public void updateScreen(Graphics g) {
		for (Shape shape : visualizedNetwork.values()) {
			((Graphics2D) g).draw(shape);
		}
	}
}
