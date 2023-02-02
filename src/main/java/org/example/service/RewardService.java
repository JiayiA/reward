package org.example.service;

import org.example.pojo.dto.RewardResponseDTO;

public interface RewardService {

    RewardResponseDTO.RewardDTO getPointsByUserAndMonth(String id, int month);

    RewardResponseDTO.RewardDTO getPointsByUser(String id);

}
