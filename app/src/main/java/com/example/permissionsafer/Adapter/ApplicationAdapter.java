package com.example.permissionsafer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.permissionsafer.R;

import java.util.List;

public class ApplicationAdapter extends ArrayAdapter<Application> {

    private int resourceId;

    public ApplicationAdapter(Context context, int textViewResourceId, List<Application> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Application application=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView AppIcon=(ImageView) view.findViewById(R.id.app_icon);
        TextView AppName=(TextView) view.findViewById(R.id.app_name);
        TextView AppPackage=(TextView) view.findViewById(R.id.app_package);
        AppIcon.setImageResource(application.getIconId());
        AppName.setText(application.getName());
        AppPackage.setText(application.getPackageName());
        return view;
    }
}
