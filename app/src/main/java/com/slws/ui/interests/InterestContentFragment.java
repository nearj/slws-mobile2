package com.slws.ui.interests;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.R;
import com.slws.databinding.InterestFragmentRecyclerBinding;
import com.slws.databinding.InterestMenuItemBinding;
import com.slws.model.Content;

import java.util.List;


public class InterestContentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Content> mContentList;

    InterestContentFragment(List<Content> contentList) {
        this.mContentList = contentList;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        InterestFragmentRecyclerBinding binding
                = DataBindingUtil.inflate(inflater, R.layout.interest_fragment_recycler, container, false);
        View root = binding.getRoot();


        mRecyclerView = root.findViewById(R.id.interest_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new InterestContentFragmentAdapter(mContentList, getActivity());
        binding.interestRecyclerView.setHasFixedSize(true);
        binding.interestRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.interestRecyclerView.setAdapter(mAdapter);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static class InterestContentFragmentAdapter
            extends RecyclerView.Adapter<InterestContentFragmentAdapter.InterestContentViewHolder> {
        private List<Content> mContentList;
        Dialog dialog;
        Context mContext;

        public InterestContentFragmentAdapter(List<Content> contentList, Context context) {
            this.mContentList = contentList;
            this.mContext = context;
        }

        @NonNull
        @Override
        public InterestContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            InterestMenuItemBinding binding = InterestMenuItemBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false);

            return new InterestContentViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull InterestContentViewHolder holder, int position) {
            Content content = mContentList.get(position);

            dialog = new Dialog(mContext);
            dialog.setContentView(R.layout.fragment_viewer);

            holder.itemView.setOnClickListener((View v) -> {
                TextView title = dialog.findViewById(R.id.content_viewer_Title);
                TextView author = dialog.findViewById(R.id.content_viewer_author);
                TextView date = dialog.findViewById(R.id.content_viewer_date);
                TextView department = dialog.findViewById(R.id.content_viewer_department);
                TextView detail = dialog.findViewById(R.id.content_viewer_detail);
                title.setText(content.getTitle());
                author.setText(content.getAuthor());
                date.setText(content.getDate());
                department.setText(content.getDeparture());
                detail.setText(content.getDetail());
                //Toast.makeText(mContext, "Test Click", Toast.LENGTH_SHORT).show();
                dialog.show();
            });

            holder.bind(content);
        }

        public void setItem(List<Content> contentList) {
            if (contentList == null) {
                return;
            }

            this.mContentList = contentList;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return mContentList.size();
        }

        public static class InterestContentViewHolder extends RecyclerView.ViewHolder {
            private final InterestMenuItemBinding binding;

            public InterestContentViewHolder(InterestMenuItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            void bind(Content content) {
                binding.setContentInterest(content);
            }
        }

    }
}
