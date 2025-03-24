import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONComparisonTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void compareJsonFiles() throws IOException {
        // Путь к актуальному JSON
        File actualJsonFile = new File("src/test/resources/actual.json");

        // Путь к исходному JSON (эталонному)
        File expectedJsonFile = new File("src/test/resources/expected.json");

        // Чтение JSON-файлов в виде JsonNode
        JsonNode actualJson = objectMapper.readTree(actualJsonFile);
        JsonNode expectedJson = objectMapper.readTree(expectedJsonFile);

        // Сравнение JSON-объектов
        assertEquals(expectedJson, actualJson, "JSON файлы не совпадают!");
    }
}

