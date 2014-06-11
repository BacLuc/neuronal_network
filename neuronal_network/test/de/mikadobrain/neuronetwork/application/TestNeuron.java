package de.mikadobrain.neuronetwork.application;

import org.junit.Assert;
import org.junit.Test;

import de.mikadobrain.neuronetwork.application.Neuron;

public class TestNeuron {

	@Test
	public void testFire_noOutgoingConnection_connectionHasFired() {
		Neuron neuron = new Neuron();
		neuron.addConnectionIn(new FakeSynapse(new Neuron(), neuron));
		neuron.receiveInput(1d);
		neuron.fire();
		Assert.assertTrue("hasFired flag is false", neuron.hasFired);
	}
	
	@Test
	public void testFire_OutgoingConnectionProvided_ConnectionReceivesCorrectValue() {
		Neuron neuron = new Neuron();
		FakeSynapse connection = new FakeSynapse(neuron, new Neuron());
		
		neuron.addConnectionIn(new FakeSynapse(new Neuron(), neuron));
		neuron.addConnectionIn(new FakeSynapse(new Neuron(), neuron));
		neuron.addConnectionOut(connection);
		neuron.receiveInput(-0.4d);
		neuron.receiveInput(0.4d);
		neuron.fire();
		
		Assert.assertEquals(0d, connection.transmittedValue, 0d);
		
	}
	
}