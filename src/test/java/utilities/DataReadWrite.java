package utilities;

import java.util.Properties;

public class DataReadWrite {
	 public static String getProperty(String Property) {
	        try {
	            Properties prop = ResourceLoader.loadProperties("./Config.properties");
	            return prop.getProperty(Property);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }
	    

}
