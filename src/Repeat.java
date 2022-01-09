// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.util.Hashtable;
/*
      This class implements the steps for Repeat command
 */
public class Repeat extends SyntaxTreeCommand{

    private int repeatCounter;

//  Constructor
    public Repeat(int repeatCounter) {
        this.repeatCounter = repeatCounter;
    }

    public Repeat() {
    }

//  Getter and Setter
    public int getRepeatCounter() {
        return repeatCounter;
    }

    public void setRepeatCounter(int repeatCounter) {
        this.repeatCounter = repeatCounter;
    }

    public String toString() {
        return "repeat";
    }
    @Override
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor) {

    }

//  analyze the expression by checking its parameter name or
//  parameter value and initialize the specific class
    @Override
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters) {
        String counterValue = expression.split(" ")[1];
        if(expression.contains("#")) {
            repeatCounter = parameters.get(counterValue);
        } else {
            repeatCounter = Integer.parseInt(counterValue);
        }
        return new Repeat(repeatCounter);
    }

    @Override
    public void perform(TurtleAlgorithm turtleAlgorithm) {

    }
}
