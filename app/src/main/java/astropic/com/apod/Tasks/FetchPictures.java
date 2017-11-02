package astropic.com.apod.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

import astropic.com.apod.API.NetworkUtils;
import astropic.com.apod.Classes.Picture;
import astropic.com.apod.Interfaces.DelegateData;

/**
 * Created by Joachim on 02/11/2017.
 */

public class FetchPictures extends AsyncTask<URL, Void, String>{
    public DelegateData delegator = null;
    @Override
    protected String doInBackground(URL... urls) {
        // Get the url
        URL apiCall= urls[0];

        // Initiate the return variable
        String results = null;

        try {
            results = NetworkUtils.getResponseFromHttpUrl(apiCall);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return results;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String results) {
        if(!results.equals("")) {
            try {
                JSONObject jsonObject = new JSONObject(results);
                Picture output = new Picture(
                        jsonObject.getString("title"),
                        jsonObject.has("copyright") ? jsonObject.getString("copyright") : "",
                        jsonObject.getString("date"),
                        jsonObject.getString("explanation"),
                        jsonObject.getString("hdurl")
                );

                delegator.processPicture(output);

            } catch(JSONException exc) {
                exc.printStackTrace();
            }
        }
    }
}
