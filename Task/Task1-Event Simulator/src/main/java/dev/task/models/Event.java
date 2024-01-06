package dev.task.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.task.exceptions.InvalidEventException;
import dev.task.exceptions.InvalidOutcomeInputException;

public class Event {

	private String name;
	private List<Outcome> outcomes;
	
	public Event(String name) {
		this.name = name;
		this.outcomes = new ArrayList<>();
	}
	
	public void addPossibleOutcome(Object name, int probability) throws InvalidOutcomeInputException {
		if(name == null || probability < 0)
			throw new InvalidOutcomeInputException("Verify outcome name and probability values");
		this.outcomes.add(Outcome.createOutcomeFactory(name, probability));
	}
	
	public String getName() {
		return name;
	}
	
	public String simulateEventFacade() throws InvalidEventException {
		validateOutcomes();
		return produceOutcome();
	}
	
	private void validateOutcomes() throws InvalidEventException {
		int sum = 0;
		for(Outcome outcome : outcomes) {
			sum += outcome.getProbability();
			if(sum > 100)
				throw new InvalidEventException("Total probabilities of possible outcomes exceeds 100");
		}
	}
	
	private String produceOutcome() throws InvalidEventException {
		double randomNum = Math.random();
        double cumulativeProb = 0;

        for (Outcome outcome : outcomes) {
            cumulativeProb += ((double) outcome.getProbability() / 100);

            if (randomNum <= cumulativeProb) {
                return outcome.getOutcome().toString();
            }
        }
        
        throw new InvalidEventException("Total probabilities of possible outcomes exceeds 100");		
	}

	public void runEvent(int occurences) throws InvalidEventException {
		System.out.println(String.format("---------------------Executing %s event for %s trials----------------------" , name, occurences));
		System.out.println(String.format("All possible outcomes : %s " , outcomes));
		HashMap<String, Integer> outcomesCount = new HashMap<>();
		for(int i=0; i<occurences; i++) {
			String outcome = simulateEventFacade();
			outcomesCount.put(outcome, outcomesCount.getOrDefault(outcome, 0) + 1);
		}
		
		System.out.println(String.format("Overall outcome count after %s occurences : %s " , occurences, outcomesCount));
		System.out.println("------------------------------------------------------------------------------------");		
	}
	
	
	
	
}
