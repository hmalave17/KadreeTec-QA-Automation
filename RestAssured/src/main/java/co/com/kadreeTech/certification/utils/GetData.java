package co.com.kadreeTech.certification.utils;

import co.com.kadreeTech.certification.exceptions.DoesNotFindData;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {

    private GetData(){}

    public static List<Map<String, String>> deExcel(String rutaArchivo, String query) {
        List<Map<String, String>> listaDatos = new ArrayList<>();
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(rutaArchivo);
            Recordset recordset = connection.executeQuery(query);
            List<String> headers = recordset.getFieldNames();
            while (recordset.next()) {
                Map<String, String> dato = new HashMap<>();
                headers.forEach(value -> {
                    try {
                        dato.put(value, recordset.getField(value));
                    } catch (Exception ex) {
                        throw new DoesNotFindData();
                    }
                });
                listaDatos.add(dato);
            }
            recordset.close();
            connection.close();
        } catch (Exception ex) {
            throw new DoesNotFindData();
        }
        return listaDatos;
    }

}
