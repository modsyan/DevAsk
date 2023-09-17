package com.devAsk.api.entity;


import com.devAsk.api.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "solutions")
@NoArgsConstructor
@AllArgsConstructor
public class Solution extends BaseEntity {

    @ManyToOne
    private User user;

    private String title;

    private String content;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private Set<User> votes;

    @OneToMany
    private List<File> files;

}
