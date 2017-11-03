package astropic.com.apod.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import astropic.com.apod.Classes.Picture;
import astropic.com.apod.R;
import astropic.com.apod.Viewholders.PictureViewholder;

/**
 * Created by Joachim on 03/11/2017.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureViewholder> {

    // Member fields
    private ArrayList<Picture> mList = new ArrayList<>();

    // Function to set member field
    public void setList(ArrayList<Picture> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public PictureViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        // Referenced id fro; the pictureviewholder.xml file
        int layout = R.layout.pictureviewholder;

        // Creqate inflater from parent context
        LayoutInflater inflater = LayoutInflater.from(context);

        // Create a new based on the layout id, parent
        View view = inflater.inflate(layout, parent, false);

        return new PictureViewholder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewholder holder, int position) {
        // Get current Picture object in line
        Picture pic = mList.get(position);

        // Set/bind all data on the coherent ViewHolder object
        holder.authorText.setText((String) pic.author);
        holder.explanationText.setText((String) pic.explanation);
        holder.titleText.setText((String) pic.title);
        holder.authorText.setText((String) pic.author + " posted on :" + pic.date);
        Picasso.with(holder.imageView.getContext())
                .load((String) pic.url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
