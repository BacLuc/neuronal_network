package de.mikadobrain.neuronetwork.presentation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;

import javax.swing.JPanel;

import de.mikadobrain.neuronetwork.application.Network;
import net.miginfocom.swing.MigLayout;

public class NetworkPanel extends JPanel {
	
	Network network;
	VisualizedNetwork visualizedNetwork = new VisualizedNetwork();
	NetworkVisualizer visualizer = new NetworkVisualizer();
	Image buffer;

	/**
	 * Create the panel.
	 */
	public NetworkPanel(Network network) {
		setNetwork(network);
	}
	
	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
		updateVisualization();
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
	
	private void updateScreen(Graphics g) {
		updateVisualization();
		for (Shape shape : visualizedNetwork.values()) {
			((Graphics2D) g).draw(shape);
		}
	}

	private void updateVisualization() {
		visualizedNetwork = visualizer.visualize(network);
	}
}
