package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> list = null ;
    private Context context    = null ;

    public StudentAdapter(List<Student> list , Context context){
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
            convertView = View.inflate(context,R.layout.item_student ,null) ;
            sv = new StudentView() ;
            sv.tv_name = convertView.findViewById(R.id.tv_student_name) ;
            sv.tv_age  = convertView.findViewById(R.id.tv_student_age)  ;
            convertView.setTag(sv);
        } else {
            sv = (StudentView) convertView.getTag();
        }

        fullView(sv ,list.get(position)) ;

        return convertView;
    }


    private void fullView(StudentView v , Student stu){
        v.tv_name.setText(stu.getName());
        v.tv_age.setText(stu.getAge());
    }


    class StudentView{
        private TextView tv_name ;
        private TextView tv_age  ;
    }
}
