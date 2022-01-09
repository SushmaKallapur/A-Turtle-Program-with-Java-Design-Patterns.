//  @authors - Nishigandha Kishor Mhaisne (027941743)
//             Sushma Sunil Kallapur (027977597)

import java.util.Hashtable;


/*
    this class analyze or perform operation on received expression
 */
public interface SyntaxTreeExpression {
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters);
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor);
    public String toString();
    public void perform(TurtleAlgorithm turtleAlgorithm);
}
