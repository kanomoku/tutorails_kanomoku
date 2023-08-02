package javabasic.enumprac.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DistanceSerializer extends StdSerializer<Distance> {

    public DistanceSerializer() {
        super(Distance.class);
    }

    @Override
    public void serialize(Distance distance, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(distance.name());
        jsonGenerator.writeFieldName("unit");
        jsonGenerator.writeString(distance.getUnit());
        jsonGenerator.writeFieldName("meters");
        jsonGenerator.writeNumber(distance.getMeters());
        jsonGenerator.writeEndObject();
    }
}