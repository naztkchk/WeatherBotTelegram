package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGetter {

    final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String currentDate;
    public String tomorrowDate;

    public DateGetter() {
        Date date = new Date();
        currentDate = dateFormat.format(date);
        tomorrowDate = dateFormat.format(new Date(date.getTime() + (1000 * 60 * 60 * 24)));
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getTomorrowDate() {
        return tomorrowDate;
    }
}
