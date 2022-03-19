package com.example.permissionsafer.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.example.permissionsafer.MainActivity;
import com.example.permissionsafer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class main_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        BottomNavigationView bottomNavigationView=findViewById(R.id.mainpagenavigation);
        NavHostFragment navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        NavController navController =navHostFragment.getNavController();
        AppBarConfiguration configuration=new AppBarConfiguration.Builder(R.id.appFragment,R.id.downloadFragment,R.id.manageFragment).build();
        NavigationUI.setupActionBarWithNavController(this,navController,configuration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }


    @Override
    protected void onDestroy() {
        //我们自己的方法
        Toast.makeText(this, "退出用户行为监测系统", Toast.LENGTH_SHORT).show();
        MainActivity.instance.finish();
        super.onDestroy();
    }
}