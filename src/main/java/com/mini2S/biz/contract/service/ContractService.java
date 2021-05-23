package com.mini2S.biz.contract.service;

import com.mini2S.biz.contract.model.dto.InsertContractDto;
import com.mini2S.biz.contract.model.entity.Contract;
import com.mini2S.model.response.CommonResult;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface ContractService {
    Contract insertContract(InsertContractDto dto, String featureDirectory) throws IOException;

    List<Contract> selectContractList(String userEmail) throws NotFoundException;
}
