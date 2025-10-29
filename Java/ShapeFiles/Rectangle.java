package Java.ShapeFiles;

public class Rectangle extends Polygon {

    public Rectangle(double[] measures)
    {
        super(measures);
        super.sides = 4;
        super.name = "Rectangle";
    }

    public Rectangle()
    {
        super.sides = 4;
        super.name = "Rectangle";

    }




}
