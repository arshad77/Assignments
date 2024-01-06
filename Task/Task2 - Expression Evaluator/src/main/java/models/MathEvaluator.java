package models;

import controllers.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MathEvaluator implements Evaluator{
	
	private static final int REQUEST_MAX_SIZE = 50;
	private ExecutorService executorService;
	
	public MathEvaluator() {
		executorService = Executors.newFixedThreadPool(REQUEST_MAX_SIZE);
	}
	
	public String evaluate(String problem) throws InterruptedException, ExecutionException {
		Future<String> future = executorService.submit(() -> {
			return new RestController().get(problem);
		} );
		
		return future.get();
	}

	@Override
	public void shutdown() {
		executorService.shutdown();		
	}

}
