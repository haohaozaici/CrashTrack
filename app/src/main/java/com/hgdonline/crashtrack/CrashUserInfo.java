package com.hgdonline.crashtrack;

/**
 * Created by haohao on 2017/8/23.
 */

public class CrashUserInfo {

  //用户信息
  private String mac_no;      //机器号
  private String merchant_no;      //	商户号
  private String merchant_name;      //	商户名
  private String terminal_no;      //	终端号
  private String user_id;      //	用户ID
  private String phone;      //	手机号
  private String email;      //	邮箱

  //oem
  private String is_oem;      //商户是否为oem，0不是，1是
  private String oem_name;      //oem名称

  //环境信息
  private String sysver;      //	系统版本号
  private String sdkver;      //	sdk版本号
  private String versionName;      //	apk版本信息
  private String versionCode;      //	apk版本信息
  private String push;      //	推送配置

  //设备信息


}
