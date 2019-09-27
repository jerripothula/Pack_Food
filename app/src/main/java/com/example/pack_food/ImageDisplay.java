package com.example.pack_food;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ImageDisplay extends AppCompatActivity {

    Food f;
    int imageId=0;
   
    private EditText nameText,locationText,KeywordText,dateText,emailText;
    private RatingBar rb;
    private ToggleButton toggleButton;
    private String name,email;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        f= getIntent().getParcelableExtra("SEND_FOOD");

        Log.i("Intent","Intent received");
        imageId = getIntent().getIntExtra("IMAGE_ID", 0);

        Drawable imag = getResources().getDrawable(imageId, getBaseContext().getTheme());
        ImageView ivImage = (ImageView)findViewById(R.id.image);
        ivImage.setImageDrawable(imag);

        Log.i("Intent","Image  set");


        nameText = (EditText) findViewById(R.id.nameText);
        locationText = (EditText) findViewById(R.id.locationText);
        KeywordText = (EditText) findViewById(R.id.KeywordText);
        dateText = (EditText) findViewById(R.id.dateText);
        emailText = (EditText) findViewById(R.id.emailText);

        rb = (RatingBar) findViewById(R.id.ratingBar);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);


        nameText.setText(f.getName());
        locationText.setText(f.getLocation());
        KeywordText.setText(f.getKeywords());
        dateText.setText((CharSequence) f.getD());
        toggleButton.setChecked(f.getShare());
        emailText.setText(f.getEmail());
        rb.setRating(f.getVal());

    }


    public void saveClick(View v) {


        if (nameCheck() && emailCheck()) {


            nameText = (EditText) findViewById(R.id.nameText);
            f.setName(nameText.getText().toString());

            locationText = (EditText) findViewById(R.id.locationText);
            f.setLocation(locationText.getText().toString());

            KeywordText = (EditText) findViewById(R.id.KeywordText);
            f.setKeywords(KeywordText.getText().toString());

            dateText = (EditText) findViewById(R.id.dateText);
            f.setD(dateText.getText().toString());

            emailText = (EditText) findViewById(R.id.emailText);
            f.setEmail(emailText.getText().toString().trim());

            f.setVal(rb.getRating());

            toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
            f.setShare(toggleButton.isChecked());


            Intent intent = new Intent();
            intent.putExtra("RECEIVE_FOOD", f);
            intent.putExtra("IMAGE", imageId);
            setResult(Activity.RESULT_OK, intent);
            Log.i("Intent","displayImage intent sent");
            Toast.makeText(this,"successfully saved ",Toast.LENGTH_SHORT).show();


        }
    }

        private boolean nameCheck()
        {
            name=nameText.getText().toString().trim();
            if(name.isEmpty())
            {
                nameText.setError("Enter name,can't be empty");
                return false;
             }
            else
                return true;

        }


        private boolean emailCheck()
        {

            email = emailText.getText().toString().trim();

            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (email.isEmpty())
            {
                emailText.setError("This field can't be empty");
                return false;

            }
            else if(!(email.matches(emailPattern)))
            {
                emailText.setError("Enter Valid Email Id");
                return false;
            }
            else
                return true;

        }



}
