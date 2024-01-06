package models;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class Expression {
	private String problem;
	private String solution;
	private String encodedProblem;
	private final String ENCODER_STANDARD = "UTF-8";
	private Evaluator evaluator;
	
	public Expression(String problem, Evaluator evaluator) throws UnsupportedEncodingException {
		this.problem = problem;
		this.evaluator = evaluator;
		encodeExpression();
	}
	
	private void setSolution(String solution) {
		this.solution = solution;
	}

	@Override
	public String toString() {
		return "{problem : " + problem + ", solution : " + solution + "}";
	}
	
	private void encodeExpression() throws UnsupportedEncodingException {
		this.encodedProblem = URLEncoder.encode(problem, ENCODER_STANDARD);
	}
	
	public void evaluate() throws InterruptedException, ExecutionException {
		setSolution(evaluator.evaluate(encodedProblem));
	}
	
}
