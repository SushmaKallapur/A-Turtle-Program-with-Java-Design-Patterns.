// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)


import java.util.Hashtable;
/*
    This class implements the steps for Move command
 */
public class Move extends  SyntaxTreeCommand {

    private int moveDistance;

//  Constructors
    public Move(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    public Move() {
    }

//  Getter and Setter
    public int getMoveDistance() {
        return moveDistance;
    }
    public void setMoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;
    }


    public String toString() {
        return "move";
    }

    @Override
    public void accept(SyntaxTreeVisitor syntaxTreeVisitor) {
        syntaxTreeVisitor.visit(this);
    }

//  analyze the expression by checking its parameter name or
//  parameter value and initialize the specific class
    @Override
    public SyntaxTreeCommand analyze(String expression, Hashtable<String, Integer> parameters) {
        String currentMovingDistance = expression.split(" ")[1];
        if (expression.contains("#")) {
            moveDistance = parameters.get(currentMovingDistance);
        } else {
            moveDistance = Integer.parseInt(currentMovingDistance);
        }
        return new Move(moveDistance);
    }

    @Override
    public void perform(TurtleAlgorithm turtleAlgorithm) {
        turtleAlgorithm.move(this.moveDistance);
    }
}
