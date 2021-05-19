package com.mini2S.biz.branch.service;

import com.mini2S.biz.branch.model.dto.BranchDto;
import com.mini2S.common.enums.BranchEnum;
import com.mini2S.common.util.DataHandleUtil;
import com.mini2S.common.util.map.Direction5;
import com.mini2S.configuration.reposotory.BranchRepository;
import com.mini2S.configuration.reposotory.UsersRepository;
import com.mini2S.configuration.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final UsersRepository usersRepository;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 로그인 시 지점 목록 출력
     *
     * @param userEmail 로그인 사용자 이메일
     * @return List<BranchDto>
     */
    @Override
    @Transactional
    public List<BranchDto> selectUserBranchList(String userEmail) {
        Map<String, Object> userCoord = usersRepository.findUserCoordinateByUserEmail(userEmail);

        List<Object[]> branchCoord = branchRepository.findBranchInfoByUseYn();
        List<BranchDto> returnList = new ArrayList<>();
        branchCoord.forEach(item -> {
            List<String> branchList = branchRepository.findBranchImageList(Long.parseLong(item[5].toString()));
            returnList.add(BranchDto.builder()
                    .coordX(item[0].toString())
                    .coordY(item[1].toString())
                    .diffDistance(Direction5.selectDistanceAFromB(
                            Direction5.selectNavigationInfo(String.valueOf(userCoord.get("coordx"))
                                    , String.valueOf(userCoord.get("coordy"))
                                    , item[0].toString()
                                    , item[1].toString()))
                    )
                    .branchName(item[2].toString())
                    .address(item[3].toString())
                    .addressDetail(item[4].toString())
                    .branchImage(branchList)
                    .build());
        });
        returnList.sort(Comparator.comparingDouble(o -> DataHandleUtil.objectToDouble(o.getDiffDistance().get("distance"))));
        return returnList;
    }

    /**
     * 비로그인 시 지점 목록 출력
     *
     * @return List<BranchDto>
     */
    @Override
    @Transactional
    public List<BranchDto> selectBranchInfoList() {
        List<Object[]> branchCoord = branchRepository.findBranchInfoByUseYn();
        List<BranchDto> returnList = new ArrayList<>();
        branchCoord.forEach(item -> {
            List<String> branchList = branchRepository.findBranchImageList(Long.parseLong(item[5].toString()));
            returnList.add(BranchDto.builder()
                    .coordX(item[0].toString())
                    .coordY(item[1].toString())
                    .diffDistance(Direction5.selectDistanceAFromB(
                            Direction5.selectNavigationInfo(BranchEnum.DEFAULT_X.getValue()
                                    , BranchEnum.DEFAULT_Y.getValue()
                                    , item[0].toString()
                                    , item[1].toString()))
                    )
                    .branchName(item[2].toString())
                    .address(item[3].toString())
                    .addressDetail(item[4].toString())
                    .branchImage(branchList)
                    .build());
        });
        returnList.sort(Comparator.comparingDouble(o -> DataHandleUtil.objectToDouble(o.getDiffDistance().get("distance"))));
        return returnList;
    }
}