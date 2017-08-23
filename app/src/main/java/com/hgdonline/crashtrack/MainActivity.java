package com.hgdonline.crashtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.test_crash)
  Button test_crash;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    test_crash.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        CrashReport.testJavaCrash();

      }
    });

  }
}
