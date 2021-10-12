package com.techienotes.movieconsumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@Slf4j
public class LoadBalancerConfiguration {

/* TODO: This is to be used if Single instance service is required
    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(ConfigurableApplicationContext context) {
        log.info("Configuring Load balancer to use the same instance");
        return ServiceInstanceListSupplier.builder()
                .withDiscoveryClient()
                .withSameInstancePreference()
                .build(context);
    }
    @Bean
    public ReactiveDiscoveryClient getReactiveClient(ServiceDiscovery<ZookeeperInstance> serviceDiscovery, ZookeeperDependencies zookeeperDependencies, ZookeeperDiscoveryProperties zookeeperDiscoveryProperties) {
        return new ZookeeperReactiveDiscoveryClient(serviceDiscovery, zookeeperDependencies, zookeeperDiscoveryProperties);
    }
*/

    @Bean
    ReactorLoadBalancer<ServiceInstance> roundRobinLoadBalancer(Environment environment,
                                                                LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RoundRobinLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(name, ServiceInstanceListSupplier.class),
                name);
    }
}
