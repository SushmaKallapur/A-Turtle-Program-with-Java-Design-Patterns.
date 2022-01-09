// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
    This test class cover testing for all the methods of turtle algorithm and turtle class
 */
class TurtleAlgorithmTest {

    Turtle turtle;


    @BeforeEach
    void setUp() {
        turtle = new Turtle();
    }

//  To test file with no commands
    @Test
    public void testTurtleAlgorithmForNoCommands() {

        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("NoCommand.txt");
        turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));
        Point correctAnswer=new Point(0,0);
        assertEquals(correctAnswer, turtleAlgorithm.location());
    }

//  To test file with just one commands
    @Test
    public void testTurtleMoveForOneCommand() {
        turtle.turn(180);
        Point correctAnswer=new Point(0,0);
        assertEquals(correctAnswer, turtle.location());

    }
//  To test file with invalid commands
    @Test
    public void testTurtleMoveInvalidCommand() {
        try {
            TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("InvalidCommand.txt");
            turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));
        } catch (NullPointerException error) {
            System.out.println("There are invalid commands, Please Check!!");
        }


    }

//  Test for Basic commands with sequence (Displayed newLine with /):
//  move 10/turn 90/move 20/turn -60/move 15
    @Test
    public void testTurtleAlgorithmWithCommands() {
        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("TACommandTest.txt");
        turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));

        Point correctAnswer=new Point(23,28);

        assertEquals(correctAnswer, turtleAlgorithm.location());

    }

//  To test total distance covered by turtle (Displayed newLine with /):
// #x = 2/repeat 3/move #x/turn 90/end/move 10/repeat #x/move #x/end
    @Test
    public void testTurtleAlgorithmForTotalDistance() {

        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("repeatCommands.txt");

        CalculateDistanceVisitor a = new CalculateDistanceVisitor(turtleAlgorithm);
        turtleAlgorithm.accept(a);
        assertEquals(20, a.getTotalDistance());

    }

//  To test turtle movement for checking correct location (Displayed newLine with /):
//  #x = 2/repeat 3/move #x/turn 90/end/move 10/repeat #x/move #x/end
    @Test
    public void testTurtleAlgorithmForLocation() {
        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("repeatCommands.txt");
        turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));
        Point correctAnswer=new Point(0,-12);
        assertEquals(correctAnswer, turtleAlgorithm.location());

    }

//  To test turtle movement with negative values
//  #x = -20/#y = -45/move #x/turn #y/move #x/turn 90
    @Test
    public void testTurtleAlgorithmWithNegativeValues() {
        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("negativeValues.txt");
        turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));
        Point correctAnswer=new Point(-34,14);
        assertEquals(correctAnswer, turtleAlgorithm.location());
    }

//  To test turtle total distance even with 180 degree turn
//  move 10/turn 180/move 10
    @Test
    public void testTurtleAlgorithmForTotalDist() {

        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("backToOrigin.txt");
        CalculateDistanceVisitor a = new CalculateDistanceVisitor(turtleAlgorithm);
        turtleAlgorithm.accept(a);
        assertEquals(20, a.getTotalDistance());

    }

//  To test turtle movement horizontally
    @Test
    public void testTurtleMove() {
        turtle.move(5);
        Point correctAnswer=new Point(5,0);
        assertEquals(correctAnswer, turtle.location());
    }

//    To test turtle movement vertically
    @Test
    public void testTurtleMoveVertically() {
        turtle.turn(90);
        turtle.move(5);
        Point correctAnswer=new Point(0,5);
        assertEquals(correctAnswer, turtle.location());
    }

//    To test turtle movement with angle between 0-90

    @Test
    public void testTurtleMoveForAngle() {
        turtle.turn(53);
        turtle.move(5);
        Point correctAnswer=new Point(3,4);
        assertEquals(correctAnswer, turtle.location());
    }

//  To test turtle movement with some negative angle 0-90
    @Test
    public void testTurtleMoveForNegAngle() {
        turtle.turn(-53);
        turtle.move(5);
        Point correctAnswer=new Point(3,-4);
        assertEquals(correctAnswer, turtle.location());
    }


//  To test  turtle movement eventually coming back to zero
//  #s = 15/move #s/turn 90/move #s/turn 90/move #s/turn 90/move #s

    @Test
    public void testTurtleAlgorithmToOrigin() {
        TurtleAlgorithm turtleAlgorithm = new TurtleAlgorithm("turn90.txt");
        turtleAlgorithm.accept(new SyntaxTreeCommandProcessor(turtleAlgorithm));
        Point correctAnswer=new Point(0,0);
        assertEquals(correctAnswer, turtleAlgorithm.location());
    }




}