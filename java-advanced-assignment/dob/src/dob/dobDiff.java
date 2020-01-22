package dob;

import java.time.*;

public class dobDiff {
    public static void main(String[] args) {
        LocalDate myfather_dob = LocalDate.of(1970, Month.AUGUST, 20);
        LocalDate my_dob = LocalDate.of(1999, Month.JUNE, 17);
        Duration diff = Duration.between((myfather_dob.atStartOfDay().toInstant(ZoneOffset.UTC)), (my_dob.atStartOfDay().toInstant(ZoneOffset.UTC)));
        Double ns = (diff.getSeconds() * Math.pow(10,9)) + diff.getNano();
        System.out.println("Difference in nanoseconds: " + ns + " ns");

        ZonedDateTime date1 = myfather_dob.atStartOfDay(ZoneId.of("Asia/Calcutta"));
        ZonedDateTime date2 = my_dob.atStartOfDay(date1.getZone());

        double zduration = Duration.between(date1, date2).toDays();
        System.out.println("Difference in days considering zones: " + zduration + " days");
    }
}