package com.example.pack_food;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {



    private TextView textView1,textView2,textView3,textView4;
    private String name="",location="",keywords="",email="";
    private String date="";

    private boolean share=false;
    private float  val=0.0f;
    public int img;

    ArrayList<Food> food= new ArrayList<Food>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();


    }

    public void setUI()

    {


        food.add(new Food(name,location,keywords,date,share,email,val));
        food.add(new Food(name,location,keywords,date,share,email,val));
        food.add(new Food(name,location,keywords,date,share,email,val));
        food.add(new Food(name,location,keywords,date,share,email,val));

        Log.i("Intent","created");


    }



    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void andraClick(View v) {
        img=1;
        showInfo(R.drawable.butter,food.get(0));
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void chickenClick(View v) {
        img=2;
        showInfo(R.drawable.paradise,food.get(1));
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void paradiseClick(View v) {
        img=3;
        showInfo( R.drawable.chicken,food.get(2));
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void mandiClick(View v) {
        img=4;
        showInfo(R.drawable.chapa,food.get(3));
    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void showInfo(int id,Food f) {

        Intent imageDetailIntent = new Intent(this, ImageDisplay.class);


        imageDetailIntent.putExtra("SEND_FOOD",f);
        imageDetailIntent.putExtra("IMAGE_ID",id);
        Log.i("Intent","Intent not sent");
       startActivityForResult(imageDetailIntent,0);
        Log.i("Intent","Intent  sent");
    }


    @Override
    protected void onActivityResult(int requestcode,int resultCode,Intent intent) {

        if (requestcode == 0) {
            if (resultCode == RESULT_OK) {
                if (intent == null) {
                    Log.i("Intent","Intent empty");
                    Toast.makeText(this, "empty intent", Toast.LENGTH_SHORT).show();
                } else {
                    Food f = intent.getParcelableExtra("RECEIVE_FOOD");
                   int imgId=intent.getIntExtra("IMAGE",0);

                    food.set(img-1,f);



                    Log.i("Intent",f.toString());


                    switch (imgId) {
                        case R.drawable.butter:

                            textView1 = (TextView) findViewById(R.id.textView1);
                            textView1.setText(f.toString());

                              break;

                        case R.drawable.paradise:

                            textView2 = (TextView) findViewById(R.id.textView2);
                            textView2.setText(f.toString());

                             break;

                        case  R.drawable.chicken:

                            textView3 = (TextView) findViewById(R.id.textView3);
                            textView3.setText(f.toString());

                            break;


                        case  R.drawable.chapa:

                            textView4 = (TextView) findViewById(R.id.textView4);
                            textView4.setText(f.toString());
                             break;


                    }
                }
            }else  Log.i("Intent","result not okay");
        }else Log.i("Intent","code does not match");
        super.onActivityResult(requestcode, resultCode, intent);
    }



}
