package org.example.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.pojo.Reward;
import java.util.List;

public class RewardResponseDTO {
    private List<RewardDTO> rewardList;

    public RewardResponseDTO(List<RewardDTO> rewardList) {this.rewardList = rewardList;}

    @Data
    @Builder
    public static class RewardDTO{
        private String user;

        private int points;

        public RewardDTO(String user, int points){
            this.user = user;
            this.points = points;
        }
    }
}
