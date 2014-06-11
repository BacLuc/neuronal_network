package de.mikadobrain.neuronetwork.application;

public class InputLayer extends AbstractInterfaceLayer<InputNeuron> {

	@Override
	public void fireUnits() {
		feedData();
		super.fireUnits();
	}
	
	protected void feedData() {
		for(InputNeuron unit : this) {
			unit.receiveInput(dataMap.getDataFor(unit));
		}
	}
}
