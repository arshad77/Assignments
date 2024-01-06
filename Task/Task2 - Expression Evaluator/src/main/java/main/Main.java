package main;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

import models.Evaluator;
import models.Expression;
import models.MathEvaluator;

public class Main {
	private static final int NUM_EXPRESSIONS = 500;

	public static void main(String[] args)
			throws UnsupportedEncodingException, InterruptedException, ExecutionException {
		Evaluator evaluator = new MathEvaluator();
		for (int i = 1; i <= NUM_EXPRESSIONS; i++) {
			String problem = "2 + " + i;
			Expression expression = new Expression(problem, evaluator);
			expression.evaluate();
			System.out.println(expression);
		}
		evaluator.shutdown();
	}

	
}
