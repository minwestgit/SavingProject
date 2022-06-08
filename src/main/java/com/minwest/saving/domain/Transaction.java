package com.minwest.saving.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id @GeneratedValue
    @Column(name = "detailId")
    private Long id;

    private TransactionStatus status;
    private int money;

    @CreatedDate
    private LocalDateTime createDate;
}
