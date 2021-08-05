package com.taikang.exceltest.Test;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.taikang.exceltest.converter.LocalDateTimeConverter;
import com.taikang.exceltest.converter.LocalDateTimeConverter02;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class DrgOdlStStatmentMain implements Serializable {


    private static final long serialVersionUID = 3005282836696890109L;


    private String billId;


    private String regionId;


    private String patientId;


    private String patientSex;


    private LocalDate patientBirth;



    private String patientTypeId;


    @ColumnWidth(value= 20 )
    private String insuranceId;


    @ColumnWidth(value= 20 )
    private String medicalId;


    private LocalDate
            dateBill;


    private LocalDateTime dateFirst;

    private String hospitalId;


    private String hospitalName;

    private String billNo;



    private BigDecimal feeTotal;


    @ColumnWidth(value= 20 )
    private BigDecimal feeBmi;



    private BigDecimal feeLme;



    private BigDecimal feeCsmc;


    private BigDecimal feeDepart;


    private BigDecimal feeDisease;

    @ColumnWidth(value= 20 )

    private BigDecimal feePersonalAccount;


    private BigDecimal feePersonal;


    private BigDecimal feeEsmi;


    private String diagAdmissionName;


    private String diagAdmissionId;


    private String diagDischargeName;


    private String diagDischargeId;

    private String hospitalLevel;


    private String patientName;
    @ColumnWidth(value= 200 )
    private LocalDate dateAdmission;

    private LocalDate dateDischarge;

}

