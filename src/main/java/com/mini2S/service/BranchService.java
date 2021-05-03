package com.mini2S.service;

import com.mini2S.entity.Branch;
import com.mini2S.model.dto.BranchDto;
import com.mini2S.reposotory.BranchRepository;
import com.mini2S.reposotory.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public List<Branch> findBranchList(Long userSeq) {
        if(userSeq == null || userSeq == 0L) {
            return branchRepository.findAll();
        }
        Object[] userCoord = usersRepository.findUserCoordinateByUserSeq(userSeq);
        List<Branch> branchCoord = branchRepository.findBranchCoordinate();
        List<BranchDto> sortArr = new ArrayList<>();
        branchCoord.stream().forEach(item -> {
            Double tempX = item.getCoordX() - (Double) userCoord[0];
            Double tempY = item.getCoordY() - (Double) userCoord[1];
            Double tempDist = Math.pow(Math.pow(tempX, 2) + Math.pow(tempY, 2), 1/2);
            BranchDto dto = new BranchDto();
            dto.setBranch(item);
            dto.setOrderNum(tempDist);
            sortArr.add(dto);
        });
        sortArr.sort(Comparator.comparingDouble(BranchDto::getOrderNum));
        List<Branch> returnArr = new ArrayList<>();
        for(int i = 0; i < sortArr.size(); i++) {
            returnArr.add(sortArr.get(i).getBranch());
        }
        return returnArr;
    }
}
