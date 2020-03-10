package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SendMseActivity extends AppCompatActivity implements View.OnClickListener {

    private Button send_btn = null ;
    private EditText msg_et = null ;
    private ListView msg_lv = null ;

    private  Date day            = null ;
    private  SimpleDateFormat df = null ;

    private List<SendMessage> list_msg = null ;
    private MessageAdapter adapter     = null ;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_main);

        initView();
        initData();
    }

    private void initData(){
        list_msg = new ArrayList<>() ;
        adapter = new MessageAdapter(list_msg ,this) ;
        msg_lv.setAdapter(adapter);
    }

    private void initView(){
        send_btn = findViewById(R.id.btn_send_action) ;
        send_btn.setOnClickListener(this);
        msg_et   = findViewById(R.id.et_msg) ;
        msg_lv   = findViewById(R.id.lv_msg_main) ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_action :
                if(!TextUtils.isEmpty(msg_et.getText().toString())){
                    list_msg.add(getAMessage(msg_et.getText().toString())) ;
                    adapter.notifyDataSetChanged();
                    msg_lv.setSelection(list_msg.size());
                    msg_et.setText("");
                } else {
                    Toast.makeText(this,R.string.send_et_hint ,Toast.LENGTH_LONG).show();
                }


                break ;
        }
    }

    private SendMessage getAMessage(String text){
        SendMessage sendMessage = new SendMessage() ;
        sendMessage.set_id(UUID.randomUUID().toString());
        sendMessage.setTime(getMsgTime());
        sendMessage.setContent(text);
        sendMessage.setMySending(new Random().nextBoolean());
        return sendMessage ;

    }

    private String getMsgTime(){
        day = new Date();


        if(df == null){
            df = new SimpleDateFormat("HH:mm:ss");
        }

        return  df.format(day);
    }
}
