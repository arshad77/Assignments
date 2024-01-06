package models;

import java.util.concurrent.ExecutionException;

public interface Evaluator {
	public String evaluate(String problem) throws InterruptedException, ExecutionException;
	public void shutdown();
}
