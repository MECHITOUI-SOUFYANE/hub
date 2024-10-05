package com.alten.configuration;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelCastConfiguration {

    private static final String CLUSTER_NAME_HAZELCAST= "HAZELCAST-HUB";
    private static final String INSTANCE_NAME_HAZELCAST= "hazelcast_instance";
    @Bean
    public Config cacheConfig() {
        Config config = new Config();
        config.setClusterName(CLUSTER_NAME_HAZELCAST);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.setInstanceName(INSTANCE_NAME_HAZELCAST);
        config.addMapConfig(rajouterConfig("products",1000,0));
        return config;
    }


    private MapConfig rajouterConfig(String nomCache, int taille, int tempsDeVie){
        return new MapConfig()
                .setName(nomCache)
                .setTimeToLiveSeconds(tempsDeVie)
                .setEvictionConfig(new EvictionConfig()
                        .setSize(taille)
                        .setMaxSizePolicy(MaxSizePolicy.PER_NODE)
                        .setEvictionPolicy(EvictionPolicy.LFU));
    }

}
