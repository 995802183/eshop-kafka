package com.wyw.eshop.kafka.vo;

public class ParamVo {
    private String requestModule;
    private String headers;
    private String uriArgs;
    private String httpVersion;
    private String method;
    private String rawHeader;
    private String bodyData;

    public ParamVo(String requestModule, String headers, String uriArgs, String httpVersion, String method, String rawHeader, String bodyData) {
        this.requestModule = requestModule;
        this.headers = headers;
        this.uriArgs = uriArgs;
        this.httpVersion = httpVersion;
        this.method = method;
        this.rawHeader = rawHeader;
        this.bodyData = bodyData;
    }

    public String getRequestModule() {
        return requestModule;
    }

    public void setRequestModule(String requestModule) {
        this.requestModule = requestModule;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getUriArgs() {
        return uriArgs;
    }

    public void setUriArgs(String uriArgs) {
        this.uriArgs = uriArgs;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRawHeader() {
        return rawHeader;
    }

    public void setRawHeader(String rawHeader) {
        this.rawHeader = rawHeader;
    }

    public String getBodyData() {
        return bodyData;
    }

    public void setBodyData(String bodyData) {
        this.bodyData = bodyData;
    }

    @Override
    public String toString() {
        return "ParamVo{" +
                "requestModule='" + requestModule + '\'' +
                ", headers='" + headers + '\'' +
                ", uriArgs='" + uriArgs + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                ", method='" + method + '\'' +
                ", rawHeader='" + rawHeader + '\'' +
                ", bodyData='" + bodyData + '\'' +
                '}';
    }
}
