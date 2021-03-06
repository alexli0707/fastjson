package com.alibaba.json.bvt;

import java.io.StringWriter;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSONWriter;

public class JSONWriterTest extends TestCase {

    public void test_0() throws Exception {
        StringWriter out = new StringWriter();

        JSONWriter writer = new JSONWriter(out);
        writer.writeStartObject();
        writer.writeEndObject();
        writer.flush();

        Assert.assertEquals("{}", out.toString());
    }

    public void test_1() throws Exception {
        StringWriter out = new StringWriter();

        JSONWriter writer = new JSONWriter(out);
        writer.writeStartObject();
        writer.writeKey("id");
        writer.writeValue(33);
        writer.writeEndObject();
        writer.flush();

        Assert.assertEquals("{\"id\":33}", out.toString());
    }

    public void test_2() throws Exception {
        StringWriter out = new StringWriter();

        JSONWriter writer = new JSONWriter(out);
        writer.writeStartObject();

        writer.writeKey("id");
        writer.writeValue(33);

        writer.writeKey("name");
        writer.writeValue("jobs");

        writer.writeEndObject();
        writer.flush();

        Assert.assertEquals("{\"id\":33,\"name\":\"jobs\"}", out.toString());
    }

    public void test_3() throws Exception {
        StringWriter out = new StringWriter();

        JSONWriter writer = new JSONWriter(out);
        writer.writeStartObject();

        writer.writeKey("id");
        writer.writeValue(33);

        writer.writeKey("name");
        writer.writeValue("jobs");

        writer.writeKey("children");
        writer.writeStartArray();

        writer.writeStartObject();
        writer.writeEndObject();

        writer.writeStartObject();
        writer.writeEndObject();

        writer.writeEndArray();

        writer.writeEndObject();
        writer.flush();

        Assert.assertEquals("{\"id\":33,\"name\":\"jobs\",\"children\":[{},{}]}", out.toString());
    }

    public void test_4() throws Exception {
        StringWriter out = new StringWriter();

        JSONWriter writer = new JSONWriter(out);

        writer.writeStartArray();

        writer.writeStartObject();
        writer.writeEndObject();

        writer.writeStartObject();
        writer.writeEndObject();

        writer.writeStartArray();
        writer.writeEndArray();
        {
            writer.writeStartArray();

            writer.writeStartArray();
            writer.writeEndArray();

            writer.writeStartArray();
            writer.writeEndArray();

            writer.writeEndArray();
        }

        writer.writeEndArray();

        writer.flush();

        Assert.assertEquals("[{},{},[],[[],[]]]", out.toString());
    }
}
