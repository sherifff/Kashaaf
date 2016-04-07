package test6.amr.com.test6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MAdapter extends BaseAdapter {

    Context context;
    String[] name;
    String[] date;
    String[] desc;
    int[] image;
    String[]names={"Sherif Mohi","Amr Mohamed","Ahmed Aly","Google"};
    private static LayoutInflater inflater = null;

    public MAdapter(Context context, String[] name, String[] date,String[]desc, int[] image) {
        this.context = context;
        this.name = name;
        this.date = date;
        this.desc=desc;
        this.image = image;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return name.length;
    }
    @Override
    public Object getItem(int position) {
        return name[position];
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        TextView text1 = (TextView) vi.findViewById(R.id.text1);
        TextView naaame= (TextView) vi.findViewById(R.id.userName);
        naaame.setText(names[position]);
        ImageView img= (ImageView) vi.findViewById(R.id.image);
        img.setImageResource(image[position]);
        text1.setText(name[position]);
        SpannableString content = new SpannableString(name[position]);
        content.setSpan(new UnderlineSpan(), 0, name[position].length(), 0);
        text1.setText(content);
        TextView text3 = (TextView) vi.findViewById(R.id.data);
        TextView name= (TextView) vi.findViewById(R.id.userName);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(context, MainActivityprofile.class);
                context.startActivity(t);
            }
        });
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/DroidKufi-Regular.ttf");
        Typeface t2 = Typeface.createFromAsset(context.getAssets(), "fonts/mobily.ttf");
        text1.setTypeface(tf);
        text3.setTypeface(t2);
        TextView text2 = (TextView) vi.findViewById(R.id.text2);
//
        if(desc[position].length()>140){
            String output=desc[position].substring(0,140);
            output=output+"...";
            text3.setText(output);
        }else{
            text3.setText(desc[position]);
        }
      //  text3.setText(desc[position]);
        text2.setText(date[position]);
        ImageView im = (ImageView)vi.findViewById(R.id.image);
        im.setImageResource(image[position]);
        return vi;
    }
}