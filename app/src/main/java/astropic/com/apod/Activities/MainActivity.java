package astropic.com.apod.Activities;

import android.graphics.drawable.GradientDrawable;
import android.net.Network;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import astropic.com.apod.API.NetworkUtils;
import astropic.com.apod.Adapters.PictureAdapter;
import astropic.com.apod.Classes.Picture;
import astropic.com.apod.Interfaces.DelegateData;
import astropic.com.apod.R;
import astropic.com.apod.Tasks.FetchPictures;

public class MainActivity extends AppCompatActivity implements DelegateData {
    public ArrayList<Picture> potd = new ArrayList<>();
    public RecyclerView rview;
    public PictureAdapter picAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to RecyclerView based on id
        rview = findViewById(R.id.rv_pic);

        // New adapter object
        picAdapter = new PictureAdapter();

        // Initialize and declare new LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // Set particular LayoutManager in the RecyclerView
        rview.setLayoutManager(mLayoutManager);
        rview.hasFixedSize();

        // Set Adapter of RecyclerView accordingly
        rview.setAdapter(picAdapter);

        // Fetch data from API as parsed Picture objects
        try {
            fetchPictures();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void fetchPictures() throws MalformedURLException {
        FetchPictures fetch = new FetchPictures();
        fetch.delegator = this;
        fetch.execute(NetworkUtils.buildUrl());
    }

    @Override
    public void processPicture(Picture output) {
        this.potd.add(output);

        // Set new list in global picAdapter
        picAdapter.setList(potd);
    }
}
