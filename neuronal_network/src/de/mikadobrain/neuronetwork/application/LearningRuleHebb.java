package de.mikadobrain.neuronetwork.application;

public class LearningRuleHebb extends AbstractLearningRule {

	@Override
	protected double calculateNewWeight(Synapse connection) {
		return 
				epsilon * 
				connection.preSynapticNeuron.getActivityLevel() * 
				connection.postSynapticNeuron.getActivityLevel();
	}

}
