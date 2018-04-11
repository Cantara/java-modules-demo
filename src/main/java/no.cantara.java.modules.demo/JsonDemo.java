package no.cantara.java.modules.demo;

import no.cantara.java.modules.json1.Owner;
import no.cantara.java.modules.json1.OwnerMapper;
import no.cantara.java.modules.json1.OwnerMapperProxy;
import no.cantara.java.modules.json2.Thing;
import no.cantara.java.modules.json2.ThingMapper;
import no.cantara.java.modules.json2.ThingMapperProxy;
import org.slf4j.Logger;

import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Demonstrate that Mapping do work with transient dependencies.
 * ObjectMapper in different versions of jackson-databind.
 */
public class JsonDemo {
    private static final Logger log = getLogger(JsonDemo.class);

    private final OwnerMapper ownerMapper;
    private final ThingMapper thingMapper;

    public JsonDemo() {
        ownerMapper = new OwnerMapperProxy();
        thingMapper = new ThingMapperProxy();
    }

    public static void main(String[] args) {
        JsonDemo demo = new JsonDemo();
        Owner owner = demo.createOwnerByName("mr IoT");
        log.trace("Owner is created , {}", owner);
        String jsonOwner = demo.toJson(owner);
        log.trace("Owner json: {}", jsonOwner);
        Thing thing = demo.createThing("Hello Cantara", owner);
        log.trace("Ting is created, {}", thing);
        String jsonThing = demo.toJson(thing);
        log.trace("Thing Json: {}", jsonThing);

    }

    String toJson(Owner owner) {
        return ownerMapper.toJson(owner);
    }

    String toJson(Thing thing) {
        return thingMapper.toJson(thing);
    }

    Owner createOwnerByName(String name) {
        String ownerId = UUID.randomUUID().toString();
        Owner owner = new Owner(ownerId, name);
        return owner;
    }

    Thing createThing(String name, Owner owner) {
        String thingId = UUID.randomUUID().toString();
        String ownerId = owner.getId();
        Thing thing = new Thing(thingId, name, "test", ownerId);
        return thing;
    }
}
