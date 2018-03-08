package no.cantara.java.modules.demo;

import no.cantara.java.modules.json1.Owner;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Create a Ting.
 * Create an Owner.
 * Set Owner as owner of thing.
 */
public class Demo {
    private static final Logger log = getLogger(Demo.class);

    private HashMap<String, Owner> owners;

    public Demo() {
        owners = new HashMap<>();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Owner owner = demo.createOwnerByName("mr IoT");
        log.trace("Owner is created and added, {}", demo.getOwner(owner.getId()));

    }

    Owner createOwnerByName(String name) {
        String ownerId = UUID.randomUUID().toString();
        Owner owner = new Owner(ownerId, name);
        addOwner(owner);
        return owner;
    }

    void addOwner(Owner owner) {
        owners.put(owner.getId(), owner);
    }

    Owner getOwner(String ownerId) {
        return owners.get(ownerId);
    }

    public boolean hasDefaultThingAnOwner() {
        return true;
    }
}
