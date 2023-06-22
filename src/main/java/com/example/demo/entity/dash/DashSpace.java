package com.example.demo.entity.dash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//입주 공간 공고
@Getter
@Entity(name = "DashSpace")
@NoArgsConstructor
@AllArgsConstructor
public class DashSpace {
    //space는 알림x
    //입주 공간 바로가기 링크는 공지 클릭 지원x -> 그냥 사이트 링크 주기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dept;
    private String infra;
    private String location;
    private String field;
    private String totalSpace;
    private String emptySpace;


    public DashSpace(Element element) {
        setDept(element);
        setInfra(element);
        setLocation(element);
        setField(element);
        setSpace(element);
    }

    public void setDept(Element element) {
        String dept = element.attr("td[data-table-type=value]");
        this.dept = dept;
    }

    public void setInfra(Element element) {
        String infra = element.attr("td[data-table-type=infra]");
        this.infra = infra;
    }

    public void setLocation(Element element) {
        String location = element.attr("td[data-table-type=location]");
        this.location = location;
    }

    public void setField(Element element) {
        String field = element.attr("td[data-table-type=field]");
        this.field = field;
    }

    public void setSpace(Element element) {
        Elements elements = element.select("td[data-table-type=square]");
        String totalSpace = elements.get(0).text();
        String emptySpace = elements.get(1).text();
        this.totalSpace = totalSpace;
        this.emptySpace = emptySpace;
    }
}
