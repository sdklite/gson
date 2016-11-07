package com.sdklite.gson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdklite.io.Serializer;

/**
 * Represents a serializer realized by Gson
 * 
 * @author johnsonlee
 *
 */
public class GsonSerializer implements Serializer<Object> {

    private final Gson gson;

    /**
     * Default constructor
     */
    public GsonSerializer() {
        this.gson = new GsonBuilder().create();
    }

    @Override
    public InputStream serialize(final Object value) throws IOException {
        return new ByteArrayInputStream(this.gson.toJson(value).getBytes());
    }

}
