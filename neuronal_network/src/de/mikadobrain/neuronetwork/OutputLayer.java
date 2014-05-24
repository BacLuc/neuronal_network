package de.mikadobrain.neuronetwork;

public class OutputLayer extends AbstractInterfaceLayer<OutputNeuron> {
	
	@Override
	public void fireUnits() {
		dataMap = new NeuronalInterfaceData<OutputNeuron>(this);
		for(OutputNeuron unit : this) {
			dataMap.put(unit, unit.getOutput());
		}
	}
}
