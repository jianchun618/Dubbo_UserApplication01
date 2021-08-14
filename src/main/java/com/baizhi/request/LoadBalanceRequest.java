package com.baizhi.request;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.net.URI;
import java.util.List;
import java.util.Random;

public class LoadBalanceRequest extends HttpRequestWrapper {
    private List<String> servers;

    public LoadBalanceRequest(HttpRequest request,List<String> servers) {
        super(request);
        this.servers=servers;
    }

    @Override
    public URI getURI() {
        URI uri = super.getURI();
        String url=uri.getScheme()+"://"+servers.get(new Random().nextInt(servers.size()))+uri.getPath()+"?"+uri.getQuery();
        System.out.println("url:"+url);
        URI u=URI.create(url);
        return u;
    }
}
