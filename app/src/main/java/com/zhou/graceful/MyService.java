package com.zhou.graceful;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.zhou.graceful.consts.PermissionRequestCodeConst;
import com.zhou.graceful.tools.ToastUtil;
import com.zhou.zpermission.annotation.PermissionDenied;
import com.zhou.zpermission.annotation.PermissionDeniedForever;
import com.zhou.zpermission.annotation.PermissionNeed;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        getLocation();
        return super.onStartCommand(intent, flags, startId);
    }

    @PermissionNeed(
            permissions = {Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR},
            requestCode = PermissionRequestCodeConst.REQUEST_CODE_LOCATION)
    private void getLocation() {
        ToastUtil.showToast(this, "Service:权限被已申请成功");
    }

    /**
     * 这里写的要特别注意，denied方法，必须是带有一个int参数的方法，下面的也一样
     *
     * @param requestCode
     */
    @PermissionDenied
    private void denied(int requestCode) {
        ToastUtil.showToast(this, "Service:权限被拒绝");
    }

    @PermissionDeniedForever
    private void deniedForever(int requestCode) {
        ToastUtil.showToast(this, "Service:权限被永久拒绝");
    }
}
