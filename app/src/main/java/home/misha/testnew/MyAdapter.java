package home.misha.testnew;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Misha on 15.04.2016.
 */
public class MyAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Pytannja> objects;
    final int[] resRadio={R.id.radioButton1, R.id.radioButton2, R.id.radioButton3, R.id.radioButton4, R.id.radioButton5, R.id.radioButton6, R.id.radioButton7, R.id.radioButton8, R.id.radioButton9, R.id.radioButton10,   };


    MyAdapter(Context context, ArrayList<Pytannja> pytannjas){

        ctx=context;
        objects=pytannjas;
        lInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return (objects.size()+1);
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;
        if(position<(getCount()-1)) {

                view = lInflater.inflate(R.layout.list, parent, false);

            Pytannja pytannja = getPytannja(position);
            ((TextView) view.findViewById(R.id.text_nameList)).setText(pytannja.getName());
            String[] vidpovidi_s = pytannja.getVidpovidi();
            RadioButton[] radioButton=new RadioButton[10];
            for (int i=0; i<10; i++){
                if (vidpovidi_s[i]!="") {
                    radioButton[i]=((RadioButton) view.findViewById(resRadio[i]));
                    radioButton[i].setText(vidpovidi_s[i]);
                    radioButton[i].setTag(position);
                    radioButton[i].setOnClickListener(onClickRadio);
                    radioButton[i].setVisibility(View.VISIBLE);
                    if(pytannja.getVybir()==(i+1)) radioButton[i].setChecked(true);
                } else {break;}

            }
         }
        else {
            final Button btnNew = new Button(ctx);
            btnNew.setText("Перевірити результат");
            btnNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sum=0;
                    for (Pytannja pyt: objects ) {
                    if(pyt.getVybir()>0) sum+=pyt.getVaga_vidpovidiId(pyt.getVybir()-1);
                    }

                    btnNew.setText("Твій результат="+sum);
                }
            });
            view=btnNew;
        }
          return view;
    }


    View.OnClickListener onClickRadio=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioButton1: {
                (getPytannja((Integer)v.getTag())).setVybir(1);
                break;}
            case R.id.radioButton2: {
                    (getPytannja((Integer)v.getTag())).setVybir(2);
                    break;}
            case R.id.radioButton3: {
                    (getPytannja((Integer)v.getTag())).setVybir(3);
                    break;}
            case R.id.radioButton4: {
                    (getPytannja((Integer)v.getTag())).setVybir(4);
                    break;}
            case R.id.radioButton5: {
                (getPytannja((Integer)v.getTag())).setVybir(5);
                break;}
            case R.id.radioButton6: {
                (getPytannja((Integer)v.getTag())).setVybir(6);
                break;}
            case R.id.radioButton7: {
                (getPytannja((Integer)v.getTag())).setVybir(7);
                break;}
            case R.id.radioButton8: {
                (getPytannja((Integer)v.getTag())).setVybir(8);
                break;}
            case R.id.radioButton9: {
                (getPytannja((Integer)v.getTag())).setVybir(9);
                break;}
            case R.id.radioButton10: {
                (getPytannja((Integer)v.getTag())).setVybir(10);
                break;}


        }

        }
    };


    Pytannja getPytannja(int Id){
        return (Pytannja)getItem(Id);
    }



}
