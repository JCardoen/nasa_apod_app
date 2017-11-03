package astropic.com.apod.Viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import astropic.com.apod.R;

/**
 * Created by Joachim on 03/11/2017.
 */

public class PictureViewholder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView authorText;
    public TextView titleText;
    public TextView explanationText;

    public PictureViewholder(View itemView) {
        super(itemView);

        // Create link to the elements of our recyclerview by id
        this.imageView = itemView.findViewById(R.id.iv_pic);
        this.authorText = itemView.findViewById(R.id.iv_author);
        this.titleText = itemView.findViewById(R.id.iv_title);
        this.explanationText = itemView.findViewById(R.id.iv_explanation);
    }
}
