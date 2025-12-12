package org.kniit.lab1.task2;

public class SimpleUrl {

    // Основные части URL
    private String protocol;          // https
    private String address;           // test.ru
    private String domainZone;        // ru
    private String siteName;          // test
    private String webpageName;       // page.jsp (полное имя файла)
    private String webPageExtension;  // jsp
    private String path;              // /test/1072/page.jsp
    private String fullUrl;           // исходный URL

    // Параметры запроса
    private Integer intParam;         // 12345
    private Double doubleParam;       // 3.14
    private String textParameter;     // someText
    private String query;             // intParam=12345&doubleParam=3.14&textParameter=someText

    // Геттеры и сеттеры
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebPageExtension() {
        return webPageExtension;
    }

    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtension = webPageExtension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Integer getIntParam() {
        return intParam;
    }

    public void setIntParam(Integer intParam) {
        this.intParam = intParam;
    }

    public Double getDoubleParam() {
        return doubleParam;
    }

    public void setDoubleParam(Double doubleParam) {
        this.doubleParam = doubleParam;
    }

    public String getTextParameter() {
        return textParameter;
    }

    public void setTextParameter(String textParameter) {
        this.textParameter = textParameter;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    // Переопределение toString()
    @Override
    public String toString() {
        return "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtention = " + webPageExtension + "\n" +
                "path = " + path + "\n" +
                "query = " + query + "\n" +
                "intParam = " + intParam + "\n" +
                "doubleParam = " + doubleParam + "\n" +
                "textParameter = " + textParameter + "\n" +
                "fullUrl = " + fullUrl;
    }
}
