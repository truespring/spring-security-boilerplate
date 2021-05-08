package com.mini2S.configuration.reposotory;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.branch.model.vo.BranchVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = " SELECT a.coordX, a.coordY, a.branchName, a.address, a.addressDetail, a.branchSeq " +
                    " FROM Branch a " +
                    " WHERE a.useYn = 'Y'" )
    List<BranchVO> findBranchCoordinate();

    @Query(value = " SELECT a.coordX, a.coordY, a.branch_name, a.address, a.address_detail, a.branch_seq " +
            " FROM branch a " +
            " WHERE a.use_yn = 'Y'"
            , nativeQuery = true)
    List<Object[]> findBranchInfoByUseYn();

    @Query(value = " SELECT a.branch_image " +
                    " FROM branch_image a " +
                    " INNER JOIN branch b " +
                    " ON a.branch_seq = b.branch_seq " +
                    " WHERE a.branch_seq = :branchSeq " +
                    " ORDER BY a.branch_image_sort "
                    , nativeQuery = true)
    List<String> findBranchImageList(@Param("branchSeq") Long branchSeq);
}
