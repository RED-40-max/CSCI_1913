public class Grade implements Comparable<Grade> {
    private double grade;

    public Grade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public int compareTo(Grade o) {
        if (o.getGrade() > this.getGrade()) {
            return -1;
        }
        if (o.getGrade() < this.getGrade()) {
            return 1;
        }
        return 0;
    }
}