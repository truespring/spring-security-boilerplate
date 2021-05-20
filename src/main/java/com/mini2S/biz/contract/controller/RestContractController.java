package com.mini2S.biz.contract.controller;

import com.mini2S.biz.contract.model.dto.InsertContractDto;
import com.mini2S.biz.contract.service.ContractService;
import com.mini2S.configuration.reposotory.ContractRepository;
import com.mini2S.model.response.CommonResult;
import com.mini2S.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"5. Contract"})
@RequestMapping("/v1")
@RestController
@AllArgsConstructor
@Slf4j
public class RestContractController {

    private final ContractService contractService;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 AccessToken",
                    required = true,
                    dataType = "String",
                    paramType = "header"
            )
    })
    @PostMapping("/contract/insert")
    @ApiOperation(value = "지점에 해당하는 유닛 리스트 전달")
    public CommonResult insertContract(@RequestBody InsertContractDto dto, HttpServletRequest request) {
        log.info("path1 : [{}]", request.getRequestURI().split("/")[2]);
        log.info("InsertContractDto : [{}]", dto);
        return contractService.insertContract(dto ,request.getRequestURI().split("/")[2]);
    }
    /*
  {"branchSeq": 1,
  "contractStatus": "1",
  "priceDeposit": 100000,
  "priceDiscountUnit": 3000,
  "priceTotal": 30000,
  "priceUnit": 30000,
  "unitSeq": 1,
  "usageDay": "30",
  "usageMonth": "1",
  "useStartDttm": "2021-04-19",
  "useEndDttm": "2021-05-19",
  "userSeq": 1}

    * */
}
