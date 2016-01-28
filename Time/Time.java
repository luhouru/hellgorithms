import java.util.Scanner;

public class Time {

    static boolean afterNoon(String s) {
        return s.contains("PM");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        input = in.next();

        boolean afterNoon = afterNoon(input);

        //remove the last two characters
        String newTime = input.substring(0,8);


        if (!afterNoon) { // its AM (Ex:11:59:00 AM)
            // we do not change time unless its hour is 12 AM, then its 00
            if (newTime.substring(0,2).equals("12")) {
                newTime = "00" + newTime.substring(2,newTime.length());
            }
        } else { // add 12 to hour
            // check if before 10
            String first = input.substring(0,1);
            if (first.equals("0")) {
                // convert second char to int
                Integer hour = Integer.parseInt(input.substring(1,2));
                Integer newHour = hour + 12;
                // convert back to string
                String changeHour = newHour.toString();
                newTime = changeHour + newTime.substring(2,newTime.length());
            } else { // above 10
                String hour = input.substring(0,2);
                Integer toInt = Integer.parseInt(hour);
                Integer newHour = toInt + 12;
                if (newHour >= 24) {
                    newHour -= 12;
                }
                // convert back to string
                String changeHour = newHour.toString();
                newTime = changeHour + newTime.substring(2, newTime.length());
            }
        }

        System.out.println(newTime);
    }
}
