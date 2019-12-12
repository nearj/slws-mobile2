package com.slws.ui.favoriteListOfNotice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

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

            }
        });
        checkBox1.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox1.setChecked(false);
                }else{
                    checkBox1.setChecked(true);
                }
            }
        });
        checkBox2.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox2.setChecked(false);
                }else{
                    checkBox2.setChecked(true);
                }
            }
        });
        checkBox3.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox3.setChecked(false);
                }else{
                    checkBox3.setChecked(true);
                }
            }
        });
        checkBox4.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox4.setChecked(false);
                }else{
                    checkBox4.setChecked(true);
                }
            }
        });
        checkBox5.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox5.setChecked(false);
                }else{
                    checkBox5.setChecked(true);
                }
            }
        });
        checkBox6.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox6.setChecked(false);
                }else{
                    checkBox6.setChecked(true);
                }
            }
        });
        checkBox7.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox7.setChecked(false);
                }else{
                    checkBox7.setChecked(true);
                }
            }
        });
        checkBox8.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                if(((CheckBox)v).isChecked()){
                    checkBox8.setChecked(false);
                }else{
                    checkBox8.setChecked(true);
                }
            }
        });

        return root;
    }

}
