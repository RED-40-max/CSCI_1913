package Java.ShapeFiles;
/* Week 08, Lecture 1: Inheretence

    Overload: two constructors, one with array of side measures, another with no arguments

    Override: toString() and equals(Object o)

    Submit to gradescope:
    Poygon.java,
    Rectangle.java,
    Square.java and
    Triangle.java


 */


public class Polygon {
    protected String name = "Polygon";
    protected int sides;
    private double[] measures = new double [100];

    public Polygon (double[] measures)
    {
        sides = measures.length;
        for (int x = 0; x < measures.length; x++)
        {
            this.measures[x] = measures[x];
        }
    }

    public Polygon()
    {

    }
    protected void setMeasures(double[] measures)
    {
        this.measures = measures;
    }

    public double[] getMeasures()
    {
        return measures;
    }

    public int getSides()
    {
        return sides;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        String result = name + " has " + sides + " sides";
        if (sides > 0)
        {
            result += "\nMeasures are:";
            for (int i = 0; i < sides; i++)
            {
                result += " " + measures[i];
            }

        }
        return result;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (this == obj)
        {
            return true;
        }
        if (((Polygon) obj).getSides() != sides)
        {
            return false;

        }
        for (int i = 0; i < sides; i ++)
        {
            if (((Polygon) obj).getMeasures()[i] != measures[i])
            {
                return false;
            }
        }

        if (((Polygon) obj).getName() != name)
        {
            return false;
        }

        return true;



    }



}
