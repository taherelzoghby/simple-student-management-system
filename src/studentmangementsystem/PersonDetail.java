
package studentmangementsystem;

import java.util.HashMap;

public class PersonDetail {
    private final HashMap<String,Object> properties;

    public PersonDetail(HashMap prope_S) {
        this.properties = new HashMap();
        properties.putAll(prope_S);
    }

     public Object getProperties(String key) {
         if(properties==null){
             return null;
         }
        return properties.get(key);
    }
    public HashMap getProperties() {
        if(properties==null){
             return null;
         }
        return properties;
    }

    @Override
    public String toString() {
        return "properties : " + properties.entrySet();
    }
    
}
