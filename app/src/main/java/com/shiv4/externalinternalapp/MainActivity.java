package com.shiv4.externalinternalapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDescription;
    ImageView ivMood,ivPhone,ivWeb,ivMap;
    Button btnCreate;
    final int CREEATE_CONTACT=1;
    String name="",phone="",web="",map="",mood="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription=findViewById(R.id.tvDescription);
        ivMood=findViewById(R.id.ivMood);
        ivPhone=findViewById(R.id.ivPhone);
        ivWeb=findViewById(R.id.ivWeb);
        ivMap=findViewById(R.id.ivMap);
        btnCreate=findViewById(R.id.btnCreate);

        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(MainActivity.this,com.shiv4.externalinternalapp.CreateContact.class);
               startActivityForResult(intent,CREEATE_CONTACT);

            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);

            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+web));
                startActivity(intent);

            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+map));
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CREEATE_CONTACT)
        {

            if(resultCode==RESULT_OK)
            {
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);

                name=data.getStringExtra("name");
                phone=data.getStringExtra("phone");
                web=data.getStringExtra("web");
                map=data.getStringExtra("map");
                mood=data.getStringExtra("mood");

                if(mood.equals("profile"))
                {
                    ivMood.setImageResource(R.drawable.face3);

                }
                else if (mood.equals("profileand"))
                {
                    ivMood.setImageResource(R.drawable.face2);
                }
                else
                {
                    ivMood.setImageResource(R.drawable.face1);
                }


            }


        }
    }
}