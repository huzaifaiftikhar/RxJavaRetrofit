package org.huzaifa.rxjavaretrofit;

/**
 * Created by Huzaifa on 23-Jun-17.
 */


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.huzaifa.rxjavaretrofit.R;
import org.huzaifa.rxjavaretrofit.Country;

import java.util.ArrayList;

import static org.huzaifa.rxjavaretrofit.R.id.country_flag;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private ArrayList<Country> worldpopulation;
    private Context context;

    public DataAdapter(Context context,ArrayList<Country> worldpopulation) {
        this.worldpopulation = worldpopulation;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.country_name.setText(worldpopulation.get(i).getName());
        viewHolder.country_rank.setText(worldpopulation.get(i).getRank());
        viewHolder.country_population.setText(worldpopulation.get(i).getPopulation());
        Glide.with(context)
                .load(worldpopulation.get(i).getImageURL())
                .override(375, 249)
                .into(viewHolder.country_flag);
        /*Glide.with(holder.imageView.getContext()).load(image.getImageURL()).into(holder.imageView);
        holder.textView.setText(image.getCountry());*/

        viewHolder.country_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewHolder.country_flag.getContext(), FullScreenImage.class);
                intent.putExtra(Country.IMAGE_URL, worldpopulation.get(i).getImageURL());
                viewHolder.country_flag.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return worldpopulation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView country_name,country_rank,country_population;
        private ImageView country_flag;
        public ViewHolder(View view) {
            super(view);

            country_name = (TextView)view.findViewById(R.id.country_name);
            country_population = (TextView)view.findViewById(R.id.country_population);
            country_rank = (TextView)view.findViewById(R.id.country_rank);
            country_flag = (ImageView) view.findViewById(R.id.country_flag);
        }
    }
}
