package com.slws.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.slws.R;
import com.slws.databinding.DashboardFragmentRecyclerBinding;
import com.slws.model.Content;

public class ContentFragment extends Fragment {
    private ContentViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[][] mDataset;
    private ObservableArrayList<Content> contentList;

    public static ContentFragment newInstance() {
        return new ContentFragment();
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


        //crawling();
        mAdapter = new ContentFragmentAdapter();
        contentList = new ObservableArrayList<>();
        binding.dashboardRecyclerView.setHasFixedSize(true);
        binding.dashboardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.setContentList(this.contentList);
        binding.dashboardRecyclerView.setAdapter(mAdapter);

        doDummy();

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ContentViewModel.class);
    }

    private void doDummy() {
        contentList.add(new Content("현직 동문 선배와의 진로 토크 \"서울시립대학교 동문 휴먼라이브러리\" 참가 신청 접수",
                "2019년 서울시립대학교 동문 휴먼라이브러리 행사 신청 안내 ...", "12/06",
                "학생과", "asdf"));
        contentList.add(new Content("[공지] 2020-1 서울메이트(SeoulMate) 모집", "SeoulMate 는 본교로 오는 신규 해외 대학 교환학생들이 한국 생활과 학교생활에 적응할 수 있도록 도와주면서 교환학생들과 교류하는 자원봉사 단체입니다 . SeoulMate 는 한국 및 우리대학을 대표하는 문화사절단으로서 내실 있고 적극적이며 활발한 활동을 지향합니다 . 이에 2020 년도 1 학기 SeoulMate 를 아래와 같이 모집하오니 관심 있는 학생들의 많은 지원 바랍니다 .\n" +
                "\n" +
                "2019. 12.\n" +
                "\n" +
                "국제교육원장", "12/13", "d4", "e5"));
        contentList.add(new Content("[공지] 2019학년도 동계 무료법률상담 안내", "서울시립대학교 교직원 여러분 안녕하십니까?\n" +
                "\n" +
                " \n" +
                "\n" +
                "법학전문대학원 리걸클리닉센터 법률상담실에서 지난해와 같이  \n" +
                "\n" +
                "\n" +
                "\n" +
                "올 겨울방학기간 동안 무료법률상담을 하여 드리오니  \n" +
                "\n" +
                "\n" +
                "\n" +
                "가까운 가족이나 주위에 법률문제로 어려움이 있으신 분들에게 널리 알리시어", "12/13", "d", "e"));
        contentList.add(new Content("[공지] 제2회 동대문구립 소년소녀합창단 정기연주회 자원봉사자 모집", "제2회 동대문구립 소년소녀합창단 정기연주회와 관련하여 질서 유지 및 주차 안내를 위한 자원봉사자 학생을 다음과 같이 모집합니다.\n" +
                "\n" +
                " \n" +
                "\n" +
                "가. 행사개요 ", "12/13", "d", "e"));
        contentList.add(new Content("[공지] [현장실습] 서울시정 대학생 인턴십 최종 선발 결과 안내", "2019. 겨울계절학기\n" +
                "\n" +
                " \n" +
                "\n" +
                "제 10 기 서울시정 대학생 인턴십 ( 현장실습 )\n" +
                "\n" +
                " \n" +
                "\n" +
                "최종 합격자 안내\n" +
                "\n" +
                "1. 최종 합격자 : 총 6 명 ( 예비합격 3 명 제외 )", "12/12", "d", "e"));
        contentList.add(new Content("[공지] [고시반] 자격고시반 추가입반자 모집공지", "[ 고시반 ] 국가고시반 추가입반 모집공지\n" +
                "\n" +
                "국가고시반 ( 행정고시 , 기술고시 ) 에서 추가입반 접수를 받습니다 .\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "■ 지원자격", "12/12", "d", "e"));
        contentList.add(new Content("[공지] [교수학습개발센터] 온라인강의실 시스템 개선 관련 설문조사(1차)", "안녕하세요, 서울시립대학교 교수학습개발센터입니다.\n" +
                "\n" +
                "저희 센터에서는 2021학년도,\n" +
                "\n" +
                "새로운 온라인강의실 시스템(LMS)을 도입할 예정입니다.", "12/12", "d", "e"));
        contentList.add(new Content("[공지] [생활관] 2019학년도 기숙사 동계특별개관 사용승인자 공고", "2020 학년도 기숙사생 선발계획\n" +
                "\n" +
                "   \n" +
                "\n" +
                " \n" +
                "\n" +
                "1. 입사기간 (1 년 )\n" +
                "\n" +
                "- 1 학기 : 2020. 2.27( 목 )~2020. 6.21( 일 )\n" +
                "\n" +
                "- 2 학기 : 2020. 8.27( 목 )~2020.12.22( 화 )", "12/06", "d", "e"));
    }
}
