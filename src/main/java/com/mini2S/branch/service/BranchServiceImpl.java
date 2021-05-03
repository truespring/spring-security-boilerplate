package com.mini2S.branch.service;

import com.mini2S.branch.model.dto.BranchDto;
import com.mini2S.configuration.reposotory.BranchRepository;
import com.mini2S.configuration.reposotory.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BranchServiceImpl implements BranchService{

    private final BranchRepository branchRepository;
    private final UsersRepository usersRepository;

    @Override
    public List<BranchDto> selectBranchList(Long userSeq) {
//        if(userSeq == null || userSeq == 0L) {
////            return branchRepository.findAll();
//        }
        return null;
    }
}
