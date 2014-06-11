package de.mikadobrain.neuronetwork.application;

public abstract class AbstractLearningRule {

	double epsilon = 1;
	
	public AbstractLearningRule() {
	}

	public AbstractLearningRule(double epsilon) {
		setEpsilon(epsilon);
	}
	
	public void applyTo(Synapse connection) {
		connection.setWeight(calculateNewWeight(connection));
	}
	
	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
	
	protected abstract double calculateNewWeight(Synapse connection);
}
