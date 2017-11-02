package astropic.com.apod.API;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Joachim on 02/11/2017.
 */

public class NetworkUtils {
    final static String BASE_URL = "https://api.nasa.gov/planetary/apod";
    final static String QUERY_PARAM = "api_key=";
    final static String API_KEY = "09445ijXzQ8FW1z4oHYYmusW6NGNGyoaUvttm8Wv";

    // Static method to build the URL
    public static URL buildUrl() {
        String URL = BASE_URL + "?date=2017-01-11&" + QUERY_PARAM + API_KEY;

        Uri builtUri = Uri.parse(URL).buildUpon().build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());
        } catch(Exception exc) {
            exc.printStackTrace();
        }

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
