package no.cantara.java.modules.demo;

import no.cantara.java.modules.json1.Owner;
import no.cantara.java.modules.json1.OwnerMapper;
import no.cantara.java.modules.json1.OwnerMapperProxy;
import org.slf4j.Logger;

import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Demonstrate that Mapping do work with transient dependencies.
 * ObjectMapper in different versions.
 */
public class JsonDemo {
    private static final Logger log = getLogger(JsonDemo.class);

    private final OwnerMapper ownerMapper;

    public JsonDemo() {
        ownerMapper = new OwnerMapperProxy();
    }

    public static void main(String[] args) {
        JsonDemo demo = new JsonDemo();
        Owner owner = demo.createOwnerByName("mr IoT");
        log.trace("Owner is created and added, {}", owner);
        String jsonOwner = demo.toJson(owner);
        log.trace("Owner json: {}", jsonOwner);

    }

    String toJson(Owner owner) {
        return ownerMapper.toJson(owner);
    }

    Owner createOwnerByName(String name) {
        String ownerId = UUID.randomUUID().toString();
        Owner owner = new Owner(ownerId, name);
        return owner;
    }
}
