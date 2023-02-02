package org.example.repository.impl;

import org.example.pojo.Reward;
import org.example.repository.RewardRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RewardRepositoryImpl implements RewardRepository {

    private final Map<String, ArrayList<Reward>> map = new HashMap<>();

    public void init(){
        ArrayList<Reward> rewards = new ArrayList<>();
        rewards.add(new Reward("1", 150, 2));
        rewards.add(new Reward("1", 50, 2));
        map.put("1", rewards);
        ArrayList<Reward> rewards1 = new ArrayList<>();
        rewards1.add(new Reward("2", 120, 3));
        map.put("2",rewards1);
    }

    @Override
    public ArrayList<Reward> findByUser(String userId){
        System.out.println(map.size());
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
