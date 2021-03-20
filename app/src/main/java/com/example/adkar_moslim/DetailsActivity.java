package com.example.adkar_moslim;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    int current_index = 0;
    TextView tv_title;
    ImageView imageNext,imagePrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv_title = findViewById(R.id.tv_title);
        imageNext = findViewById(R.id.imageButton);
        imagePrev = findViewById(R.id.button_prev);
        showAthkarMoslim();


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void next_citation_morning(View view) {


            if (current_index < 17) {

                current_index++;
                showAthkarMoslim();
                Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_right);
                imagePrev.setBackground(image);



            }else{

                Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_left_disabled);
                imageNext.setBackground(image);
                showAthkarMoslim();


            }


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void prev_evening_prayers(View view) {


        if(current_index > 0){

            current_index--;
            showAthkarMoslim();
            Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_left);
            imageNext.setBackground(image);





        }else{

            Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_right_disabled);
            imagePrev.setBackground(image);
        }
    }


    private  void showAthkarMoslim(){
        int position = getIntent().getIntExtra("position",0);
        if(position == 0){

            String[] athkar_sabah = getResources().getStringArray(R.array.athkar_sabah);
            tv_title.setText(athkar_sabah[current_index]);


        }else if(position == 1){

            String[] athkar_masah = getResources().getStringArray(R.array.athkar_masah);

            tv_title.setText(athkar_masah[current_index]);
        }else{
            tv_title.setText(" ادعية اسلامية تقرب انسان من ربه ");


        }


    }
}
