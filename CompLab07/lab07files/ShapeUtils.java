/*

 */
import static java.lang.Math.sqrt;

public class ShapeUtils {


    public static double distance(Point p1, Point p2)
    {
        //distance = sqrt(((x1 - x2)**2) + ((y1 - y2)**2))
        double x1 = p1.getX();
        double y1 = p1.getY();

        double x2 = p2.getX();
        double y2 = p2.getY();

        double distance = sqrt( (Math.pow(x1 - x2, 2)) + (Math.pow(y1 - y2, 2)));
            //math.pow(base, exponent)
        return distance;
    }

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

    public static double getArea(Ring r)
    {
        double innerCircleRad = r.getInnerCircle().getRadius();
        double innerCircle =  (Math.PI) * Math.pow(innerCircleRad,2);

        double outerCircleRad = innerCircleRad + r.getThickness();
        double outerCircle =  (Math.PI) * Math.pow(outerCircleRad,2);

        return ( outerCircle - innerCircle);

    }

    public static double getArea(Circle c)
    {
        double rad = c.getRadius();
        return (Math.PI * Math.pow(rad, 2));
    }

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

