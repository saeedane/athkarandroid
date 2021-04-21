package com.example.adkar_moslim.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adkar_moslim.DetailsActivity;
import com.example.adkar_moslim.Model.Athkar;
import com.example.adkar_moslim.R;
import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.viewHolder>  {
    Context context;
    ArrayList<Athkar> mList;

    public AdapterRecycler(Context context, ArrayList<Athkar> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_card_recycler, parent, false);


        return new viewHolder(view);


    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        Athkar item = mList.get(position);
        holder.tv_title.setText(item.getTitle());
        holder.image.setImageResource(item.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailsActivity.class);

                intent.putExtra("position",position);



                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv_title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.title);
        }
    }
}
