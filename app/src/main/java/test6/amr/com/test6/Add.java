package test6.amr.com.test6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Add extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
       // TextView text1 = (TextView) findViewById(R.id.content);
       // TextView text2 = (TextView) findViewById(R.id.exp);
       // Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/DecoType Thuluth.ttf");
       // text1.setTypeface(tf);
       // text2.setTypeface(tf);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"سفر و هجرة", "روتين حكومي", "معرفة و تعلم","فلوس و شغل","اماكن","اكلات شعبية"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Button add = (Button)findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Add.this, MainActivity.class);
                startActivity(i);
                finish();
            }});

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Add.this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
