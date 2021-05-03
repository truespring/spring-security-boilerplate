package com.mini2S.branch;

import com.mini2S.configuration.reposotory.BranchRepository;
import com.mini2S.configuration.reposotory.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BranchService{
    private final BranchRepository branchRepository;
    private final UsersRepository usersRepository;


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
