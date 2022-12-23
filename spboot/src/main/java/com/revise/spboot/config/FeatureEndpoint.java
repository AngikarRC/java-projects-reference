package com.revise.spboot.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import javax.websocket.ClientEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class FeatureEndpoint {
    private final Map<String,Feature> featureMap =
            new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featureMap.put("Department",new Feature(true));
        featureMap.put("User",new Feature(false));
        featureMap.put("Authorization",new Feature(false));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature{
        private boolean isEnabled;
    }

    @ReadOperation
    public Map<String,Feature> getFeatures(){
        return  featureMap;
    }

    @ReadOperation
    public Feature getFeature(@Selector String featureName){
        return featureMap.get(featureName);
    }
}
