package com.example.AnnotationsTest;

import android.app.Activity;
import android.widget.Button;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Part of the With Buddies™ Platform
 * © 2012 Scopely, Inc.
 */
@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

    private MyActivity activity;
    private Button helloWorldButton;

    @Before
    public void setUp() throws Exception {
        activity = new MyActivity_();
        activity.onCreate(null);
        helloWorldButton = (Button) activity.findViewById(R.id.helloWorldButton);
    }

    @Test
    public void shouldHaveProperAppName() throws Exception {
        String appName = new MyActivity_().getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("AnnotationsTest"));
    }

    @Test
    public void testHelloWorldButtonTextChange() throws Exception {
        helloWorldButton.performClick();
        assertThat("Button should say Clicked", helloWorldButton.getText().toString(), equalTo("Clicked"));
    }

    @Test
    public void testHelloWorldButtonDisabled() throws Exception {
        helloWorldButton.performClick();
        assertThat("Button should be disabled", helloWorldButton.isEnabled(), equalTo(false));
    }
}
