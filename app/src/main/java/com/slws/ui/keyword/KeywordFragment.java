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
import androidx.lifecycle.ViewModelProviders;

import com.slws.R;
import com.slws.utils.States;

public class KeywordFragment extends Fragment {
    Integer curPos = -1;
    String curString = null;
    KeywordViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_keyword, container, false);
        ListView listView = root.findViewById(R.id.listView1);
        Button btnAdd = root.findViewById(R.id.btnAdd);
        Button btnDel = root.findViewById(R.id.btnDel);
        EditText editText = root.findViewById(R.id.edt1);

        if (viewModel == null) {
            viewModel = ViewModelProviders.of(this).get(KeywordViewModel.class);
        }

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_single_choice, viewModel.getItemList());
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            curPos = position;
        });

        btnAdd.setOnClickListener((View v) -> {
            curString = editText.getText().toString();
            if (viewModel.itemListContains(curString)) {
                Toast.makeText(getActivity(),
                        curString + "는 이미 등록된 키워드입니다.", Toast.LENGTH_SHORT).show();
            } else if (!curString.equals("")) {
                viewModel.addToItemList(curString);
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");
                Toast.makeText(getActivity(), curString + "의 키워드가 등록되었습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        btnDel.setOnClickListener((View v) -> {
            if (!curPos.equals(-1)) {
                viewModel.removeFromItemList(curPos.intValue());
                arrayAdapter.notifyDataSetChanged();
                listView.clearChoices();
                Toast.makeText(getActivity(), curString + "의 키워드가 삭제되었습니다!", Toast.LENGTH_SHORT).show();
                curPos = -1;
            }
        });
        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(States.KEYWORD.toString(), viewModel.getItemList());
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
//            mItemList = savedInstanceState.getStringArrayList(States.KEYWORD.toString());
//            Log.d("savedInstanceState", mItemList.toString() + savedInstanceState.toString());
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
//            mItemList = savedInstanceState.getStringArrayList(States.KEYWORD.toString());
//            Log.d("savedInstanceState", mItemList.toString() + savedInstanceState.toString());
        }
    }
}
