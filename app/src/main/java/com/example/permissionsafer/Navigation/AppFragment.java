package com.example.permissionsafer.Navigation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.permissionsafer.Adapter.Application;
import com.example.permissionsafer.Adapter.ApplicationAdapter;
import com.example.permissionsafer.MainActivity;
import com.example.permissionsafer.R;
import com.example.permissionsafer.function.GetAppInfo;
import com.example.permissionsafer.function.GetPermissionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private ApplicationAdapter applicationAdapter;
    private List<Application> applicationList=new ArrayList<>();


    public AppFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppFragment newInstance(String param1, String param2) {
        AppFragment fragment = new AppFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_app, container, false);
        ListView listView=(ListView) view.findViewById(R.id.AppShow);
        List<Application> AppInfo=new GetAppInfo().allPackage(getContext());
        ApplicationAdapter applicationAdapter=new ApplicationAdapter(getActivity(),R.layout.application_item,AppInfo);
        listView.setAdapter(applicationAdapter);

        //View DangerAPP = listView.getChildAt(0);
        //DangerAPP.findViewById(R.id.app_name).setBackgroundColor(Color.GRAY);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Application application=AppInfo.get(position);
                Log.e("listview","click"+position);
                String result=new GetPermissionInfo().permissionInfo(getContext(),application.getPackageName());
                new AlertDialog.Builder(getContext())
                        .setTitle("权限安全性")
                        .setMessage(result)
                        .setNeutralButton("关闭", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        return view;
    }



    @Override
    public void onClick(View v) {

    }
}