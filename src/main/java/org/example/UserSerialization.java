package org.example;


import org.example.http.HttpClientWrapper;
import org.example.http.HttpClientWrapperImpl;
import org.example.pojo.*;
import org.example.service.JsonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserSerialization {
    private static final Logger logger = LoggerFactory.getLogger(UserSerialization.class);

    public static void main(String[] args) {
        try {
            // Инициализация HTTP-клиента и сервиса
            HttpClientWrapper httpClientWrapper = new HttpClientWrapperImpl();
            JsonService jsonService = new JsonService(httpClientWrapper);

            // Создаем и заполняем объект Root
            Root root = createRootObject();

            // Сериализуем объект в JSON
            String json = jsonService.serializeToJson(root);

            // Отправляем POST-запрос и получаем ответ
            Response response = jsonService.sendPostRequest("https://httpbin.org/post", json);

            // Логируем извлеченные данные из ответа
            logger.info("Status: {}", response.getStatus());
            logger.info("Timestamp: {}", response.getData().getTimestamp());
            logger.info("Message: {}", response.getMessage());

        } catch (Exception e) {
            logger.error("Error occurred: ", e);
        }
    }

    private static Root createRootObject() {
        Root root = new Root();

        // Создаем и заполняем пользователей
        User user1 = new User();
        user1.setId(1);
        user1.setName("User1");
        user1.setEmail("user1@example.com");
        user1.setActive(true);
        user1.setAdditionalInfo(new AdditionalInfo("Developer", "Engineering"));

        User user2 = new User();
        user2.setId(2);
        user2.setName("User2");
        user2.setEmail("user2@example.com");
        user2.setActive(false);
        user2.setAdditionalInfo(new AdditionalInfo("Tester", "QA"));

        User user3 = new User();
        user3.setId(3);
        user3.setName("User3");
        user3.setEmail("user3@example.com");
        user3.setActive(true);
        user3.setAdditionalInfo(new AdditionalInfo("Manager", "Product"));

        // Добавляем пользователей в список
        root.setUsers(List.of(user1, user2, user3));

        // Заполняем настройки
        Settings settings = new Settings();
        settings.setTheme("dark");
        settings.setNotifications(true);
        settings.setLanguage("en-US");
        root.setSettings(settings);

        // Заполняем метаданные
        Metadata metadata = new Metadata();
        metadata.setCreatedAt("2025-03-22T18:31:00");
        metadata.setVersion("1.0.0");
        root.setMetadata(metadata);

        return root;
    }
}