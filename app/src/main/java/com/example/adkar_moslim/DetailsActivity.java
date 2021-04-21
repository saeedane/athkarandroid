package com.example.adkar_moslim;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {
    int current_index = 0;
    TextView tv_title,tv_count;
    ImageView imageNext,imagePrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv_title = findViewById(R.id.tv_title);
        tv_count = findViewById(R.id.title_count);
        imageNext = findViewById(R.id.imageButton);
        imagePrev = findViewById(R.id.button_prev);
        showAthkarMoslim();



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void next_citation_morning(View view) {
        try {
            if(current_index < 18 ){
                save_current_index();
                current_index++;
                showAthkarMoslim();


                Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_right);
                imagePrev.setBackground(image);


            }else{

                Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_left_disabled);
                imageNext.setBackground(image);

            }
        }catch (Exception e){e.printStackTrace();}



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void prev_evening_prayers(View view) {
    try {
        if(current_index > 0){
            save_current_index();
            current_index--;
            showAthkarMoslim();
            Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_left);
            imageNext.setBackground(image);



        }else{

            Drawable image = getResources().getDrawable(R.drawable.rounded_rectangle_right_disabled);
            imagePrev.setBackground(image);
        }

    }catch (Exception e){e.getMessage();}



    }
    public void save_current_index(){

        SharedPreferences preferences = getSharedPreferences("app_key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("current_index_save",current_index);
        editor.apply();



    }

    private  void showAthkarMoslim(){
        int position = getIntent().getIntExtra("position",0);
        SharedPreferences preferences = getSharedPreferences("app_key",Context.MODE_PRIVATE);
        int get_current_index = preferences.getInt("current_index_save",0);

        if(position == 0){

            String[] athkar_sabah = getResources().getStringArray(R.array.athkar_sabah);
            String[] athkar_count = getResources().getStringArray(R.array.athkar_count);
            tv_title.setText(athkar_sabah[get_current_index]);
            tv_count.setText(athkar_count[get_current_index]);


        }else if(position == 1){
            String[]  athkar_count = getResources().getStringArray(R.array.athkar_count);
            String[] athkar_masah = getResources().getStringArray(R.array.athkar_masah);
            tv_count.setText(athkar_count[get_current_index]);
            tv_title.setText(athkar_masah[get_current_index]);
        }else{
            String[] athkar = getResources().getStringArray(R.array.athkar);
            tv_title.setText(athkar[get_current_index]);
            tv_count.setText("أدعية ");


        }


    }


    public void button_back_activity(View view) {


        onBackPressed();




    }



    public void image_share_question(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,tv_title.getText().toString());
        String message = getResources().getString(R.string.text_share_title);
        startActivity(Intent.createChooser(intent,message));


    }




}
