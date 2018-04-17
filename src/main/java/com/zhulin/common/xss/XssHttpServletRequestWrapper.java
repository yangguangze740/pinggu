package com.zhulin.common.xss;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest originRequest;

    private static final HTMLFilter htmlFilter = new HTMLFilter();

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        this.originRequest = request;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (MediaType.APPLICATION_JSON_VALUE
                .equalsIgnoreCase(
                        super.getHeader(HttpHeaders.CONTENT_TYPE)
                )) {
            return super.getInputStream();
        }

        String jsonContent = IOUtils.toString(super.getInputStream(), CharEncoding.UTF_8);
        if (Strings.isNullOrEmpty(jsonContent)) {
            return super.getInputStream();
        }

        jsonContent = xssEncoding(jsonContent);

        final ByteArrayInputStream bais = new ByteArrayInputStream(jsonContent.getBytes(CharEncoding.UTF_8));

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return true;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(xssEncoding(name));

        if (!Strings.isNullOrEmpty(value)) {
            value = xssEncoding(value);
        }

        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameters = super.getParameterValues(name);

        if (!Optional.fromNullable(parameters).isPresent()) {
            return null;
        }

        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = xssEncoding(parameters[i]);
        }

        return parameters;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = new LinkedHashMap<>();
        Map<String, String[]> params = super.getParameterMap();

        Set<String> keySet = params.keySet();

        for (String key : keySet) {
            String[] values = params.get(key);

            for (int i = 0; i < values.length; i++) {
                values[i] = xssEncoding(values[i]);
            }

            map.put(key, values);
        }

        return map;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(xssEncoding(name));

        if (!Strings.isNullOrEmpty(value)) {
            value = xssEncoding(value);
        }

        return value;
    }

    private String xssEncoding(String source) {
        return htmlFilter.filter(source);
    }

    public HttpServletRequest getOriginRequest() {
        return this.originRequest;
    }

    public static HttpServletRequest getOrgRequest(HttpServletRequest request) {
        if (request instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) request).getOriginRequest();
        }

        return request;
    }
}
