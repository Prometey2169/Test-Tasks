package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.pojo.company.Company;
import org.example.util.factory.CompanyFactory;

import java.io.IOException;
import java.io.StringWriter;

public class CompanyBuilder {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String serialization(String firstZipCode, String secondZipCode) {


        Company company = CompanyFactory.buildCompany(firstZipCode, secondZipCode);


        try {
            String jsonString = formatJson(MAPPER, company);
            System.out.println(jsonString);
            return jsonString;
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static String formatJson(ObjectMapper objectMapper, Object obj) {
        StringWriter writer = new StringWriter();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, obj);
            return writer.toString();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
        return null;
    }
}