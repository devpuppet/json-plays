package json_placeholder_spring_service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Client {

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public Client() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate = new RestTemplate();
    }

    public <ReqType, ResType> ResponseEntity<ResType> sendRequest(
            String url, HttpMethod method, ReqType body, Class<ResType> responseType) {

        HttpEntity<ReqType> entity = new HttpEntity<>(body, headers);

        return restTemplate.exchange(url, method, entity, responseType);
    }

}
