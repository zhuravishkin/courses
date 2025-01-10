package com.zhuravishkin.courses.design.design_patterns.behavioral.interpreter;

import java.util.Stack;

// Client
public class InterpreterDemo {
    public static void main(String[] args) {
//        String expression = "5 3 + 2 -"; // Постфиксная нотация (5 + 3 - 2) = 6 (обратная польская нотация, Reverse Polish Notation, RPN)
        String expression = "6 2 * 3 + 12 /"; // Постфиксная запись: (6 * 2 + 3) / 12 = 1
        Expression parsedExpression = InterpreterContext.parse(expression);
        int result = parsedExpression.interpret();
        System.out.println("Result: " + result);
    }
}

// AbstractExpression: Общий интерфейс для выражений
interface Expression {
    int interpret();
}

// TerminalExpression: Числовое значение
class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

// NonTerminalExpression: Сложение
class AddExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

// NonTerminalExpression: Вычитание
class SubtractExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}

// NonTerminalExpression: Умножение
class MultiplyExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }
}

// NonTerminalExpression: Деление
class DivideExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public DivideExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        int rightValue = rightExpression.interpret();
        if (rightValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftExpression.interpret() / rightValue;
    }
}

// Context: Парсинг выражений
class InterpreterContext {
    public static Expression parse(String expression) {
        Stack<Expression> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                // Оператор: создаём соответствующий NonTerminalExpression
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(getOperatorExpression(token, left, right));
            } else {
                // Операнд: создаём TerminalExpression
                stack.push(new NumberExpression(Integer.parseInt(token)));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static Expression getOperatorExpression(String operator, Expression left, Expression right) {
        return switch (operator) {
            case "+" -> new AddExpression(left, right);
            case "-" -> new SubtractExpression(left, right);
            case "*" -> new MultiplyExpression(left, right);
            case "/" -> new DivideExpression(left, right);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
