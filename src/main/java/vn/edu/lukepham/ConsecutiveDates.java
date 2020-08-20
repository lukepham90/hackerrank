package vn.edu.lukepham;

import org.apache.commons.lang3.tuple.Pair;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Luke Pham
 * @since : 20/06/2020, Sat
 **/
public class ConsecutiveDates {

    public static void main(String[] args) {
        LocalDate from = LocalDate.of(2020, 06, 01);
        LocalDate to = LocalDate.of(2020, 06, 30);

        Set<DayOfWeek> dayOfWeekSet = new HashSet<>();
        dayOfWeekSet.add(DayOfWeek.MONDAY);
        dayOfWeekSet.add(DayOfWeek.TUESDAY);
        dayOfWeekSet.add(DayOfWeek.SATURDAY);
        dayOfWeekSet.add(DayOfWeek.SUNDAY);

        List<LocalDate> dates = new ArrayList<>();
        for (LocalDate day = from; !day.isAfter(to); day = day.plusDays(1)) {
            if (dayOfWeekSet.contains(day.getDayOfWeek())) {
                dates.add(day);
            }
        }
        Pair<LocalDate, LocalDate> pairConsecutiveDate;
        List<Pair<LocalDate, LocalDate>> pairConsecutiveDates = new ArrayList<>();
        int i = 0;
        while (i < dates.size()) {
            int j = i;
            LocalDate leftDate = dates.get(i);
            pairConsecutiveDate = Pair.of(leftDate, leftDate);
            while (j < dates.size() - 1) {
                j++;
                LocalDate rightDate = dates.get(j);
                if (rightDate.equals(dates.get(j - 1).plusDays(1))) {
                    pairConsecutiveDate = Pair.of(leftDate, rightDate);
                } else {
                    i = j;
                    break;
                }
            }
            pairConsecutiveDates.add(pairConsecutiveDate);
            if (j == dates.size() - 1) {
                break;
            }
        }

        System.out.println(pairConsecutiveDates);

    }
}
