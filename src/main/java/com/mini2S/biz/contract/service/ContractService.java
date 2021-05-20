package com.mini2S.biz.contract.service;

import com.mini2S.biz.contract.model.dto.InsertContractDto;
import com.mini2S.model.response.CommonResult;

public interface ContractService {
    CommonResult insertContract(InsertContractDto dto, String featureDirectory);
}
