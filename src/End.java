// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.util.Hashtable;
/*
    This class implements the steps for End command
 */
public class End extends  SyntaxTreeCommand{
    @Override
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor) {
        syntaxTreeVisitor.visit(this);

    }

    public String toString() {
        return "end";
    }

    @Override
    public void perform(TurtleAlgorithm turtleAlgorithm) {

    }

    @Override
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters) {
       return new End();
    }
}