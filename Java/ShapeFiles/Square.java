package Java.ShapeFiles;
public class Square extends Rectangle
{

    public Square(double measure)
    {
        double[] measures = new double[4];

        for(int i = 0; i < 4; i ++)
        {
            measures[i] = measure;
        }
        super. setMeasures(measures);
        super.name = "Square";
    }

}
