package home.misha.testnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textViewName, textViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewName=(TextView)findViewById(R.id.textViewDname);
        textViewText=(TextView)findViewById(R.id.textViewDtext);
        Pytannja pytannja=(Pytannja)getIntent().getParcelableExtra("pytannja");
        textViewName.setText(pytannja.getName());
        textViewText.setText(pytannja.getDetali());


    }
}
