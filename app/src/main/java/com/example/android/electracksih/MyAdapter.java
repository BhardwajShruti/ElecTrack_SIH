package com.example.android.electracksih;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti on 26-03-2018.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final Context context;

  private int[] mDevice_ID = {1,2,3,4};
    private String[] mDatasetDevice = {"Light1","Light2","Fan","Exhaust"};
    private String[] mDatasetRoom = {"Room1","room2","room3","room4"};
    private String[] mDatasetImage = {"http://images.unsplash.com/photo-1492539161849-b2b18e79c85f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9&s=72acf2383e7e3ebb62fac156088478b1","http://images.unsplash.com/photo-1492539161849-b2b18e79c85f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9&s=72acf2383e7e3ebb62fac156088478b1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTzrs4AraY3eb2T2fyk2u2a2E5BP5GbN9E7lumpkgAn2k4L-yY","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdi9EW3rKicgUUMN_1DKh2kigREepltjLkfDAoEp4wDnKp02LBzQ"};

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView roomHeader;
        public ImageView imageView;
        public CardView cardView;
        public View layout;
        Context context;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.device_name);
            roomHeader = (TextView) v.findViewById(R.id.room_name);
        imageView = (ImageView) v.findViewById(R.id.device_image);
cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }
    public MyAdapter(Context context) {

        this.context = context;

    }
    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(String[] myDataset) {
//        mDataset = myDataset;
//    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.activity_device_card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
URL url;

        holder.txtHeader.setText(mDatasetDevice[position]);
        holder.roomHeader.setText(mDatasetRoom[position]);
        try {
            url =new URL(mDatasetImage[position]);
            Picasso.get()
                    .load(mDatasetImage[position])
                    .placeholder(R.drawable.ic_launcher_background) // optional
                    .error(R.drawable.ic_launcher_foreground)         // optional
                    .into(holder.imageView);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Device_Detail.class);
                int position = holder.getAdapterPosition();
                i.putExtra("id",mDevice_ID[position]);



                context.startActivity(i);

            }
        });
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Device_Detail.class);
                int position = holder.getAdapterPosition();
                i.putExtra("id",mDevice_ID[position]);



                context.startActivity(i);

            }
        });
        holder.roomHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Device_Detail.class);
                int position = holder.getAdapterPosition();
                i.putExtra("id",mDevice_ID[position]);



                context.startActivity(i);

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDatasetDevice.length;
    }
}