package com.devAsk.api.entity;

import com.devAsk.api.entity.base.BaseEntity;
import com.devAsk.api.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;



@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "user_tokens")
@NoArgsConstructor
@AllArgsConstructor
public class Token extends BaseEntity {

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    public User user;

}
