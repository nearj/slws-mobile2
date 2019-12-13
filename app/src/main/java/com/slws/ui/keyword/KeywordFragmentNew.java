package com.slws.ui.keyword;
import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.slws.R;

public class KeywordFragmentNew extends Fragment{
    ListView listView;
    ArrayList<String> list=new ArrayList<String>();
    Button btnAdd;
    Button btnDel;
    ArrayAdapter<String> adapter;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_keyword_new, container, false);


        listView = root.findViewById(R.id.listView1);
        btnAdd = root.findViewById(R.id.btnAdd);
        btnDel = root.findViewById(R.id.btnDel);

        //어댑터객체 생성
        adapter =
                new ArrayAdapter<String>(getActivity(),//Context객체
                        android.R.layout.simple_list_item_single_choice,//보여질레이아웃형태
                        list //보여질데이터를 담고있는 배열
                );


        //하나의 항목을 선택할 수 있는 모드 설정
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        //어댑터와 리스트뷰 연결하기
        listView.setAdapter(adapter);


        //항목을 선택했을때 수행할 동작 처리(이벤트 처리)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,//이벤트가 발생된 뷰
                                    View v,//이벤트가 발생된 차일드 뷰
                                    int position,//이벤트가 발생된 항목의 위치
                                    long id//이벤트가 발생된 뷰 id
            ){
                //ArrayList에서 position에 해당하는 데이터 얻어오기
                String item=list.get(position);



            }
        });

        final EditText edt=root.findViewById(R.id.edt1);


        //버튼을 눌렀을때 입력된 항목 추가하기
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력된 문자열 얻어오기
                String str=edt.getText().toString();
                //입력된 값을 ArrayList에 추가하기
                list.add(str);
                //모델객체가 변경되었음을 어댑터뷰에 알리기
                adapter.notifyDataSetChanged();
                //입력된 값 지우기
                edt.setText("");
                //토스트로  출력하기

                Toast.makeText(getActivity(),
                        str + "의 키워드가 등록되었습니다!",
                        Toast.LENGTH_SHORT).show();

            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //선택된 항목의 인덱스 얻어오기
                int pos=listView.getCheckedItemPosition();
                String str = list.get(pos);
                //ArrayList에서 항목 지우기
                list.remove(pos);
                //어댑터에 항목이 바뀜을 알리기
                adapter.notifyDataSetChanged();
                //선택한 항목표시 없애기
                listView.clearChoices();
                Toast.makeText(getActivity(),
                        str + "의 키워드가 삭제되었습니다!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}
