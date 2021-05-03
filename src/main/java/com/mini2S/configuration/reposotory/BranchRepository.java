package com.mini2S.configuration.reposotory;

import com.mini2S.branch.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = " SELECT a.coordX, a.coordY, a.branchName, a.address, a.addressDetail, a.branchSeq " +
                    " FROM Branch a " +
                    " WHERE a.useYn = 'Y'" )
    public List<Branch> findBranchCoordinate();
}
