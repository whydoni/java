public class MyDate {
	private int day = 1;
	private int month = 1;
	private int year = 2000;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public MyDate(MyDate date) {
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate addDays(int moreDays) {
	    MyDate newDate = new MyDate(this);
	    newDate.day = newDate.day + moreDays;
	    // Not Yet Implemented: wrap around code...
	    return newDate;
    }

    public MyDate addMonth(int moreMonth) {
        MyDate newDate = new MyDate(this);
        newDate.month = newDate.month + moreMonth;
        return newDate;
    }
    public MyDate addYear(int moreYear) {
        MyDate newDate = new MyDate(this);
        newDate.year = newDate.year + moreYear;
        return newDate;
    }
    public MyDate decreaseDays(int day) {
        MyDate newDate = new MyDate(this);
        newDate.day = newDate.day - day;
        return newDate;
    }
    public MyDate decreaseMonth(int month) {
        MyDate newDate = new MyDate(this);
        newDate.month = newDate.month - month;
        return newDate;
    }

     public String toString() {
        String retString = "" + day + "-" + month + "-" + year;
 	    return retString;
	}
}
