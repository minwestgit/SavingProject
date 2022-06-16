package com.minwest.saving.domain.account.domain;

import com.minwest.saving.domain.transaction.domain.Transaction;
import com.minwest.saving.domain.transaction.domain.TransactionStatus;
import com.minwest.saving.domain.user.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Account {

    @Id @GeneratedValue
    @Column(name = "accountId")
    private Long id;

    private int money;
    private int totalInterest;
    private int monthInterest;
    private double interestRate;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    //==연관관계 메서드==//(양방향일 때 설정)
    public void setUser(User user) {
        this.user = user;
        user.setAccount(this);
    }

}
