## Домашнее задание к уроку 21. Мобильная автоматизация #2
1. Разработан демонстрационный автотест для проверки приложения Wikipedia.
2. Запуск возможен на разных стендах: browserstack, selenoid, local, emulated
3. Реализована настройка параметров через файл конфигурации credentials.properties
#### Параметры запуска из командной строки
```bash
gradle clean browserstack_tests
gradle clean emulated_tests
gradle clean local_tests
gradle clean selenoid_tests
```
