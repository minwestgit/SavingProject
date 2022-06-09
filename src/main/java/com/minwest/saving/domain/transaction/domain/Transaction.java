package com.minwest.saving.domain.transaction.domain;

import com.minwest.saving.domain.account.domain.Account;
import com.minwest.saving.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    //==생성 메서드==//
    public static Transaction createTransaction(User user, Account account, TransactionStatus status, int money) {
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAccount(account);
        transaction.setStatus(status);
        transaction.setMoney(money);
        return transaction;
    }
}
