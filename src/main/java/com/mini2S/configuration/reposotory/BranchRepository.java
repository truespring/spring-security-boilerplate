package com.mini2S.configuration.reposotory;

import com.mini2S.biz.branch.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    /**
     * 사용 중인 지점 정보
     *
     * @return 선택한 정보
     */
    @Query(value = " SELECT a.coordX, a.coordY, a.branch_name, a.address, a.address_detail, a.branch_seq " +
            " FROM branch a " +
            " WHERE a.use_yn = 'Y'"
            , nativeQuery = true)
    List<Object[]> findBranchInfoByUseYn();

    /**
     * 지점 이미지 출력
     *
     * @param branchSeq : branch PK
     * @return 이미지 리스트
     */
    @Query(value = " SELECT a.branch_image " +
            " FROM branch_image a " +
            " INNER JOIN branch b " +
            " ON a.branch_seq = b.branch_seq " +
            " WHERE a.branch_seq = :branchSeq " +
            " ORDER BY a.branch_image_sort "
            , nativeQuery = true)
    List<String> findBranchImageList(@Param("branchSeq") Long branchSeq);
}
