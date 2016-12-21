package com.indian.uttara.commonui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.indian.uttara.R;
import com.indian.uttara.apimodel.ServicesRepo;

import java.util.List;

/**
 * Created by Vivekathreya on 9/13/2016.
 */
public class ServicesListRecycleAdapter extends RecyclerView.Adapter<ServicesListRecycleAdapter.DataObjectHolder> {

    private Context mContext;
    private List<ServicesRepo> servicesList;

    public ServicesListRecycleAdapter(Context context, List<ServicesRepo> servicesList) {
        this.servicesList = servicesList;
        this.mContext = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.services_list_row, parent, false);

        return new DataObjectHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        ServicesRepo servicesRepo = servicesList.get(position);
        holder.serviceName.setText(servicesRepo.getServiceName());
        //holder.serviceImage.setImageResource();

    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }


    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView serviceName;
        ImageView serviceImage;

        public DataObjectHolder(View itemView) {
            super(itemView);
            this.serviceImage = (ImageView) itemView.findViewById(R.id.servicesImage);
            this.serviceName = (TextView) itemView.findViewById(R.id.servicesName);
        }
    }


}
