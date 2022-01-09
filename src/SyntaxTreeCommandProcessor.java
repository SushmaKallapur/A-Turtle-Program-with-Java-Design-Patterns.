/*
    @authors - Nishigandha Kishor Mhaisne (027941743)
               Sushma Sunil Kallapur (027977597)

   It will perform actions on all the nodes of syntax tree
 */

public class SyntaxTreeCommandProcessor implements SyntaxTreeVisitor {

    private TurtleAlgorithm turtleAlgorithm;

    //constructor
    public SyntaxTreeCommandProcessor(TurtleAlgorithm turtleAlgorithm) {
        this.turtleAlgorithm = turtleAlgorithm;
    }
    // Getter and Setter
    public TurtleAlgorithm getTurtleAlgorithm() {
        return turtleAlgorithm;
    }

    public void setTurtleAlgorithm(TurtleAlgorithm turtleAlgorithm) {
        this.turtleAlgorithm = turtleAlgorithm;
    }


    @Override
    public void visit(TurtleAlgorithm turtleAlgorithm) {
        turtleAlgorithm.perform(this.turtleAlgorithm);

    }

    // It runs the perform method of allocateValues class
    @Override
    public void visit(AllocateValues allocateValues) {
        allocateValues.perform(turtleAlgorithm);

    }

    // It runs the perform method of End class
    @Override
    public void visit(End end) {
        end.perform(turtleAlgorithm);

    }

    // It runs the perform method of Turn class
    @Override
    public void visit(Turn turn) {
        turn.perform(turtleAlgorithm);

    }

    // It runs the perform method of Move class
    @Override
    public void visit(Move move) {
        move.perform(turtleAlgorithm);

    }

    // It runs the perform method of Repeat class
    @Override
    public void visit(Repeat repeat) {
        repeat.perform(turtleAlgorithm);

    }


}
