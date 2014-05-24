package de.mikadobrain.neuronetwork.presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import de.mikadobrain.neuronetwork.Network;

public class NetworkFrame extends JFrame {

	public NetworkFrame(Network network) {
		super("Network");
		
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		NetworkPanel networkPanel = new NetworkPanel(network);
		add(networkPanel);
		setVisible(true);
		networkPanel.renderScreen();
		networkPanel.updateScreen();
	}
}
