package com.zandroid.filter;



import com.netflix.client.Utils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import static org.bouncycastle.cms.RecipientId.password;


@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("Logging from Zuul Filter");

        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getRequest().getRequestURL();

        String authString = "ollie" + ":" + "gierke";
        log.info("auth string: " + authString);
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        log.info("auth string: " + authStringEnc);

        ctx.addZuulRequestHeader("Authorization", "Basic " + authStringEnc);
        return null;

    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
