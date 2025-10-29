import Java.ShapeFiles.Tester;

/**
 * ShapeUtilsTester class file.
 * CSCI 1913.
 * Written by Min Namgung and Daniel Kluver
 * Changed by Adriana Picoral in Fall 2025
 */

public class ShapeUtilsTester {

    public static void main(String[] args) {
        // comment some of these out as needed
        testDistance(); // calls to ShapeUtils.distance(Point, Point);
        testGetCenter(); // calls to ShapeUtils.getCenter(Points[]);
        testCircleArea(); // calls to ShapeUtils.getArea(Circle), Circle.getArea(Circle), and c.getArea()
        testRingArea(); // calls to ShapeUtils.getArea(Ring)
        testIsInCircle(); // calls ShapeUtils.isIn(Circle, Point)
    }

     public static void testDistance() {
         System.out.println("******************* Point distance test *******************");
         //Point function tests:
         System.out.println("Test 1");
         Point p1 = new Point(1.0, 1.0);
         Point p2 = new Point(1.0, 0.0);
         double d1 = ShapeUtils.distance(p1, p2);
         Tester.doTest(1.0, d1, ".distance(p1, p2)");

         System.out.println("Test 2");
         Point p3 = new Point(23.6, -34.5);
         double d2 = ShapeUtils.distance(p1, p3);
         Tester.doTest(42.083369636948035, d2, ".distance(p1, p3)");
     }

     public static void testGetCenter() {
         System.out.println("******************* Center point tests *******************");

         Point[] points;
         Point p;

         System.out.println("Test 1");
         points = new Point[3];
         points[0] = new Point(80, 0);
         points[1] = new Point(0, 10);
         points[2] = new Point(160, 10);

         p = ShapeUtils.getCenter(points);
         Tester.doTest(80.0, p.getX(), ".getCenter(points) x value");
         Tester.doTest(6.666666666666667, p.getY(), ".getCenter(points) y value");

         System.out.println("Test 2");
         points = new Point[3];
         points[0] = new Point(12, 10);
         points[1] = new Point(0, 53);
         points[2] = new Point(30, 54);

         p = ShapeUtils.getCenter(points);
         Tester.doTest(14.0, p.getX(), ".getCenter(points) x value");
         Tester.doTest(39.0, p.getY(), ".getCenter(points) y value");

         System.out.println("Test 3");
         points = new Point[3];
         points[0] = new Point(1, 0);
         points[1] = new Point(3, 4);
         points[2] = new Point(5, 4);

         p = ShapeUtils.getCenter(points);
         Tester.doTest(3.0, p.getX(), ".getCenter(points) x value");
         Tester.doTest(2.6666666666666665, p.getY(), ".getCenter(points) y value");

         System.out.println("Test 4");
         points = new Point[0];
         // empty array: return (0, 0)
         p = ShapeUtils.getCenter(points);
         Tester.doTest(0.0, p.getX(), ".getCenter(points) x value");
         Tester.doTest(0.0, p.getY(), ".getCenter(points) y value");

         System.out.println("Test 5");
         points = new Point[10];
         points[0] = new Point(1, 10);
         points[1] = new Point(2, 9);
         points[2] = new Point(3, 8);
         points[3] = new Point(4, 7);
         points[4] = new Point(5, 6);
         points[5] = new Point(6, 5);
         points[6] = new Point(7, 4);
         points[7] = new Point(8, 3);
         points[8] = new Point(9, 2);
         points[9] = new Point(10, 1);

         p = ShapeUtils.getCenter(points);
         Tester.doTest(5.5, p.getX(), ".getCenter(points) x value");
         Tester.doTest(5.5, p.getY(), ".getCenter(points) y value");

     }

     public static void testCircleArea() {
         System.out.println("******************* Get Circle area tests *******************");

         System.out.println("Test 1");
         Circle c = new Circle(new Point(1.0, 1.0), 2);
         double area = ShapeUtils.getArea(c);
         Tester.doTest(12.566370614359172, area, "ShapeUtils.getArea(c)");

         area = Circle.getArea(c);
         Tester.doTest(12.566370614359172, area, "Circle.getArea(c)");

         area = c.getArea();
         Tester.doTest(12.566370614359172, area, "c.getArea()");

         System.out.println("Test 2");
         c = new Circle(new Point(3.1, 1.9), 0);
         area = ShapeUtils.getArea(c);
         Tester.doTest(0.0, area, "ShapeUtils.getArea(c)");

         area = Circle.getArea(c);
         Tester.doTest(0.0, area, "Circle.getArea(c)");

         area = c.getArea();
         Tester.doTest(0.0, area, "c.getArea()");

         System.out.println("Test 3");
         c = new Circle(new Point(2.5, 1.0), -3);
         area = ShapeUtils.getArea(c);
         Tester.doTest(0.0, area, "ShapeUtils.getArea(c)");

         area = Circle.getArea(c);
         Tester.doTest(0.0, area, "Circle.getArea(c)");

         area = c.getArea();
         Tester.doTest(0.0, area, "c.getArea()");

         System.out.println("Test 4");
         c = new Circle(new Point(8.0, 10.0), 10);
         area = ShapeUtils.getArea(c);
         Tester.doTest(314.1592653589793, area, "ShapeUtils.getArea(c)");

         area = Circle.getArea(c);
         Tester.doTest(314.1592653589793, area, "Circle.getArea(c)");

         area = c.getArea();
         Tester.doTest(314.1592653589793, area, "c.getArea()");

     }

     public static void testRingArea() {
         System.out.println("******************* Get Ring area tests *******************");

         System.out.println("Test 1");
         double ring_area_test_1 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), 1));
         Tester.doTest(15.707963267948966, ring_area_test_1, "ShapeUtils.getArea(Ring)");

         System.out.println("Test 2");
         double ring_area_test_2 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), -2));
         Tester.doTest(1.2880529879718157, ring_area_test_2, "ShapeUtils.getArea(Ring)");

         System.out.println("Test 3");
         double ring_area_test_3 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), 10));
         Tester.doTest(439.822971502571, ring_area_test_3, "ShapeUtils.getArea(Ring)");

         System.out.println("Test 4");
         double ring_area_test_4 = ShapeUtils.getArea(new Ring(new Circle(new Point(1.0, 1.0), 2), -10));
         Tester.doTest(1.2880529879718157, ring_area_test_4, "ShapeUtils.getArea(Ring)");
     }

     public static void testIsInCircle() {
         System.out.println("******************* Is in circle tests *******************");

         System.out.println("Test 1");
         Circle c1 = new Circle(new Point(0, -5), 10);
         Point p = new Point(0, 0);
        Tester.doTest(true, ShapeUtils.isIn(c1, p), "ShapeUtils.isIn(Circle, Point)");

         System.out.println("Test 2");
         c1 = new Circle(new Point(0, -5), 1);
         p = new Point(0, 0);
         Tester.doTest(false, ShapeUtils.isIn(c1, p), "ShapeUtils.isIn(Circle, Point)");

         System.out.println("Test 3");
         c1 = new Circle(new Point(0, -5), 5);
         p = new Point(0, 0);
         Tester.doTest(true, ShapeUtils.isIn(c1, p), "ShapeUtils.isIn(Circle, Point)");
     }


 }