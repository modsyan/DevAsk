package com.devAsk.api.entity;


import com.devAsk.api.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.springframework.context.annotation.Lazy;
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
@SQLDelete(sql = "UPDATE solutions SET deleted = true WHERE id=?")
@NoArgsConstructor
@AllArgsConstructor
public class Solution extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    @OneToMany(mappedBy = "solutions", cascade = CascadeType.ALL)
    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private Set<User> votes;

    @OneToMany
    private List<File> files;

}
