package home.misha.testnew;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public final int KILKIST_STORINOK=5;

    MyTimerTasck myTimerTasck=new MyTimerTasck();
    Timer timer=new Timer();

    TextView timer_text;
    Boolean Start=false;
    int time=0;
    Button button;
   List<View> peges=new ArrayList<View>();
    ArrayList<Pytannja> list=new ArrayList<Pytannja>();
    MyAdapter myAdapter;
    ListView listView;
    LayoutInflater layoutInflater;
    View pege;
    ViewPager viewPager;
    Pytannja pytannja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer.schedule(myTimerTasck, 0, 1000);
        timer_text=(TextView)findViewById(R.id.text_timer);
        button=(Button)findViewById(R.id.button);

        viewPager = (ViewPager)findViewById(R.id.vievPage);

        layoutInflater=LayoutInflater.from(this);
        for (int i=0; i<KILKIST_STORINOK; i++){ add_page(i);}
        PagerAdapter pagerAdapter=new PegerAdapter(peges);
        viewPager.setAdapter(pagerAdapter);








    }

    public  void add_page(int nomer_page){
        pege=layoutInflater.inflate(R.layout.ekran, null);
        myAdapter=initializise(nomer_page);
        listView=(ListView)pege.findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        peges.add(pege);

    }

    public MyAdapter initializise(int id){
        MyAdapter ma;
        switch (id){
            case 0: {
                ma=newAdapter(R.array.p1, R.array.p1_vidpovidi, R.array.p1_dodatok,id);
                break;
            }

            case 1: {
                ma=newAdapter(R.array.p2, R.array.p2_vidpovidi, R.array.p2_dodatok,id);
                break;
            }

            case 2: {
                ma=newAdapter(R.array.p1, R.array.p1_vidpovidi, R.array.p1_dodatok,id);
                break;
            }

            case 3: {
                ma=newAdapter(R.array.p1, R.array.p1_vidpovidi, R.array.p1_dodatok,id);
                break;
            }
            default:    ma=newAdapter(R.array.p1, R.array.p1_vidpovidi, R.array.p1_dodatok,id);



        };

       return ma;


    }


    MyAdapter newAdapter(int res1, int res2, int res3, int id){
      // Pytannja pytannja;
        ArrayList<Pytannja> ar=new ArrayList<Pytannja>();
        int i=0;

        String[] name_pyt=getResources().getStringArray(res1);
        String[] vidpovid=getResources().getStringArray(res2);
        String[] dodatok=getResources().getStringArray(res3);

        for (String s : name_pyt) {
            String []  vidpovidi_string_arr=stringToArray(vidpovid[i]);
            int kilkist_vidpovid=vidpovidi_string_arr.length/2;
            String []  vidpovidi_arr=new String[kilkist_vidpovid+1];
            int []  vaga_vidpovidi_arr=new int[kilkist_vidpovid];
            for (int j=0; j<kilkist_vidpovid;j++){
                vidpovidi_arr[j]=vidpovidi_string_arr[2*j+1] ;
                vaga_vidpovidi_arr[j]=Integer.parseInt(vidpovidi_string_arr[2*(j+1)]) ;
            }
            vidpovidi_arr[kilkist_vidpovid]=""; //заглушка для RadioButon;

            pytannja=new Pytannja(s, vidpovidi_arr, vaga_vidpovidi_arr, dodatok[i], id);
            ar.add(pytannja);
            i++;
        }
        return new MyAdapter(this, ar);

    }


    public  String[]stringToArray (String s){
        char[] s_char=s.toCharArray();
        int kk=0;
        for (char ch: s_char) {
            if (ch=='*') kk++;
        }

        int[] index=new int[kk];
        index[0]=s.indexOf('*');

        String[] s_ar=new String[kk];
        for (int i=1; i<kk;i++){
            index[i]=s.indexOf('*',index[i-1]+1);
            s_ar[i]=new String(s_char,index[i-1]+1,index[i]-index[i-1]-1);
        }
        return s_ar;

    }

   public   void onClick(View v) {
        if (Start) { ((Button)v).setText("Старт");
        viewPager.setVisibility(View.INVISIBLE);
        }

        else { ((Button)v).setText("Пауза");
            viewPager.setVisibility(View.VISIBLE);
        }
        Start=!Start;

    }



    public class MyTimerTasck extends TimerTask {

        public void run() {
          //  long millis = System.currentTimeMillis() - startTime;

       //     int seconds = (int) (millis / 1000);
           if(Start) {
               time++;
               final int minutes = time / 60;
               final int seconds1 = time % 60;
               runOnUiThread(new Runnable() {

                   @Override
                   public void run() {
                       timer_text.setText(String.format("%d:%02d", minutes, seconds1));

                   }
               });

           }

        }
}



}
