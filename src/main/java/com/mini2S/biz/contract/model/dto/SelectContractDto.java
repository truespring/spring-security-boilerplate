package com.mini2S.biz.contract.model.dto;

import com.mini2S.biz.contract.model.entity.Contract;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class SelectContractDto {
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
    private String contractQrImage;

    public static SelectContractDto of(Contract contract){
        return SelectContractDto.builder()
                .userSeq(contract.getUsers().getUserSeq())
                .branchSeq(contract.getBranch().getBranchSeq())
                .unitSeq(contract.getUnit().getUnitSeq())
                .contractStatus(contract.getContractStatus())
                .usageMonth(contract.getUsageMonth())
                .usageDay(contract.getUsageDay())
                .useStartDttm(String.valueOf(contract.getUseStartDttm()))
                .useEndDttm(String.valueOf(contract.getUseEndDttm()))
                .priceUnit(contract.getPriceUnit())
                .priceDiscountUnit(contract.getPriceDiscountUnit())
                .priceDeposit(contract.getPriceDeposit())
                .priceTotal(contract.getPriceTotal())
                .contractQrImage(contract.getContractQrImage())
                .build();
    }
}
