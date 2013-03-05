package com.example.AnnotationsTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.*;

@EActivity(R.layout.main)
public class MyActivity extends Activity {
    private int i;

    @ViewById(R.id.helloWorldButton)
    Button helloWorldButton;

    @ViewById(R.id.nopButton)
    Button nopButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click
    void helloWorldButton() {
        helloWorldButton.setText("Clicked");
        helloWorldButton.setEnabled(false);
    }

    @UiThread
    void sayHello() {
        Toast.makeText(this, "Hello, " + (i++), 100).show();
    }

    @Background
    void sleep() {
        try {
            Thread.sleep(2000);
            sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
