/*
    @authors - Nishigandha Kishor Mhaisne (027941743)
               Sushma Sunil Kallapur (027977597)

    The Visitor visits all the nodes in the syntax tree

 */
public interface SyntaxTreeVisitor {

    public void visit(TurtleAlgorithm turtleAlgorithm);
    public void visit(AllocateValues allocateValues);
    public void visit(Repeat repeat);
    public void visit(Move move);
    public void visit(Turn turn);
    public void visit(End end);
}
