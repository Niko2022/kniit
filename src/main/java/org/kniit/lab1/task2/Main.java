package org.kniit.lab1.task2;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main(String[] args) {
        String urlString = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        try {
            URL url = new URL(urlString);

            SimpleUrl simpleUrl = new SimpleUrl();
            simpleUrl.setFullUrl(urlString);

            // Основные части URL
            simpleUrl.setProtocol(url.getProtocol());      // https
            simpleUrl.setAddress(url.getHost());           // test.ru
            simpleUrl.setPath(url.getPath());              // /test/1072/page.jsp
            simpleUrl.setQuery(url.getQuery());            // строка после ?

            // Разбор host на имя сайта и доменную зону
            String host = url.getHost();                   // test.ru
            String[] hostParts = host.split("\\.");
            if (hostParts.length >= 2) {
                simpleUrl.setSiteName(hostParts[0]);       // test
                simpleUrl.setDomainZone(hostParts[hostParts.length - 1]); // ru
            }

            // Разбор пути на имя файла и расширение
            String path = url.getPath();                   // /test/1072/page.jsp
            int lastSlash = path.lastIndexOf('/');
            if (lastSlash >= 0 && lastSlash < path.length() - 1) {
                String fileName = path.substring(lastSlash + 1); // page.jsp
                simpleUrl.setWebpageName(fileName);
                int dotIndex = fileName.lastIndexOf('.');
                if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
                    simpleUrl.setWebPageExtension(fileName.substring(dotIndex + 1)); // jsp
                }
            }

            // Разбор параметров запроса
            Map<String, String> params = parseQuery(url.getQuery());
            if (params.containsKey("intParam")) {
                simpleUrl.setIntParam(Integer.parseInt(params.get("intParam")));
            }
            if (params.containsKey("doubleParam")) {
                simpleUrl.setDoubleParam(Double.parseDouble(params.get("doubleParam")));
            }
            if (params.containsKey("textParameter")) {
                simpleUrl.setTextParameter(params.get("textParameter"));
            }

            // Вывод на экран
            System.out.println(simpleUrl.toString());

        } catch (MalformedURLException e) {
            System.out.println("Неверный формат URL: " + e.getMessage());
        }
    }

    // Вспомогательный метод для разбора query-строки
    private static Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();
        if (query == null || query.isEmpty()) {
            return result;
        }

        String[] pairs = query.split("&");
        for (String pair : pairs) {
            String[] kv = pair.split("=", 2);
            String key = kv[0];
            String value = kv.length > 1 ? kv[1] : "";
            result.put(key, value);
        }
        return result;
    }
}
