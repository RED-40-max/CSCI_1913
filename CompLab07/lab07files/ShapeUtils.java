/*
    Shapes Util - program to calculate certain metrics
    Written by: Nikki, Shawn, Leonard

 */
import static java.lang.Math.sqrt;

public class ShapeUtils {

    /**
     * gets the distance between 2 points given the formula
     *      distance = sqrt(((x1 - x2)**2) + ((y1 - y2)**2))
     * The method '.pow' is used to exponentiate the values
     **/
    public static double distance(Point p1, Point p2)
    {
        double x1 = p1.getX();
        double y1 = p1.getY();

        double x2 = p2.getX();
        double y2 = p2.getY();

        double distance = sqrt( (Math.pow(x1 - x2, 2)) + (Math.pow(y1 - y2, 2)));
            //math.pow(base, exponent)
        return distance;
    }
    /**
     * gets the cetner of the points by
     *      - finding avg of x
     *      - finding avg of y
     *      - using avgrage point as the center
     **/
    public static Point getCenter(Point[] points)
    {
        if (points.length == 0)
        {
            Point nullPoint = new Point(0.0,0.0);
            return nullPoint; //return 0,0
        }

        double avgXval = 0.0;
        double avgYval = 0.0;
        double runningLength = 0.0;
        Point currPoint;

        for(int x = 0; x < points.length; x++)
        {
                currPoint = points[x];

                avgXval += currPoint.getX();
                avgYval += currPoint.getY();
                runningLength ++;
        }

        avgXval /= runningLength;
        avgYval /= runningLength;
        Point Final_point = new Point( avgXval, avgYval);

        return Final_point;
    }

    /**
     * gets area by using the equation
     *      - Area = pi * r^2
     * gets the area of a ring by taking
     *      - (Area of outer - Area of inner)
     **/
    public static double getArea(Ring r)
    {
        double innerCircleRad = r.getInnerCircle().getRadius();
        double innerCircle =  (Math.PI) * Math.pow(innerCircleRad,2);

        double outerCircleRad = innerCircleRad + r.getThickness();
        double outerCircle =  (Math.PI) * Math.pow(outerCircleRad,2);

        return ( outerCircle - innerCircle);

    }
    /**
     * Gets the Area of a Circle by doing pi * r^2
     **/
    public static double getArea(Circle c)
    {
        double rad = c.getRadius();
        return (Math.PI * Math.pow(rad, 2));
    }

    /**
     * Checks if point is in circle to see if it is
     *      within the center of the radius of the circle
     **/
    public static boolean isIn(Circle c, Point p)
    {
        Point CenterPoints = c.getCenter();
        double distanceFromCenter = distance(CenterPoints, p);

        if (distanceFromCenter <= c.getRadius())
        {
            return true;
        } else
        {
            return false;
        }

    }
}

