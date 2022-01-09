// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.util.Hashtable;
/*
    It helps to analyse the syntax tree
 */
public class SyntaxTreeSetup {

    private String expression;
    private SyntaxTreeCommand syntaxTreeCommand;

//  Getter and Setter
    public SyntaxTreeSetup(String expression) {
        this.expression = expression;
    }

    public SyntaxTreeSetup(SyntaxTreeCommand syntaxTreeCommand) {
        this.syntaxTreeCommand = syntaxTreeCommand;
    }

//  Considering the start value of every expression for specific class initialization
    public SyntaxTreeCommand commandSetup(Hashtable<String, Integer> parameters) {
        String startValue = expression.split(" ")[0];

        if(startValue.contains("move")) {
            syntaxTreeCommand = new Move().analyze(expression, parameters);
        } else if(startValue.contains("end")) {
            syntaxTreeCommand = new End();
        } else if(startValue.contains("turn")) {
            syntaxTreeCommand = new Turn().analyze(expression, parameters);
        } else  if(startValue.contains("#")) {
            syntaxTreeCommand = new AllocateValues().analyze(expression,parameters);
            String nameKey = expression.split(" ")[0];
            String value = expression.split(" ")[2];
            parameters.put(nameKey, Integer.parseInt(value));
        } else if(startValue.contains("repeat")) {
            syntaxTreeCommand = new Repeat().analyze(expression,parameters);
        }
        return syntaxTreeCommand;
    }
}
