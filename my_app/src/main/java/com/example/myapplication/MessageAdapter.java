package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends BaseAdapter {

    private List<SendMessage> list_msg = null;
    private Context context = null;

    public MessageAdapter(List<SendMessage> list_msg, Context context) {
        this.list_msg = list_msg;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_msg.size();
    }

    @Override
    public Object getItem(int position) {
        return list_msg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageHolder msg_holder = null ;
        if(convertView == null){
            convertView = View.inflate(context,list_msg.get(position).isMySending()?R.layout.item_msg_mine:R.layout.item_msg_other,null) ;
            msg_holder = new MessageHolder() ;
            msg_holder.tv_content = convertView.findViewById(R.id.tv_msg_content) ;
            msg_holder.tv_time    = convertView.findViewById(R.id.tv_msg_time) ;
            convertView.setTag(msg_holder);
        } else {
            msg_holder = (MessageHolder)convertView.getTag() ;
        }

        bindView(list_msg.get(position) ,msg_holder) ;
        return convertView;
    }

    private void bindView(SendMessage msg , MessageHolder holder){
        holder.tv_time.setText(msg.getTime());
        holder.tv_content.setText(msg.getContent());
    }

    class MessageHolder{
        private TextView tv_time = null ;
        private TextView tv_content = null ;
    }
}
