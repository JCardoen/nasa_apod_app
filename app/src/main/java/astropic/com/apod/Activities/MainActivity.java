package astropic.com.apod.Activities;

import android.net.Network;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.concurrent.ExecutionException;

import astropic.com.apod.API.NetworkUtils;
import astropic.com.apod.Classes.Picture;
import astropic.com.apod.Interfaces.DelegateData;
import astropic.com.apod.R;
import astropic.com.apod.Tasks.FetchPictures;

public class MainActivity extends AppCompatActivity implements DelegateData {
    public ImageView imageView;
    public TextView authorText;
    public TextView titleText;
    public TextView explanationText;
    public Picture potd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView = findViewById(R.id.iv_pic);
        this.authorText = findViewById(R.id.tv_author);
        this.titleText = findViewById(R.id.tv_title);
        this.explanationText = findViewById(R.id.tv_explanation);
        fetchPictures();
    }

    public void fetchPictures() {
        FetchPictures fetch = new FetchPictures();
        fetch.delegator = this;
        fetch.execute(NetworkUtils.buildUrl());
    }

    @Override
    public void processPicture(Picture output) {
        this.potd = output;
        setData();
    }

    private void setData() {
        Picasso.with(this).load(potd.url).into(imageView);
        this.authorText.setText(potd.author + " posted on: " + potd.date);
        this.titleText.setText(potd.title);
        this.explanationText.setText(potd.explanation);
    }
}
