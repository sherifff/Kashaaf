package test6.amr.com.test6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class ReviewsPopUp extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        Bundle bundle = getIntent().getExtras();

        String name_1 = bundle.getString("name");
        String date_1 = bundle.getString("date");
        String description_1 = bundle.getString("description");
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/DroidKufi-Regular.ttf");
        Typeface t2 = Typeface.createFromAsset(getAssets(), "fonts/mobily.ttf");
        TextView name = (TextView)findViewById(R.id.Text1);
        name.setText(name_1);
        TextView date = (TextView)findViewById(R.id.Text2);
        date.setText(date_1);
        TextView description = (TextView)findViewById(R.id.Text3);
        description.setText(description_1);
        name.setTypeface(tf);
        description.setTypeface(t2);
        DisplayMetrics dis= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dis);
        int width=dis.widthPixels;
        int hi=dis.heightPixels;
        getWindow().setLayout((int) (width * .85), (int) (hi * .85));
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(ReviewsPopUp.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}