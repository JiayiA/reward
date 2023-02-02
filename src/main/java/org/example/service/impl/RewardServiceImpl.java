package org.example.service.impl;

import org.example.pojo.Reward;
import org.example.pojo.dto.RewardResponseDTO;
import org.example.repository.RewardRepository;
import org.example.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RewardServiceImpl implements RewardService {

    private final RewardRepository rewardRepository;

    @Autowired
    public RewardServiceImpl(RewardRepository rewardRepository){this.rewardRepository = rewardRepository;}

    public int calculatePoints(ArrayList<Reward> rewards){
        int totalPoints = 0;
        for(int i = 0; i < rewards.size(); i++){
            if(rewards.get(i).getTransactionAmount() > 50){
                totalPoints += (rewards.get(i).getTransactionAmount()-50);
            }
            if(rewards.get(i).getTransactionAmount() > 100){
                totalPoints += (rewards.get(i).getTransactionAmount()-100)*2;
            }
        }
        return totalPoints;
    }

    @Override
    public RewardResponseDTO.RewardDTO getPointsByUserAndMonth(String id, int month){
        ArrayList<Reward> rewards = rewardRepository.findByUserAndMonth(id, month);
        int totalPoints = calculatePoints(rewards) ;
        return new RewardResponseDTO.RewardDTO(id, totalPoints);
    }

    @Override
    public RewardResponseDTO.RewardDTO getPointsByUser(String id){
        ArrayList<Reward> rewards = rewardRepository.findByUser(id);
        int totalPoints = calculatePoints(rewards);
        return new RewardResponseDTO.RewardDTO(id,totalPoints);
    }


}
