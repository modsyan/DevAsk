package com.devAsk.api.entity;

import com.devAsk.api.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "questions")
@SQLDelete(sql = "UPDATE questions SET deleted = true WHERE id=?")
//// temporally until implement soft-delete repository
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseEntity {

    @ManyToOne
    private User user;

    private String title;

    private String content;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Solution> solutions;

    @OneToMany
    private Set<User> votes;

    @OneToMany
    private List<File> files;
}