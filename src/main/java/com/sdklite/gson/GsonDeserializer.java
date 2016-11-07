package com.sdklite.gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sdklite.io.Deserializer;
import com.sdklite.util.TypeResolver;

/**
 * Represents a deserializer realized by Gson
 * 
 * @author johnsonlee
 *
 * @param <T>
 *            The target type
 */
public class GsonDeserializer<T> implements Deserializer<T> {

    private final Type type;

    private final Gson gson = new GsonBuilder().create();

    /**
     * Default constructor
     */
    protected GsonDeserializer() {
        this.type = TypeResolver.getSuperclassTypeParameter(getClass());
    }

    /**
     * Instantialize with the target type
     * 
     * @param type
     *            The target type
     */
    public GsonDeserializer(final Type type) {
        this.type = type;
    }

    @Override
    public T deserialize(final InputStream in) throws IOException {
        return this.gson.fromJson(new InputStreamReader(in), this.type);
    }

}
