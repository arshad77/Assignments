package dev.task;

import dev.task.exceptions.InvalidEventException;
import dev.task.exceptions.InvalidOutcomeInputException;
import dev.task.models.Event;

public class Main {
	public static void main(String[] args) throws InvalidOutcomeInputException, InvalidEventException {
		int occurences = 1000;
		
		Event event = new Event("Dice Roll");
		
		event.addPossibleOutcome(1, 10);
		event.addPossibleOutcome(2, 30);
		event.addPossibleOutcome(3, 15);
		event.addPossibleOutcome(4, 15);
		event.addPossibleOutcome(5, 30);
		event.addPossibleOutcome(6, 0);
		
		event.runEvent(occurences);
		
		Event event2 = new Event("Coin Toss");
		
		event2.addPossibleOutcome("Head", 35);
		event2.addPossibleOutcome("Tails", 65);
		
		event2.runEvent(occurences);
		
	}
}
