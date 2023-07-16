package com.nopcommerce.learning;

import utilities.ExcelUtils;
import java.io.IOException;

import commons.GlobalConstants;

public class Level_21_Manage_Data_5 {
    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = GlobalConstants.RESOURCE_PATH + "user-information.xlsx";

    public static  void main(String args[]) throws IOException {
        excelUtils.setExcelFile(excelFilePath,"dev");
        System.out.println(excelUtils.getCellData(1, 1));
        System.out.println(excelUtils.getCellData(2, 1));
        System.out.println(excelUtils.getCellData(3, 1));
        System.out.println(excelUtils.getCellData(4, 1));
        
    }
}