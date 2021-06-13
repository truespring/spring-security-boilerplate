package com.mini2S.biz.contract.model.dto;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.contract.model.entity.Contract;
import com.mini2S.biz.unit.model.entity.Unit;
import com.mini2S.common.user.model.entity.Users;
import com.mini2S.common.util.time.TimeFormat;
import com.mini2S.model.response.CommonResult;
import com.mini2S.service.ResponseService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertContractDto {
    private Long userSeq;
    private Long branchSeq;
    private Long unitSeq;
    private String contractStatus;
    private String usageMonth;
    private String usageDay;
    private String useStartDttm;
    private String useEndDttm;
    private Long priceUnit;
    private Long priceDiscountUnit;
    private Long priceDeposit;
    private Long priceTotal;

    public Contract toEntity(String qrImage){
        return Contract.builder()
                .users(Users.builder().userSeq(userSeq).build())
                .branch(Branch.builder().branchSeq(branchSeq).build())
                .unit(Unit.builder().unitSeq(unitSeq).build())
                .contractQrImage(qrImage)
                .contractStatus(contractStatus)
                .usageMonth(usageMonth)
                .useStartDttm(TimeFormat.ConvertDttm(useStartDttm, "1"))
                .usageDay(usageDay)
                .useEndDttm(TimeFormat.ConvertDttm(useEndDttm, "1"))
                .priceUnit(priceUnit)
                .priceDiscountUnit(priceDiscountUnit)
                .priceDeposit(priceDeposit)
                .priceTotal(priceTotal)
                .build();
    }
    public static InsertContractDto of(Contract contract){
        return InsertContractDto.builder()
                    .userSeq(contract.getUsers().getUserSeq())
                    .branchSeq(contract.getBranch().getBranchSeq())
                    .unitSeq(contract.getUnit().getUnitSeq())
                    .contractStatus(contract.getContractStatus())
                    .usageMonth(contract.getUsageMonth())
                    .useStartDttm(String.valueOf(contract.getUseStartDttm()))
                    .usageDay(contract.getUsageDay())
                    .useEndDttm(String.valueOf(contract.getUseEndDttm()))
                    .priceUnit(contract.getPriceUnit())
                    .priceDiscountUnit(contract.getPriceDiscountUnit())
                    .priceDeposit(contract.getPriceDeposit())
                    .priceTotal(contract.getPriceTotal())
                    .build();
    }
}
