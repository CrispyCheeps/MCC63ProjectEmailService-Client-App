package co.id.mailservice.clientapp.config;

import org.springframework.http.HttpRequest;
import co.id.mailservice.clientapp.utility.RequestHeader;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

import java.io.IOException;

public class RestTemplateInterceptorHeader implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if(RequestHeader.getAuth() != null
                && !(RequestHeader.getAuth() instanceof AnonymousAuthenticationToken)) {
            request.getHeaders().addAll(RequestHeader.createHeaders());
        }

        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
