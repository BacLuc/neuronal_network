package de.mikadobrain.neuronetwork.presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import de.mikadobrain.neuronetwork.application.Network;

public class NetworkFrame extends JFrame {

	public NetworkFrame(Network network) {
		super("Network");
		
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		
		NetworkPanel networkPanel = new NetworkPanel(network);
		add(networkPanel);
	}
}
