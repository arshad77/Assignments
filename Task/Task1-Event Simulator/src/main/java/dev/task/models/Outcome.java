package dev.task.models;

public class Outcome {
	private Object name;
    private int probability;

    private Outcome(Object name, int probability) {
        this.name = name;
        this.probability = probability;
    }

    public Object getOutcome() {
        return name;
    }

    public int getProbability() {
        return probability;
    }
    
    public static Outcome createOutcomeFactory(Object name, int probability) {
    	return new Outcome(name, probability);
    }

	@Override
	public String toString() {
		return  name + " : " + probability;
	}
    
    
}
