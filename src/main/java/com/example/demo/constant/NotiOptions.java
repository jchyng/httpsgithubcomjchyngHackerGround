package com.example.demo.constant;

import java.util.Map;

public final class NotiOptions {
    public final static String dash = "지원사업 공고";
    public final static String[] youth = {"일자리", "교육", "주거", "복지문화"};
    public final static Map<String, String[]> jobs = Map.of(
            "채용 공고", new String[]{"사기업", "공기업", "공무원"},
            "교육 과정", null,
            "지원 정책", new String[]{"구직자 지원", "사업주 지원"}
    );
}
