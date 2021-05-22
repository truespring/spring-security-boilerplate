package com.mini2S.biz.contract.service;

import com.mini2S.biz.contract.model.dto.InsertContractDto;
import com.mini2S.biz.contract.model.entity.Contract;
import com.mini2S.common.util.qrcode.QrCode;
import com.mini2S.configuration.reposotory.ContractRepository;
import com.mini2S.model.response.CommonResult;
import com.mini2S.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContractServiceImpl implements ContractService{

    private final ContractRepository contractRepository;

    @Override
    public CommonResult insertContract(InsertContractDto dto, String featureDirectory) throws IOException {
        String qrImage = QrCode.createQRCodeImage(featureDirectory, String.valueOf(dto.getUserSeq())
                                                , dto.getUnitSeq() +"qrImage", "https://naver.com");
        return InsertContractDto.insertContractResponse(contractRepository.save(dto.toEntity(qrImage)));
    }
}
