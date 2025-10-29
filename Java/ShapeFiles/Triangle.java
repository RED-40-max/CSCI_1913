package Java.ShapeFiles;
public class Triangle extends Polygon
{

    public Triangle(double[] measures)
    {
        super(measures);
        super.name = "Triangle";
        super.sides = 3;
    }
    public Triangle()
    {
        super.name = "Triangle";
        super.sides = 3;

    }


}
