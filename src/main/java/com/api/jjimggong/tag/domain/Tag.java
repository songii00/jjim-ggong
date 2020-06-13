package com.api.jjimggong.tag.domain;

import com.api.jjimggong.push.domain.Push;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id @GeneratedValue
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_name")
    private String tagName;
    /**
     * 연관 태그 명
     */
    @Column(name = "related_tag_name")
    private String relatedTagName;

    @OneToMany(mappedBy = "tag")
    private List<Push> pushes = new ArrayList<>();

}
