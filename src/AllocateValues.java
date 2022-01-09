// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.util.Hashtable;
/*
  Class allocates the values to given variables
 */
public class AllocateValues extends SyntaxTreeCommand {

    private int parameterValue;
    private String parameterName;

    // Default and Parameterized Constructors
    public AllocateValues() {
    }

    public AllocateValues(int parameterValue, String parameterName) {
        this.parameterValue = parameterValue;
        this.parameterName = parameterName;
    }
    // Getters and Setters

    public int getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(int parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public String toString() {
        return "allocate";
    }

    @Override
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor) {
        syntaxTreeVisitor.visit(this);
    }

    // creating new values of parameters and analyzing the expression received
    @Override
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters) {
        String[] expressionString = expression.split(" ");
        parameterValue = Integer.parseInt(expressionString[2]);
        parameterName = expressionString[0];
        return new AllocateValues(parameterValue, parameterName);
    }

    @Override
    public void perform(TurtleAlgorithm turtleAlgorithm) {

    }
}
