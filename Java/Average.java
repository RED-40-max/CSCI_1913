package Java;



public class Average {

    public static double average(int[] numbers)
    {
        double runningSum = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            runningSum = numbers[i];

        }
            return (runningSum /numbers.length);

    }


}
