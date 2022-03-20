package com.example.permissionsafer.Adapter;

import android.graphics.drawable.Drawable;

public class Application {
    private int IconId;
    private String Name;
    private String PackageName;

    public Application(int Icon, String Name, String PackageName){
        this.IconId=IconId;
        this.Name=Name;
        this.PackageName=PackageName;
    }

    public int getIconId(){
        return IconId;
    }

     public String getName(){
        return Name;
    }

    public String getPackageName(){
        return PackageName;
    }
}
