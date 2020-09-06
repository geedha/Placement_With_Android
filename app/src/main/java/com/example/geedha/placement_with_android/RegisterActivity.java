package com.example.geedha.placement_with_android;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class RegisterActivity extends AppCompatActivity {
    EditText Email, Password, Name,Cgpa,Phonenumber ;
    Button Register;
    //String NameHolder, EmailHolder, PasswordHolder;
    //String CgpaHolder,PhonenumberHolder;
    //Boolean EditTextEmptyHolder;
    //Cursor cursor;
    //String F_Result = "Not_Found";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Register = (Button)findViewById(R.id.buttonRegister);
        Name = (EditText)findViewById(R.id.editName);
        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);

        Cgpa = (EditText)findViewById(R.id.editCgpa);
        Phonenumber = (EditText)findViewById(R.id.editPhonenumber);


        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AddStudentTask task = new AddStudentTask();
                task.execute(Name.getText().toString(),Email.getText().toString(),Password.getText().toString(),Cgpa.getText().toString(),Phonenumber.getText().toString());
                Log.d("post","posted");
                Toast.makeText(getApplicationContext(),"Doneee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }



}
