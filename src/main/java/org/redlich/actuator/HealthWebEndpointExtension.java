package org.redlich.actuator;

import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthStatusHttpMapper;
import org.springframework.boot.endpoint.ReadOperation;
import org.springframework.boot.endpoint.web.WebEndpointExtension;
import org.springframework.boot.endpoint.web.WebEndpointResponse;

@WebEndpointExtension(endpoint = HealthEndpoint.class)
public class HealthWebEndpointExtension {

    private final HealthEndpoint delegate;

    private final HealthStatusHttpMapper statusHttpMapper;

    public HealthWebEndpointExtension(HealthEndpoint delegate,HealthStatusHttpMapper statusHttpMapper) {
        this.delegate = delegate;
        this.statusHttpMapper = statusHttpMapper;
        }

    @ReadOperation
    public WebEndpointResponse<Health> getHealth() {
        Health health = this.delegate.health();
        Integer status = this.statusHttpMapper.mapStatus(health.getStatus());
        return new WebEndpointResponse<>(health,status);
        }
    }
