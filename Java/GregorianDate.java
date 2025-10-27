public class GregorianDate {
    private int year;
    private int month;
    private int day;
    private static final String[] MONTHS = new String[]{"January", "February",
                                                        "March", "April", "May",
                                                        "June", "July", "August",
                                                        "September", "October", "November",
                                                        "December"};

    public GregorianDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private String getMonthName() {
        return MONTHS[month-1];
    }

    public String toString() {
        return getMonthName() + " " + day + ", " + year;
    }
}