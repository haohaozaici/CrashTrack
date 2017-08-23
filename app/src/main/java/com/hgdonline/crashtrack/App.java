package com.hgdonline.crashtrack;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by haohao on 2017/8/22.
 */

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
//        e.printStackTrace();
        Log.i("uncaughtException", "uncaughtException: " + e.getMessage());
//        ProcessPhoenix.triggerRebirth(getApplicationContext());

//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        getApplicationContext().startActivity(intent);
//        android.os.Process.killProcess(android.os.Process.myPid());
      }
    });

    CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);

    strategy.setDeviceID(Build.SERIAL); //机器号

    CrashReport.setIsDevelopmentDevice(getApplicationContext(), BuildConfig.DEBUG);

    strategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() {
      @Override
      public Map<String, String> onCrashHandleStart(int crashType, String errorType,
          String errorMessage, String errorStack) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("Key", "Value");
        return map;
      }


    });

    CrashReport.initCrashReport(getApplicationContext(), "55d87caf1c", BuildConfig.DEBUG, strategy);

    CrashReport.setUserId("haoyuan");

    CrashReport.setAppChannel(this, "haohaozaici");
    CrashReport.setAppVersion(this, BuildConfig.VERSION_CODE + "");

    //配置关键信息
    CrashReport.putUserData(this, "merchantNo", "123456");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
//    CrashReport.putUserData(this, "", "");
    CrashReport.setUserId("haoyuan");

//    CrashReport.postCatchedException(new Throwable());

  }


}
