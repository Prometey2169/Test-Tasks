package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.pojo.company.Company;
import org.example.util.factory.CompanyFactory;

import java.io.StringWriter;

public class CompanyBuilder {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        // Передача ZIP-кодов как аргументов
        String firstZipCode = "10001";  // ZIP-код для офиса в Нью-Йорке
        String secondZipCode = "94107"; // ZIP-код для офиса в Сан-Франциско

        // Создание объекта Company с использованием фабрики
        Company company = CompanyFactory.buildCompany(firstZipCode, secondZipCode);

        // Преобразование объекта в JSON-строку
        String jsonString = formatJson(MAPPER, company);

        // Вывод полученного JSON на консоль
        System.out.println(jsonString);
    }

    public static String formatJson(ObjectMapper objectMapper, Object obj) throws Exception {
        StringWriter writer = new StringWriter();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE); // Включаем обертывание корневого значения
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, obj);
        return writer.toString();
    }
}