package Controller;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WeatherParser {

    private static final String URL_SOURCE  = "http://api.openweathermap.org/data/2.5/forecast?q=";

    private static final String API_KEY  = "&APPID=836ed26c7b6e162cdea5fa5dfcd562bc";
    private static final String MODE_RESPOND = "&mode=xml";
    private static final String LANGUAGE = "&lang=ua";
    private static final String UNITS = "&units=metric";


    public boolean parse(final String location) {

        /** Create request **/

        String query = URL_SOURCE + location + MODE_RESPOND + LANGUAGE + UNITS + API_KEY;

        // Replace blanks with HTML-Equivalent:
        query = query.replace(" ", "%20");

        //Create request:
        try {
            //Turn the string into URL object
            URL urlObject = new URL(query);
            //Open the stream (which returns an InputStreams):
            InputStream in = urlObject.openStream();

            //Create XMLHandler
            XMLReader xr = XMLReaderFactory.createXMLReader();

            OpenWeatherMapHandler ourSpecialHandler = new OpenWeatherMapHandler();
            xr.setContentHandler(ourSpecialHandler);

            InputSource inputSource = new InputSource(in);
            xr.parse(inputSource);

            return true;

        } catch (IOException | SAXException e) {
            return false;
        }
    }

}
