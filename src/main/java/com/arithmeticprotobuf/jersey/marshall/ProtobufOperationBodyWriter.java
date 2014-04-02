package com.arithmeticprotobuf.jersey.marshall;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.arithmeticprotobuf.domain.Operations.OperationData;
import com.google.protobuf.GeneratedMessage;

@Provider
@Produces("application/x-protobuf")
public  class ProtobufOperationBodyWriter implements MessageBodyWriter<OperationData> {
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return OperationData.class.isAssignableFrom(type);
    }

    private Map<Object, byte[]> buffer = new WeakHashMap<Object, byte[]>();

    public long getSize(OperationData m, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            m.writeTo(baos);
        } catch (IOException e) {
            return -1;
        }
        byte[] bytes = baos.toByteArray();
        buffer.put(m, bytes);
        return bytes.length;
    }

    public void writeTo(OperationData m, Class type, Type genericType, Annotation[] annotations, 
                MediaType mediaType, MultivaluedMap httpHeaders,
                OutputStream entityStream) throws IOException, WebApplicationException {
        entityStream.write(buffer.remove(m));
    }
}
