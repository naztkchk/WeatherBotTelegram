package Model;

public class ThreeHourForecast {

    private String date;
    private String location;

    private String timeFrom;
    private String timeTo;

    private String temp;
    private Integer humidity;
    private String sky;


    public ThreeHourForecast(final String date, final String timeFrom, final String timeTo) {
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getDate() {
        return date;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
