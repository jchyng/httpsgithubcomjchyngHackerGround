package com.hackerground.crawlingnotiserver.entity;

import java.util.List;

//일자리 포털
public class JobPotal {
    private List<Recruitment> recruitments;
    private List<SupportPolicy> supportPolicies;

    //채용 공고
    public class Recruitment {
        private List<Company> publicCompanies;
        private List<Company> privateCompanies;
        private List<PublicOfficial> publicOfficials;

        //공기업 & 사기업
        public class Company {
            private String name;
            private String title;
            private String location;
            private String career;
            private String Education;
            private String payType;
            private String d_day;
            private String link;
            boolean latest;
        }

        //공무원
        public class PublicOfficial {
            private String title;
            boolean latest;
        }
    }

    //교육 과정
    public class Curriculum {
        String state;
        String period;
        String type;
        String title;
        String trainingPeriod;
        String dept;
        boolean latest;
    }

    //지원 정책
    public class SupportPolicy {
        private List<Support> ownerSupports;
        private List<Support> jobSeekerSupports;

        //지원
        public class Support {
            private String state;
            private String title;
            private String target;
            private String location;
            private String supportType;
            private String period;
            boolean latest;
        }
    }
}
