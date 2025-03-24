import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.CompanyBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONComparisonTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void compareJsonFiles() {

        String firstZipCode = "10001";  // ZIP-код для офиса в Нью-Йорке
        String secondZipCode = "94107"; // ZIP-код для офиса в Сан-Франциско
        String serialiedjson = CompanyBuilder.serialization(firstZipCode,secondZipCode);

        File expectedJsonFile = new File("src/test/resources/expected.json");

        try {
            String expectedJson = String.valueOf(objectMapper.readTree(expectedJsonFile));
            assertEquals(expectedJson, serialiedjson, "JSON файлы не совпадают!");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }


    }
}

