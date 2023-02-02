package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    @Column
    private String user;

    @Column
    private int transactionAmount;

    @Column
    private int transactionMonth;

    public Reward(){

    }

    public Reward(String user, int transactionAmount, int transactionMonth){
        this.user = user;
        this.transactionAmount = transactionAmount;
        this.transactionMonth = transactionMonth;
    }

}
