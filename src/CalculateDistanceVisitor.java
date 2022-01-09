/*
    @authors - Nishigandha Kishor Mhaisne (027941743)
               Sushma Sunil Kallapur (027977597)

    This class is to get the total distance
 */
public class CalculateDistanceVisitor implements  SyntaxTreeVisitor {
//     setting total distance to zero
    private int totalDistance = 0;
    private TurtleAlgorithm turtleAlgorithm;
//    Constructor
    public CalculateDistanceVisitor(TurtleAlgorithm turtleAlgorithm) {
        this.turtleAlgorithm = turtleAlgorithm;
    }
//    Getter and Setter
    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public TurtleAlgorithm getTurtleAlgorithm() {
        return turtleAlgorithm;
    }

    public void setTurtleAlgorithm(TurtleAlgorithm turtleAlgorithm) {
        this.turtleAlgorithm = turtleAlgorithm;
    }

    @Override
    public void visit(TurtleAlgorithm turtleAlgorithm) {
        turtleAlgorithm.perform(turtleAlgorithm);

    }

    @Override
    public void visit(AllocateValues allocateValues) {
        allocateValues.perform(turtleAlgorithm);
    }

//    Calculating and updating the total distance whenever the move operation occurs
    @Override
    public void visit(Move move) {
        move.perform(turtleAlgorithm);
        totalDistance += move.getMoveDistance();
    }

    @Override
    public void visit(Turn turn) {
        turn.perform(turtleAlgorithm);
    }

    @Override
    public void visit(Repeat repeat) {
        repeat.perform(turtleAlgorithm);

    }

    @Override
    public void visit(End end) {
        end.perform(turtleAlgorithm);
    }
}
