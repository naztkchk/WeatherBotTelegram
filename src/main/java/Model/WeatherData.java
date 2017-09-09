package Model;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {

    private static List<ThreeHourForecast> tomorrowForecast = new ArrayList<>(8);
    private static List<ThreeHourForecast> todayForecast = new ArrayList<>();

    public void addTomorrowForecast(final ThreeHourForecast threeHourForecast){
        tomorrowForecast.add(threeHourForecast);
    }
    public void addTodayForecast(final ThreeHourForecast threeHourForecast){
        todayForecast.add(threeHourForecast);
    }

    public  List<ThreeHourForecast> getTomorrowForecast() {
        return tomorrowForecast;
    }

    public  List<ThreeHourForecast> getTodayForecast() {
        return todayForecast;
    }

    public void cleanAll()
    {
        todayForecast.clear();
        tomorrowForecast.clear();
    }
}
