// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)
/*
    This class to drive all the functionality of the Turtle algorithm class
 */
public class MainApplication {

    public static void main(String[] args) {
        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("TACommandTest.txt");
        turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));
        CalculateDistanceVisitor distanceVisitor = new CalculateDistanceVisitor(turtleAlgorithm);
        turtleAlgorithm.accept(distanceVisitor);

        System.out.println("The end location of the turtle is: " + turtleAlgorithm.location());
        System.out.println("The total distance turtle covered is: " + distanceVisitor.getTotalDistance());

    }


}
