package com.mini2S.configuration.reposotory;

import com.mini2S.biz.contract.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
