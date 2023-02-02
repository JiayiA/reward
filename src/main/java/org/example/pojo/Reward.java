package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rewardId;

    @Column
    private String user;

    @Column
    private int transactionAmount;

    @Column
    private int transactionMonth;

    public Reward(){

    }

    public Reward(long rewardId, String user, int transactionAmount, int transactionMonth){
        this.rewardId = rewardId;
        this.user = user;
        this.transactionAmount = transactionAmount;
        this.transactionMonth = transactionMonth;
    }

}
