package com.example.geedha.placement_with_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.Pair;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewingActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextView a ;
        a = (TextView)findViewById(R.id.label);

        Placement[] data = new Placement[0];
        //Placement[] newdata = new Placement[0];

        String[] name = {"apple","mango"};
        String[] newdata = new String[0];
        Getnames task = new Getnames();
        GetDomain pass = new GetDomain();
        int posemail = 0;
        String[] arr = {"",""};
        ArrayList<ArrayList<String> > aList =
                new ArrayList<ArrayList<String> >();
        try {
            List<Placement> get = Arrays.asList(task.execute().get());
            data = get.toArray(new Placement[0]);
            List<String> get2 = pass.execute().get();
            name = get2.toArray(new String[0]);
            posemail =Arrays.asList(name).indexOf("Coimbatore");
            //List list = java.util.Arrays.asList(data[posemail]);
            ArrayList<String> a1 = new ArrayList<String>();
           /* a1.add("Name");
            a1.add(data[posemail].getName());
            aList.add(a1);
            ArrayList<String> a2 = new ArrayList<String>();
            a2.add("domain");
            a2.add(data[posemail].getDomain());
            aList.add(a2);
            ArrayList<String> a3 = new ArrayList<String>();
            a3.add("location");
            a3.add(data[posemail].getLocation());
            aList.add(a3);
            ArrayList<String> a4 = new ArrayList<String>();
            a4.add("Eligibility");
            a4.add(Float.toString(data[posemail].getEligibility()));
            aList.add(a4);
            ArrayList<String> a5 = new ArrayList<String>();
            a5.add("Number od rounds");
            a5.add(Integer.toString(data[posemail].getNoofrounds()));
            aList.add(a5);
            ArrayList<String> a6 = new ArrayList<String>();
            a6.add("Starting salary");
            a6.add(data[posemail].getStartingsalary());
             newdata = new String[aList.size()];
        for (int i=0; i < aList.size();i++){
                newdata[i] = aList.get(i).toString();
            }*/
         /*  String eli = Float.toString(data[posemail].getEligibility()) ;
           ArrayList <Pair<String,String>> l =
                    new ArrayList <Pair <String,String> > ();
            l.add(new Pair<String, String>("Name : ",data[posemail].getName()));
            l.add(new Pair<String, String>("Location",data[posemail].getLocation()));
            l.add(new Pair<String, String>("Domain: ",data[posemail].getDomain()));
            l.add(new Pair<String, String>("Elgibility",eli));
            l.add(new Pair<String, String>("Number of rounds :",Integer.toString(data[posemail].getNoofrounds())));
            l.add(new Pair<String, String>("Starting salary",data[posemail].getStartingsalary()));
            arr = new String[l.size()];
            for (int i=0; i < l.size();i++){
                arr[i] = l.get(i).toString().replaceAll("}", " ");;
            }*/

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.activity_all,arr);
        ListView listView = (ListView)findViewById(R.id.stulist);
        listView.setAdapter(arrayAdapter);*/
        Intent intent = getIntent();

        String studentcgpa = intent.getStringExtra("studentcgpa");
        float f = Float.parseFloat(studentcgpa);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        String contentdisplay = "";
        for(Placement pl:data)
        {
            if(f>=pl.getEligibility()) {
                SpannableString content = new SpannableString("Name of the content: " + pl.getName() + "\n");
                content.setSpan(new ForegroundColorSpan(Color.BLACK), 0, content.length(), 0);
                builder.append(content);
                content = new SpannableString("Domain of the company: " + pl.getDomain() + "\n");
                content.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0, content.length(), 0);
                builder.append(content);
                content = new SpannableString("Location of the company: " + pl.getLocation() + "\n");
                content.setSpan(new ForegroundColorSpan(Color.CYAN), 0, content.length(), 0);
                builder.append(content);
                content = new SpannableString("Starting salary: " + pl.getStartingsalary() + "\n");
                content.setSpan(new ForegroundColorSpan(Color.BLUE), 0, content.length(), 0);
                builder.append(content);
                content = new SpannableString("Eligibility needed: " + pl.getEligibility() + "\n");
                content.setSpan(new ForegroundColorSpan(Color.BLUE), 0, content.length(), 0);
                builder.append(content);
                content = new SpannableString("Getting of rounds: " + pl.getNoofrounds() + "\n" + "\n" + "\n");
                content.setSpan(new ForegroundColorSpan(Color.BLUE), 0, content.length(), 0);
                builder.append(content);
            }

        }

        a.setText(builder);
    }


    }


