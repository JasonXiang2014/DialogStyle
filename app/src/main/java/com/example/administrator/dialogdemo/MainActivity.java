package com.example.administrator.dialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(getActionBar() != null){
            getActionBar().hide();
        }

        setContentView(R.layout.activity_main);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new CustomDialog(MainActivity.this, R.style.DialogTest, R.layout.test);
//                dialog = new CustomDialog(MainActivity.this, R.layout.test);
//                dialog = new CustomDialog(MainActivity.this, R.style.Dialog, R.layout.dialog_sales_promotion);
                dialog.show();
            }
        });

        WindowManager wm = this.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        Log.e("TAG","width = " + width + " height = " + height);
    }

}
