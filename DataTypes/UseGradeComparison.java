import java.util.Arrays;

public class UseGradeComparison {
    public static void main(String[] args) {
        Grade[] grades = new Grade[]{new Grade(10.3), new Grade(0.3), new Grade(3)};
        Arrays.sort(grades); // this works because Grade implements Comparable
        for (Grade g : grades) {
            System.out.println(g.getGrade());
        }
    }
}