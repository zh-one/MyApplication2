package com.example.myapplication;

import android.content.Context;
import android.security.keystore.StrongBoxUnavailableException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> list = null ;
    private Context context    = null ;
    private ItemOnClick onClick= null ;

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
        Student one = list.get(position) ;
      return  list.get(position);

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
            sv.lin_bg  = convertView.findViewById(R.id.lin_student_bg) ;
            sv.tv_name = convertView.findViewById(R.id.tv_student_name) ;
            sv.tv_age  = convertView.findViewById(R.id.tv_student_age)  ;
            convertView.setTag(sv);
        } else {
            sv = (StudentView) convertView.getTag();
        }

     fullView(position,sv ,list.get(position)) ;

        return convertView;
    }


    private void fullView(final int position, StudentView v , final Student stu){
        v.lin_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(onClick != null){
              //    onClick.onClick(position,stu);
              }
            }
        });
        v.tv_name.setText(stu.getName());
        v.tv_age.setText(String.valueOf(stu.getAge()));
    }


    class StudentView{
        private LinearLayout lin_bg ;
        private TextView tv_name ;
        private TextView tv_age  ;
    }

    interface ItemOnClick{
        void onClick(int position ,Student stu) ;
    }


    public void setItemOnClickListener(ItemOnClick onClick){
        this.onClick = onClick ;
    }
}
