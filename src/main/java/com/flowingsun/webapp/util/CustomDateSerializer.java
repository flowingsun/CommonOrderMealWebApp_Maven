package com.flowingsun.webapp.util;

import java.io.IOException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import org.codehaus.jackson.JsonGenerator;  
import org.codehaus.jackson.JsonProcessingException;  
import org.codehaus.jackson.map.JsonSerializer;  
import org.codehaus.jackson.map.SerializerProvider;  
  
/** 
 * @description 返回自定义格式的日期Json对象 
 * @author flowingsun 
 */  
public class CustomDateSerializer extends JsonSerializer<Date> {  
  
    @Override  
    public void serialize(Date value,   
            JsonGenerator jsonGenerator,   
            SerializerProvider provider)  
            throws IOException, JsonProcessingException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        jsonGenerator.writeString(sdf.format(value));  
    }  
}  