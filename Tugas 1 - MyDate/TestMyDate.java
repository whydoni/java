public class TestMyDate {
	public static void main(String[] args) {
 		MyDate my_birth = new MyDate(22, 7, 1964);
 		MyDate the_next_week = my_birth.addDays(7);
			
 		System.out.println(the_next_week);

 		MyDate date1 = new MyDate(22, 7, 1964);
 		MyDate nextMonth = date1.addMonth(1);
 		System.out.println(nextMonth);

 		MyDate date2 = new MyDate(22, 7, 1964);
 		MyDate moreYear = date2.addYear(5);
 		System.out.println(moreYear);

 		MyDate date3 = new MyDate(22, 7, 1964);
 		MyDate previousWeek = date3.decreaseDays(7);
 		System.out.println(previousWeek);

 		MyDate date4 = new MyDate(22, 7, 1964);
 		MyDate previousMonth = date4.decreaseMonth(1);
 		System.out.println(previousMonth);
 	}
}
