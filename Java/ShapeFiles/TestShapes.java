package Java.ShapeFiles;

public class TestShapes {

    public static void main(String[] args) {
        int errors = 0;
        errors += testPolygon();
        errors += testRectangle();
        errors += testSquare();
        errors += testTriangle();

        System.out.println("*********************************************");
        System.out.println(errors + " errors");
    }

    public static int testTriangle() {
        System.out.println("************** Testing Triangle ***************");
        int errors = 0;
        Triangle triangle = new Triangle();
        errors += Tester.doTest(3, triangle.getSides(), "triangle.getSides()");

        String expected = "Triangle has 3 sides\nMeasures are: 0.0 0.0 0.0";
        errors += Tester.doTest(expected, triangle.toString(), "triangle.toString()");

        return errors;
    }

    public static int testSquare() {
        System.out.println("************** Testing Square ***************");
        int errors = 0;
        Square square = new Square(5);
        errors += Tester.doTest(4, square.getSides(), "square.getSides()");

        String expected = "Square has 4 sides\nMeasures are: 5.0 5.0 5.0 5.0";
        errors += Tester.doTest(expected, square.toString(), "square.toString()");

        return errors;
    }

    public static int testRectangle() {
        System.out.println("************* Testing Rectangle *************");
        int errors = 0;
        Rectangle rectangle = new Rectangle();

        String expected = "Rectangle has 4 sides\nMeasures are: 0.0 0.0 0.0 0.0";
        errors += Tester.doTest(expected, rectangle.toString(), "rectangle.toString()");

        Polygon polygon = new Polygon(new double[4]);
        errors += Tester.doTest(false, rectangle.equals(polygon), "rectangle.equals()");

        return errors;
    }

    public static int testPolygon() {
        System.out.println("************** Testing Polygon **************");
        int errors = 0;
        Polygon polygon = new Polygon(new double[]{1, 2, 3, 1});
        errors += Tester.doTest(4, polygon.getSides(), "polygon.getSides()");

        String expected = "Polygon has 4 sides\nMeasures are: 1.0 2.0 3.0 1.0";
        errors += Tester.doTest(expected, polygon.toString(), "polygon.toString()");

        Polygon two = null;
        errors += Tester.doTest(false, polygon.equals(two), "polygon.equals(Polygon)");

        two = new Polygon(new double[]{1, 2, 3, 1});
        errors += Tester.doTest(true, polygon.equals(two), "polygon.equals(Polygon)");

        two = new Polygon(new double[]{1, 2, 3});
        errors += Tester.doTest(false, polygon.equals(two), "polygon.equals(Polygon)");

        errors += Tester.doTest(true, two.equals(two), "polygon.equals(Polygon)");

        Polygon empty = new Polygon();
        errors += Tester.doTest("Polygon has 0 sides", empty.toString(), "polygon.equals(Polygon)");

        return errors;
    }
}
