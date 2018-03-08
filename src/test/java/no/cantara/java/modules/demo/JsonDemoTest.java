package no.cantara.java.modules.demo;

import no.cantara.java.modules.json1.Owner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.slf4j.LoggerFactory.getLogger;

public class JsonDemoTest {
    private static final Logger log = getLogger(JsonDemoTest.class);

    private JsonDemo jsonDemo;
    private String expectedOwner = "{\"id\":\"testId1\",\"name\":\"testJsonOwner\"}";

    @BeforeMethod
    public void setUp() throws Exception {
        jsonDemo = new JsonDemo();

    }

    @Test
    public void testOwnerToJson() throws Exception {
        Owner owner = new Owner("testId1","testJsonOwner");
        String jsonOwner = jsonDemo.toJson(owner);
        JSONAssert.assertEquals(expectedOwner, jsonOwner,true);
    }
}