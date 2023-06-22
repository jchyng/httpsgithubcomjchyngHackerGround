package com.example.crawling.entity.job;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "JobCompany")
@NoArgsConstructor
public class JobCompany {
    @Id
    private Long id;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setDday(String dday) {
        this.dday = dday;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String companyName;
    private String title;
    private String location;
    private String career;
    private String Education;
    private String payType;
    private String dday;
    private String link;
}
