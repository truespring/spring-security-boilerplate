package com.mini2S.biz.branch.service;

import com.mini2S.biz.branch.model.dto.BranchDto;
import com.mini2S.common.enums.BranchEnum;
import com.mini2S.common.util.map.Direction5;
import com.mini2S.configuration.reposotory.BranchRepository;
import com.mini2S.configuration.reposotory.UsersRepository;
import com.mini2S.configuration.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final UsersRepository usersRepository;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 로그인
     * @param token
     * @return List<BranchDto>
     */
    @Override
    @Transactional
    public List<BranchDto> selectUserBranchList(String token) {
        String resultToken = jwtTokenProvider.getUserPk(token);
        Map<String, Object> userCoord = usersRepository.findUserCoordinateByUserEmail(resultToken);

        List<Object[]> branchCoord = branchRepository.findBranchInfoByUseYn();
        List<BranchDto> returnList = new ArrayList<>();
        branchCoord.forEach(item ->{
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
        return returnList;
    }

    /**
     * 비로그인
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
        return returnList;
    }
    //    @Transactional
//    public List<Branch> findBranchList(Long userSeq) {
//        if(userSeq == null || userSeq == 0L) {
//            return branchRepository.findAll();
//        }
//        Object[] userCoord = usersRepository.findUserCoordinateByUserSeq(userSeq);
//        List<Branch> branchCoord = branchRepository.findBranchCoordinate();
//        List<BranchDto> sortArr = new ArrayList<>();
//        for (Branch item : branchCoord) {
//            BigDecimal tempX = item.getCoordX() - (BigDecimal) userCoord[0];
//            BigDecimal tempY = item.getCoordY() - (BigDecimal) userCoord[1];
//            BigDecimal tempDist = Math.pow(Math.pow(tempX, 2) + Math.pow(tempY, 2), 1 / 2);
//            BranchDto dto = new BranchDto();
//            dto.setBranch(item);
//            dto.setOrderNum(tempDist);
//            sortArr.add(dto);
//        }
//        sortArr.sort(Comparator.comparingDouble(BranchDto::getOrderNum));
//        List<Branch> returnArr = new ArrayList<>();
//        for(int i = 0; i < sortArr.size(); i++) {
//            returnArr.add(sortArr.get(i).getBranch());
//        }
//        return returnArr;
//    }
}