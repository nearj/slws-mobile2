package com.slws.utils;

import androidx.annotation.NonNull;

public enum BoardTitle {

    일반공지("일반공지", "https://uos.ac.kr/korNotice/view.do?list_id=FA1&seq="),
    학사공지("학사공지", "https://uos.ac.kr/korNotice/view.do?list_id=FA2&seq="),
    직원채용("직원채용", "https://uos.ac.kr/korNotice/view.do?list_id=FA34&seq="),
    창업공지("창업공지", "https://uos.ac.kr/korColumn/view.do?list_id=FA35&seq="),
    입찰공고("입찰공고", "https://uos.ac.kr/korFree/view.do?list_id=FA22&seq="),
    시설공사("시설공사", "https://uos.ac.kr/korNotice/view.do?list_id=FA25&seq="),
    행사안내("행사안내", "https://uos.ac.kr/korCalendarMonth/view.do?list_id=FA3&seq="),
    비교과교육("비교과교육", "https://uos.ac.kr/korNotice/view.do?list_id=ED3&seq=");

    private final String mName, mURL;

    BoardTitle(String name, String url) {
        mName = name;
        mURL = url;
    }

    @NonNull
    @Override
    public String toString() {
        return this.mName;
    }

    public String getURL() {
        return this.mURL;
    }
}