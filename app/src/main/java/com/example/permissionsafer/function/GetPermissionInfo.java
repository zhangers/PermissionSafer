package com.example.permissionsafer.function;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GetPermissionInfo {

    String show="风险权限:\n";
    List<Boolean> PermissionList=new ArrayList<>();
    boolean result=false;

    public String permissionInfo(Context context,String packagename){
        PermissionList.add(0, hasPermission(context, packagename, "android.permission.CAMERA"));
        PermissionList.add(1, hasPermission(context, packagename, "android.permission.INTERNET"));
        PermissionList.add(2, hasPermission(context, packagename, "android.permission.GET_ACCOUNTS"));
        PermissionList.add(3, hasPermission(context, packagename, "android.permission.ACCESS_FINE_LOCATION"));
        PermissionList.add(4, hasPermission(context, packagename, "android.permission.CALL_PHONE"));
        PermissionList.add(5, hasPermission(context, packagename, "android.permission.SEND_SMS"));
        PermissionList.add(6, hasPermission(context, packagename, "android.permission.READ_EXTERNAL_STORAGE"));
        for (int i=0;i<7;i++){
            if(PermissionList.get(i)){
                result=true;
                if(i == 0){
                    show=show+"该应用申请摄像头权限\n";
                }
                if(i==1){
                    show=show+"该应用申请网络权限\n";
                }
                if(i==2){
                    show=show+"该应用申请通讯录权限\n";
                }
                if(i==3){
                    show=show+"该应用申请定位权限\n";
                }
                if(i==4){
                    show=show+"该应用申请电话呼叫权限\n";
                }
                if(i==5){
                    show=show+"该应用申请发送短信权限\n";
                }
                if(i==6){
                    show=show+"该应用申请存储权限\n";
                }
            }
        }
        Log.e("GetPermi",String.valueOf(result));
        if(!result){
            return "此应用未申请不安全权限";
        }
        else{
            return show;
        }
    }

    private Boolean hasPermission(Context context, String packagename, String permission){
        PackageManager pm= context.getPackageManager();
        return (PackageManager.PERMISSION_GRANTED ==
                pm.checkPermission(permission, packagename));
    }
}
