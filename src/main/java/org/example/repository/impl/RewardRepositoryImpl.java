package org.example.repository.impl;

import org.example.pojo.Reward;
import org.example.repository.RewardRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardRepositoryImpl implements RewardRepository {

    private final Map<String, ArrayList<Reward>> map = new HashMap<>();

    public void init(){

    }

    @Override
    public ArrayList<Reward> findByUser(String userId){
        return map.get(userId);
    }

    @Override
    public ArrayList<Reward> findByUserAndMonth(String userId, int month){
        ArrayList<Reward> results = new ArrayList<>();
        ArrayList<Reward> selections = map.get(userId);
        for(int i = 0; i < selections.size(); i++){
            if(selections.get(i).getTransactionMonth() == month){
                results.add(selections.get(i));
            }
        }
        return results;
    }

    @Override
    public void add(Reward r){
        if(map.containsKey(r.getUser())){
            map.get(r.getUser()).add(r);
        }
        else{
            map.put(r.getUser(),new ArrayList<>());
            map.get(r.getUser()).add(r);
        }
    }

}