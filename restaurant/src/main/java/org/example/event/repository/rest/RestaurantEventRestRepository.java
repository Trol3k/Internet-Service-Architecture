package org.example.event.repository.rest;

import org.example.event.repository.api.RestaurantEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class RestaurantEventRestRepository implements RestaurantEventRepository {
    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public RestaurantEventRestRepository(RestTemplate template, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = template;
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    public void delete(UUID id) {
        String uri = loadBalancerClient.choose("pizza").getUri().toString();
        restTemplate.delete(uri + "/api/restaurants/{id}", id);
    }

    @Override
    public void create(UUID id) {
        String uri = loadBalancerClient.choose("pizza").getUri().toString();
        restTemplate.put(uri + "/api/restaurants/{id}", null, id);
    }

}
