package com.indian.uttara.main.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.indian.uttara.R;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public class MainListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public MainListAdapter(Context context, String[] values) {
        super(context, R.layout.main_services_list_row, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.main_services_list_row, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.mainServiceImage);

        // Change icon based on name
        String s = values[position];

        if (s.equals("Electrical")) {
            imageView.setImageResource(R.drawable.electrical);
        } else if (s.equals("Plumbing")) {
            imageView.setImageResource(R.drawable.plumbing);
        } else if (s.equals("Materials")) {
            imageView.setImageResource(R.drawable.materials);
        }

        return rowView;
    }
}
