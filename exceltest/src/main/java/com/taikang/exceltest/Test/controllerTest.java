package com.taikang.exceltest.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @className controllerTest
 * @author:ShanXuerui
 * @date 2020/10/22 11:16
 */
@Controller
public class controllerTest {

    @RequestMapping("/find/one/zylsh/excel")
    public void export(HttpServletResponse response) {
        List<DrgOdlStStatmentMain> data = new ArrayList<>();
        DrgOdlStStatmentMain statmentMain = new DrgOdlStStatmentMain();
        statmentMain.setInsuranceId("1");
        statmentMain.setMedicalId("2");
        statmentMain.setFeePersonalAccount(new BigDecimal(100));
        data.add(statmentMain);
        try {
            DrgExcelUtil.writeExcel(response, data, "结算信息详情", "结算信息详情", DrgOdlStStatmentMain.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/**
 * @Author 单雪瑞
 * @Description 
 * @Date 14:53 2020/10/22
 * @Param [response]
 * @return void
 **/
    @RequestMapping ("/find/one/zylsh/excel02")
    public void export2(HttpServletResponse response) {
        //表头封装
        String[] srts = {"险种类型", "就诊方式", "人员类别", "结算时间", "入院时间", "出院时间", "总费用", "统筹基金", "大病保险",
                "公务员补助", "个人现金", "个人账户"};
        List<List<String>> head = DrgExcelUtil.head(srts);

        DrgOdlStStatmentMain drgOdlStStatmentMain = new DrgOdlStStatmentMain();
        drgOdlStStatmentMain.setInsuranceId("1111111111111111111111111111111111111111111111111111111111111111111111111?");
        drgOdlStStatmentMain.setMedicalId("222222222222222222222222222?");
        drgOdlStStatmentMain.setPatientTypeId("32");
        LocalDate localDate = LocalDate.now();
        drgOdlStStatmentMain.setDateAdmission(localDate);
        drgOdlStStatmentMain.setFeeBmi(new BigDecimal("200"));
        drgOdlStStatmentMain.setFeePersonalAccount(new BigDecimal("100"));

        List<Object> list = new ArrayList<Object>();
        list.add(drgOdlStStatmentMain.getInsuranceId());
        list.add(drgOdlStStatmentMain.getMedicalId());
        list.add(drgOdlStStatmentMain.getPatientTypeId());
        list.add(drgOdlStStatmentMain.getDateBill());
        list.add(drgOdlStStatmentMain.getDateAdmission());
        list.add(drgOdlStStatmentMain.getDateDischarge());
        list.add(drgOdlStStatmentMain.getFeeTotal());
        list.add(drgOdlStStatmentMain.getFeeBmi());
        list.add(drgOdlStStatmentMain.getFeeLme());
        list.add(drgOdlStStatmentMain.getFeeCsmc());
        list.add(drgOdlStStatmentMain.getFeePersonal());
        list.add(drgOdlStStatmentMain.getFeePersonalAccount());
        List<List<Object>> data = new ArrayList<>();
        data.add(list);
        try {
            DrgExcelUtil.dynamicHeadWrite(response, data, "结算信息详情", "结算信息详情", head);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
