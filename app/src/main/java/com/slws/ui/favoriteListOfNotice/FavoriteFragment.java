package com.slws.ui.favoriteListOfNotice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.slws.R;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_listofnotice, container, false);

        CheckBox checkBox1 = root.findViewById(R.id.checkBox);
        CheckBox checkBox2 = root.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = root.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = root.findViewById(R.id.checkBox4);
        CheckBox checkBox5 = root.findViewById(R.id.checkBox5);
        CheckBox checkBox6 = root.findViewById(R.id.checkBox6);
        CheckBox checkBox7 = root.findViewById(R.id.checkBox7);
        CheckBox checkBox8 = root.findViewById(R.id.checkBox8);
        Button button = root.findViewById(R.id.checkButton);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                //완료되었습니다
                Toast.makeText(getActivity(),
                        "관심 공지사항 목록이 설정되었습니다!",
                        Toast.LENGTH_LONG).show();
            }
        });

        checkBox1.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox1.setChecked(true);
                }else{
                    checkBox1.setChecked(false);
                }
            }
        });
        checkBox2.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox2.setChecked(true);
                }else{
                    checkBox2.setChecked(false);
                }
            }
        });
        checkBox3.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox3.setChecked(true);
                }else{
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox4.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox4.setChecked(true);
                }else{
                    checkBox4.setChecked(false);
                }
            }
        });
        checkBox5.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox5.setChecked(true);
                }else{
                    checkBox5.setChecked(false);
                }
            }
        });
        checkBox6.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox6.setChecked(true);
                }else{
                    checkBox6.setChecked(false);
                }
            }
        });
        checkBox7.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox7.setChecked(true);
                }else{
                    checkBox7.setChecked(false);
                }
            }
        });
        checkBox8.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox8.setChecked(true);
                }else{
                    checkBox8.setChecked(false);
                }
            }
        });

        return root;
    }

}
