package com.example.geedha.placement_with_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity<SQLiteHelper> extends AppCompatActivity {
    Button LogInButton, RegisterButton ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogInButton = (Button)findViewById(R.id.buttonLogin);


        RegisterButton = (Button)findViewById(R.id.buttonRegister);

        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);

       // sqLiteHelper = new SQLiteHelper(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            String Emailholder = Email.getText().toString();
            String Passwordholder = Password.getText().toString();
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                ///CheckEditTextStatus();

                // Calling login method.
                //LoginFunction();
                String[] data = {"apple","mango"};
                String[] password = {"appale","orange"};
                GetallStudents task = new GetallStudents();
                Getpassword pass = new Getpassword();
                Getcgpa cgpa = new Getcgpa();
                int posemail = 0;
                int pospass = 0;

                try {
                    List<Student> getcgpa = Arrays.asList(cgpa.execute().get());
                    Student[] datacgpa = getcgpa.toArray(new Student[0]);
                    List<String> get = task.execute().get();
                    data = get.toArray(new  String[0]);
                    List<String> get2 = pass.execute().get();
                    password = get2.toArray(new String[0]);
                    boolean emailcheck = Arrays.asList(data).contains(Email.getText().toString());
                    boolean passcheck = Arrays.asList(password).contains(Password.getText().toString());
                    Log.d("post","params:"+emailcheck);

                    Log.d("post","params:"+passcheck);
                    if( TextUtils.isEmpty(Email.getText().toString()) || TextUtils.isEmpty(Password.getText().toString())){
                        Toast.makeText(MainActivity.this,"Please Fill the Email and Password",Toast.LENGTH_LONG).show();

                    }
                    else {

                        if(emailcheck && passcheck){
                            posemail =Arrays.asList(data).indexOf(Email.getText().toString());
                            pospass = Arrays.asList(password).indexOf(Password.getText().toString());
                            if(posemail == pospass){
                                Intent intent = new Intent(MainActivity.this, ViewingActivity.class);
                                String sendcgpa = Float.toString(datacgpa[posemail].getCgpa());
                                intent.putExtra("studentcgpa",sendcgpa );
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this,"your password is wrong",Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Your password or email is wrong",Toast.LENGTH_LONG).show();
                        }
                    }






                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        // Adding click listener to register button.
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

    }

    // Login function starts from here.
   /* public void LoginFunction(){

        if(EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            //sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            ///cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    //TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(MainActivity.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {

            Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();

            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(UserEmail, EmailHolder);

            startActivity(intent);


        }
        else {

            Toast.makeText(MainActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND" ;*/

    }

