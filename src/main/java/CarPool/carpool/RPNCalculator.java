package CarPool.carpool;

import java.util.Stack;

public class RPNCalculator {

	public Integer calculateRPN(String rpnExpression) {
		if(rpnExpression == null || "".equalsIgnoreCase(rpnExpression)) {
			throw new RuntimeException("Invalid Expression");
		}
		Stack<Integer> symbolStack = new Stack<Integer>();
		String[] rpnExpr = rpnExpression.split(",");
		for (String symbol : rpnExpr) {
			if ("+".equals(symbol) || "-".equals(symbol) || "*".equals(symbol) || "/".equals(symbol)) {
				processBinaryOperator(symbolStack, symbol);
			} else if ("%".equals(symbol) || "!".equals(symbol)) {
				processUnaryOperator(symbolStack, symbol);
			} else {
				symbolStack.push(Integer.parseInt(symbol));
			}
		}
		if (symbolStack.size() > 1) {
			throw new RuntimeException("Invalid expression");
		}
		return symbolStack.pop();
	}

	private void processBinaryOperator(Stack<Integer> symbolStack, String symbol) {

		Integer rightOperandValue = symbolStack.pop();
		Integer leftOperandValue = symbolStack.pop();

		if ("+".equals(symbol)) {
			symbolStack.push(leftOperandValue + rightOperandValue);
		}
		if ("-".equals(symbol)) {
			symbolStack.push(leftOperandValue - rightOperandValue);
		}
		if ("*".equals(symbol)) {
			symbolStack.push(leftOperandValue * rightOperandValue);
		}
		if ("/".equals(symbol)) {
			symbolStack.push(leftOperandValue / rightOperandValue);
		}

	}

	private void processUnaryOperator(Stack<Integer> symbolStack, String symbol) {
		// TODO Auto-generated method stub

	}

}
