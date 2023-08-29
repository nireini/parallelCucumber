package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    public String getCurrentDate(){

        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = currentDate.format(dateFormatter);

        System.out.println("Current date (formatted with month name): " + formattedDate);

        return formattedDate;
    }
}
