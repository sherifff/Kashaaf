package test6.amr.com.test6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class View_row extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        Bundle bundle = getIntent().getExtras();

        String name_1 = bundle.getString("name");
        String date_1 = bundle.getString("date");
        String description_1 = bundle.getString("description");

        TextView name = (TextView)findViewById(R.id.Text1);
        name.setText(name_1);
        TextView date = (TextView)findViewById(R.id.Text2);
        date.setText(date_1);
        TextView description = (TextView)findViewById(R.id.Text3);
        description.setText(description_1);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(View_row.this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
