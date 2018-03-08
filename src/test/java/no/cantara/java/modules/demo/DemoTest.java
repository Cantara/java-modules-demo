package no.cantara.java.modules.demo;

import no.cantara.java.modules.json1.Owner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DemoTest {

    private Demo demo;

    @BeforeMethod
    public void setUp() throws Exception {
        demo = new Demo();
    }

    @Test
    public void createOwnerByName() {
        Owner owner = demo.createOwnerByName("testMe");
        assertNotNull(owner);
        Owner fetchedOwner = demo.getOwner(owner.getId());
        assertNotNull(fetchedOwner);
        assertEquals(fetchedOwner.getName(), "testMe");
    }

    @Test
    public void thingHasOwner() {
        assertTrue(demo.hasDefaultThingAnOwner());
    }
}