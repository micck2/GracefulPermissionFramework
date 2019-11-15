package com.zhou.graceful;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.zhou.graceful.consts.PermissionRequestCodeConst;
import com.zhou.graceful.tools.ToastUtil;
import com.zhou.zpermission.annotation.PermissionDenied;
import com.zhou.zpermission.annotation.PermissionDeniedForever;
import com.zhou.zpermission.annotation.PermissionNeed;
import com.zhou.zpermission.utils.ApplicationUtil;

/**
 * 普通类
 */
public class LocationUtil {


    @PermissionNeed(
            permissions = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS},
            requestCode = PermissionRequestCodeConst.REQUEST_CODE_LOCATION)
    public void getLocation() {
        Application application = ApplicationUtil.getApplication();
        ToastUtil.showToast(application, "普通Java类：权限已获得");
    }

    /**
     * 这里写的要特别注意，denied方法，必须是带有一个int参数的方法，下面的也一样
     *
     * @param requestCode
     */
    @PermissionDenied
    private void denied(int requestCode) {
        Application application = ApplicationUtil.getApplication();
        ToastUtil.showToast(application, "普通Java类：权限被拒绝");
    }

    @PermissionDeniedForever
    private void deniedForever(int requestCode) {
        Application application = ApplicationUtil.getApplication();
        ToastUtil.showToast(application, "普通Java类：权限被永久拒绝");
    }
}
