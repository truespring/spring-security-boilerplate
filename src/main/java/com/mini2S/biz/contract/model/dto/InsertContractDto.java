package com.mini2S.biz.contract.model.dto;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.contract.model.entity.Contract;
import com.mini2S.biz.unit.model.entity.Unit;
import com.mini2S.common.user.model.entity.Users;
import com.mini2S.common.util.time.TimeFormat;
import lombok.Data;
import lombok.ToString;

@Data
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

    public Contract toEntity(){
        return Contract.builder()
                .userSeq(Users.builder().userSeq(userSeq).build())
                .branchSeq(Branch.builder().branchSeq(branchSeq).build())
                .unitSeq(Unit.builder().unitSeq(unitSeq).build())
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
}
