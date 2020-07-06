package com.shiv4.externalinternalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.renderscript.Sampler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener
{
    EditText etPhone,etWeb,etMap;
    AutoCompleteTextView etName;
     ImageView ivProfile,ivProfileAnd,ivProfileHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName=(AutoCompleteTextView) findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etWeb=findViewById(R.id.etWeb);
        etMap=findViewById(R.id.etMap);

        ivProfile=findViewById(R.id.ivProfile);
        ivProfileAnd=findViewById(R.id.ivProfileAnd);
        ivProfileHappy=findViewById(R.id.ivProfileHappy);

        String [] names={"Shiv","shikha","Shreya","Shrey","Sristi","Saif","Shivani","Samraat"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,names);
        etName.setThreshold(1);
        etName.setAdapter(adapter);

       ivProfile.setOnClickListener(this);
       ivProfileAnd.setOnClickListener(this);
       ivProfileHappy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()||etWeb.getText().toString().isEmpty()
        ||etMap.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent=new Intent();
            intent.putExtra("name",etName.getText().toString().trim());
            intent.putExtra("phone",etPhone.getText().toString().trim());
            intent.putExtra("web",etWeb.getText().toString().trim());
            intent.putExtra("name",etMap.getText().toString().trim());

            if(view.getId()==R.id.ivProfile)
            {
                intent.putExtra("mood","profile");
            }
            else if(view.getId()==R.id.ivProfileAnd)
            {
                intent.putExtra("mood","profileand");

            }
            else
            {
                intent.putExtra("mood","profilehappy");
            }

            setResult(RESULT_OK,intent);
            CreateContact.this.finish();

        }


    }
}