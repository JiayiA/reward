package org.example.repository;

import org.example.pojo.Reward;

import java.util.ArrayList;

public interface RewardRepository {

    void add(Reward r);

    ArrayList<Reward> findByUserAndMonth(String userId, int month);

    ArrayList<Reward> findByUser(String userId);
}
