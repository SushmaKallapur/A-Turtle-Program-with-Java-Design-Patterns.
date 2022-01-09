// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.util.Hashtable;
/*
     This class implements the steps for Turn command
 */
public class Turn extends SyntaxTreeCommand{

    private int degrees;

//  Constructors
    public Turn(int degrees) {
        this.degrees = degrees;
    }

    public Turn() {
    }

    public String toString() {
        return "turn";
    }

    @Override
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor) {
        syntaxTreeVisitor.visit(this);
    }

//  analyze the expression by checking its parameter name or
//  parameter value and initialize the specific class
    @Override
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters) {
        String degreeValue = expression.split(" ")[1];
        if (expression.contains("#")) {
            degrees = parameters.get(degreeValue);
        } else {
            degrees = Integer.parseInt(degreeValue);
        }
        return new Turn(degrees);
    }

    @Override
    public void perform(TurtleAlgorithm turtleAlgorithm) {
        turtleAlgorithm.turn(this.degrees);
    }
}
