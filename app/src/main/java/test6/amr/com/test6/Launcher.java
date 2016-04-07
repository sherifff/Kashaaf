package test6.amr.com.test6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Launcher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);

//        new Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        Intent i = new Intent(Launcher.this, loginActivity.class);
//                        startActivity(i);
//                        finish();
//                    } }, 1000);
        Intent i = new Intent(Launcher.this, loginActivity.class);
        startActivity(i);
    }
}