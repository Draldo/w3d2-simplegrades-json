package com.example.admin.simplegrades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";
    private String jsonString = "{\"students\":[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]}";
    private ListView mlistView;
    private listAdapter mlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        try {
            mlistView = (ListView) findViewById(R.id.main_listview);
            ArrayList<String> array = new ArrayList<String>();

            JSONObject json = new JSONObject(jsonString);
            String arrStr = json.getString("students");
            JSONArray jsonArray = new JSONArray(arrStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                String name = jsonObject.getString("name");
                String grade = jsonObject.getString("grade");
                String age = jsonObject.getString("age");
                array.add("Name: " + name + " Age: " + age + " Grade: " + grade + "-"+grade);
            }

            mlistAdapter = new listAdapter(this,R.layout.list_item,R.id.texview_item, array);
            mlistView.setAdapter(mlistAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
