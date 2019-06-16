package json_placeholder_spring_service;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Client {

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public Client() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null, null, null);
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setSSLContext(context).build();
            HttpComponentsClientHttpRequestFactory factory
                    = new HttpComponentsClientHttpRequestFactory(httpClient);
            restTemplate = new RestTemplate(factory);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

    }

    public <ReqType, ResType> ResponseEntity<ResType> sendRequest(String url,
                                                                   HttpMethod method, ReqType body,
                                                                   Class<ResType> responseType) {
        HttpEntity<ReqType> entity = new HttpEntity<>(body, headers);

        return restTemplate.exchange(url, method, entity, responseType);
    }

}
