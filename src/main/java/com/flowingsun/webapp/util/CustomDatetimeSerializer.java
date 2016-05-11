package com.flowingsun.webapp.util;

import java.io.IOException;  
import java.text.SimpleDateFormat;  
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;  
  
/** 
 * @description 返回自定义格式的时间Json对象 
 * @author flowingsun 
 */  
public class CustomDatetimeSerializer extends JsonSerializer<Date> {  
  
    @Override  
    public void serialize(Date value,   
            JsonGenerator jsonGenerator,   
            SerializerProvider provider)  
            throws IOException, JsonProcessingException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        jsonGenerator.writeString(sdf.format(value));  
    }  
}  
