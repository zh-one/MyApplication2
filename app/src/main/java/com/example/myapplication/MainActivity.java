package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName() ;

    private TextView tv_name = null ;
    private ListView lv_student = null ;
    private List<Student> list_student = null ;
    private StudentApdater adapter = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initData(){
        list_student = new ArrayList<>() ;
        adapter = new StudentApdater(list_student ,this) ;
        for(int i = 0 ; i < 10 ; i ++){
            Student stu = new Student();
            stu.setAge(20 + i);
            stu.setName("zhanglian" + i);
            Log.e("zhanglian" ,"the name is " + i) ;
            list_student.add(stu) ;
        }
    }

    private void initView(){
        lv_student = findViewById(R.id.lv_name) ;
        lv_student.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        Toast.makeText(this,"it is one" ,Toast.LENGTH_LONG).show();
        Log.e(TAG ,"it is onStart aa");
        super.onStart();
    }
}
