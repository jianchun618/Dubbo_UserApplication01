package com.baizhi.urlinterceptors;

import com.baizhi.request.LoadBalanceRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;

/**
 * 添加拦截器拦截请求，对请求进行处理，
 * 将配置文件中的配置进行替换--修改用户访问的 URL。
 */
public class URLInterceptor implements ClientHttpRequestInterceptor {
    private List<String> servers;

    public URLInterceptor(List<String> servers) {
        this.servers = servers;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {

        return execution.execute(new LoadBalanceRequest(request, servers), body);
    }
}
