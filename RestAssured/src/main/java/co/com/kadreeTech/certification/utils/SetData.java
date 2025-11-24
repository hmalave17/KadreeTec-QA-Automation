package co.com.kadreeTech.certification.utils;

import java.util.List;
import java.util.Map;

public class SetData {

    private SetData(){}

    public static List<Map<String, String>> test(String sheet, String scenario){
        List<Map<String, String>> datos;
        datos = GetData.deExcel(ConstantsExcel.PATH_FILE, String.format(ConstantsExcel.QUERY_EXCEL, sheet, scenario));
        return datos;
    }
}
