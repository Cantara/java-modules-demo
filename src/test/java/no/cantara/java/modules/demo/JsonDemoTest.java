package no.cantara.java.modules.demo;

import no.cantara.java.modules.json1.Owner;
import no.cantara.java.modules.json2.Thing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.slf4j.LoggerFactory.getLogger;

public class JsonDemoTest {
    private static final Logger log = getLogger(JsonDemoTest.class);

    private JsonDemo jsonDemo;
    private final String expectedOwner = "{\"id\":\"testId1\",\"name\":\"testJsonOwner\"}";
    private final String expectedThing = "{\"id\":\"testThingId1\",\"name\":\"Hello Cantara\",\"tags\":[\"test\"],\"ownerId\":\"testId1\"}";

    private Owner owner;
    @BeforeMethod
    public void setUp() throws Exception {
        jsonDemo = new JsonDemo();
        owner = new Owner("testId1","testJsonOwner");

    }

    @Test
    public void testOwnerToJson() throws Exception {
        String jsonOwner = jsonDemo.toJson(owner);
        JSONAssert.assertEquals(expectedOwner, jsonOwner,true);
    }

    @Test
    public void testThingToJson() throws Exception {
        Thing thing = new Thing("testThingId1", "Hello Cantara", "test", owner.getId() );
        String jsonThing = jsonDemo.toJson(thing);
        JSONAssert.assertEquals(expectedThing, jsonThing,true);
    }
}