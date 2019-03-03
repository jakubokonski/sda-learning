public class _10_LeapYear {
    public static void main(String[] args) {

        int month = 2;
        int year = 2020;

        int numDays = 0;
        String days = "Dni: ";

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 2:
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    numDays = 29;
            } else {
                    numDays = 28;
            } break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            default:
                System.out.println("Out of range");
                break;

            // for case 2 feb / leap yesr
            // ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)
            // it's leap year
        }
        System.out.println(days + numDays);



    }
}
