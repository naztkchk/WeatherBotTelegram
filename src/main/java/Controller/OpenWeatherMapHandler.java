package Controller;

import Model.WeatherData;
import Model.ThreeHourForecast;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OpenWeatherMapHandler extends DefaultHandler {

    private boolean inTomorrow = false;
    private boolean inToday = false;

    private boolean bLocation = false;
    private String location;

    private DateGetter dateGetter = new DateGetter();

    private WeatherData weatherData = new WeatherData();

    private ThreeHourForecast threeHourForecast;

    public OpenWeatherMapHandler() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("time")) {
            threeHourForecast = new ThreeHourForecast(
                    (attributes.getValue(0).substring(0,10)),
                    (attributes.getValue(0).substring(11,16)),
                    (attributes.getValue(1).substring(11,16))
            );

            if (threeHourForecast.getDate().equals(dateGetter.getTomorrowDate().substring(0, 10))) {
                inTomorrow = true;
            } else {
                inTomorrow = false;
            }

            if (threeHourForecast.getDate().equals(dateGetter.getCurrentDate().substring(0, 10))) {
                inToday = true;
            } else {
                inToday = false;
            }

            threeHourForecast.setLocation(location);
        }

        if(qName.equals("name")){
            bLocation = true;
        }

        if (qName.equals("temperature")) {
            threeHourForecast.setTemp(attributes.getValue(1).toString());
        }

        if(qName.equals("humidity")){
            threeHourForecast.setHumidity(Integer.parseInt(attributes.getValue(0)));
        }

        if(qName.equals("symbol")){
            threeHourForecast.setSky(attributes.getValue(1));
        }

        if(inToday && qName.equals("time")){
            weatherData.addTodayForecast(threeHourForecast);
        }

        if(inTomorrow && qName.equals("time")){
            weatherData.addTomorrowForecast(threeHourForecast);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bLocation){
            location = new String(ch, start, length);
            bLocation = false;
        }
    }
}
