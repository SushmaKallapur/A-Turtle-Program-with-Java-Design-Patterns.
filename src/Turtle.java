// @authors - Nishigandha Kishor Mhaisne (027941743)
//            Sushma Sunil Kallapur (027977597)

import java.awt.*;
/*
    This class represents the turtle possible movements
 */
public class Turtle {

    private float currentDirection;
    private Point currentLocation;
    private boolean penDown;

    public Turtle() {
        this.currentLocation = new Point();
        this.penDown = true;
        this.currentDirection = 0;
    }

//  Move the turtle in current direction with given distance
    public void move(int distance) {
        if(penDown) {
            double xDeltaDistance = Math.cos(currentDirection * Math.PI/180.0) * distance;
            double yDeltaDistance = Math.sin(currentDirection * Math.PI/180.0) * distance;

            double xDistance = currentLocation.getX() + xDeltaDistance;
            double yDistance = currentLocation.getY() + yDeltaDistance;

            currentLocation.setLocation(xDistance, yDistance);
        }
    }
//  Adding the given degree to the current heading of the turtle
    public void turn(int degrees) {
        currentDirection += degrees;
    }

//  Returning the distance at given point
    public float distanceTo(Point point) {
        return (float) currentLocation.distance(point);
    }

//  Returning the current direction of the turtle
    public float direction() {
        return this.currentDirection;
    }

//  Returning the current location of the turtle
    public Point location() {
        return this.currentLocation;
    }

//  Returning the angle in degrees for the given point
    public float bearingTo(Point point) {
        double xLocation = currentLocation.getX() - point.getX();
        double yLocation = currentLocation.getY() - point.getY();

        return (float) Math.atan(yLocation/xLocation);

    }

}
