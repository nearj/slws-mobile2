package com.slws.ui.dashboard;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.R;
import com.slws.data.AppDataManager;
import com.slws.databinding.DashboardFragmentRecyclerBinding;
import com.slws.databinding.DashboardMenuItemBinding;
import com.slws.model.Content;
import com.slws.utils.BoardTitle;
import com.slws.utils.Spider;

import java.util.List;

public class ContentFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ObservableArrayList<Content> contentList;
    private BoardTitle mBoardTitle;


    public ContentFragment(BoardTitle boardTitle) {
        this.mBoardTitle = boardTitle;
    }

    public static ContentFragment newInstance(BoardTitle boardTitle) {
        return new ContentFragment(boardTitle);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DashboardFragmentRecyclerBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.dashboard_fragment_recycler, container, false);
        View root = binding.getRoot();

        mRecyclerView = root.findViewById(R.id.dashboard_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ContentFragmentAdapter(getActivity(), mBoardTitle);
        binding.dashboardRecyclerView.setHasFixedSize(true);
        binding.dashboardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.dashboardRecyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static class ContentFragmentAdapter
            extends RecyclerView.Adapter<ContentFragmentAdapter.ContentViewHolder> {

        Dialog dialog;
        private List<Content> mContentList;
        private Context mContext;

        public ContentFragmentAdapter(Context context, BoardTitle boardTitle) {
            List<Integer> seqs = Spider.getSeqeunces(boardTitle, 10);
            this.mContext = context;
            this.mContentList = AppDataManager.
                    getContents(boardTitle, seqs.toArray(new Integer[seqs.size()]));

        }

        @NonNull
        @Override
        public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            DashboardMenuItemBinding binding = DashboardMenuItemBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false);


            return new ContentViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
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

        public interface OnItemClickListener {
            void onItemClick(Content content);
        }

        public static class ContentViewHolder extends RecyclerView.ViewHolder {
            private final DashboardMenuItemBinding binding;

            public ContentViewHolder(DashboardMenuItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            void bind(Content content) {
                binding.setContent(content);
                binding.layout.setBackgroundColor(Color.WHITE);
            }
        }
    }
}
