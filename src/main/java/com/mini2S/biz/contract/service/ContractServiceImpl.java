package com.mini2S.biz.contract.service;

import com.mini2S.biz.contract.model.dto.InsertContractDto;
import com.mini2S.biz.contract.model.dto.SelectContractDto;
import com.mini2S.biz.contract.model.entity.Contract;
import com.mini2S.common.user.model.entity.Users;
import com.mini2S.common.util.qrcode.QrCode;
import com.mini2S.configuration.reposotory.ContractRepository;
import com.mini2S.configuration.reposotory.UsersRepository;
import com.mini2S.model.response.CommonResult;
import com.mini2S.service.ResponseService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class ContractServiceImpl implements ContractService{

    private final ContractRepository contractRepository;
    private final UsersRepository usersRepository;

    @Override
    public Contract insertContract(InsertContractDto dto, String featureDirectory) throws IOException {
        String qrImage = QrCode.createQRCodeImage(featureDirectory, String.valueOf(dto.getUserSeq())
                                                , dto.getUnitSeq() +"qrImage", "https://naver.com");
        return contractRepository.save(dto.toEntity(qrImage));
    }

    @Override
    public List<Contract> selectContractList(String userEmail) throws NotFoundException {
        Users users = usersRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new NotFoundException("계약하거나 예약한 계약이 없습니다."));
        log.info("ContractService > selectContractList > users : [{}]", users);
        return contractRepository.findAllByUsersUserSeqOrderByCreatedDate(users.getUserSeq());
    }
}
