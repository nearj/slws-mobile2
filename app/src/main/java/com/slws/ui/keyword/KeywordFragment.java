package com.slws.ui.keyword;

import android.os.Bundle;
import android.view.LayoutInflater;
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

import java.util.ArrayList;

public class KeywordFragment extends Fragment {
    ListView listView;
    ArrayList<String> list = new ArrayList<>();
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

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_single_choice, list);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            String item = list.get(position);
        });
        final EditText edt = root.findViewById(R.id.edt1);

        btnAdd.setOnClickListener((View v) -> {
            String str = edt.getText().toString();
            list.add(str);
            adapter.notifyDataSetChanged();
            edt.setText("");
            Toast.makeText(getActivity(), str + "의 키워드가 등록되었습니다!", Toast.LENGTH_SHORT).show();
        });


        btnDel.setOnClickListener((View v) -> {
            int pos = listView.getCheckedItemPosition();
            String str = list.get(pos);
            list.remove(pos);
            adapter.notifyDataSetChanged();
            listView.clearChoices();
            Toast.makeText(getActivity(), str + "의 키워드가 삭제되었습니다!", Toast.LENGTH_SHORT).show();
        });
        return root;
    }
}
