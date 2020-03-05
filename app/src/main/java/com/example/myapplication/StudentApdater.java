package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentApdater extends BaseAdapter {

    private List<Student> list = null ;
    private Context context    = null ;

    public StudentApdater(List<Student> list ,Context context){
        this.list = list ;
        this.context = context ;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StudentView sv = null ;
        if(null == convertView){
            convertView = View.inflate(context,android.R.layout.simple_list_item_1 ,null) ;
            sv = new StudentView() ;
            sv.tv_name = convertView.findViewById(android.R.id.text1) ;
            convertView.setTag(sv);
        } else {
            sv = (StudentView) convertView.getTag();
        }

        fullView(sv ,list.get(position)) ;

        return convertView;
    }


    private void fullView(StudentView v , Student stu){
        v.tv_name.setText(stu.getName());
    }


    class StudentView{
        private TextView tv_name ;
    }
}
