package com.mini2S.configuration.reposotory;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.branch.model.vo.BranchVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = " SELECT a.coordX, a.coordY, a.branchName, a.address, a.addressDetail, a.branchSeq " +
                    " FROM Branch a " +
                    " WHERE a.useYn = 'Y'" )
    List<BranchVO> findBranchCoordinate();

    @Query(value = " SELECT a.coord_x, a.coord_y, a.branch_name, a.address, a.address_detail, b.branch_image, b.branch_image_sort " +
            " FROM branch a " +
            " INNER JOIN branch_image b " +
            " ON a.branch_seq = b.branch_seq " +
            " WHERE a.branch.useYn = 'Y'" )
    List<BranchVO> findBranchInfoByUseYn();
}
