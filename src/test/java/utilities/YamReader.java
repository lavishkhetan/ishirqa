package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamReader {


	 public static String getValue(String token) throws FileNotFoundException {
	        Reader doc = new FileReader("D:"+File.separator+"assignment"+File.separator+"assignment"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testData"+File.separator+"database.yaml");//filepath
	        Yaml yaml = new Yaml();
	        Map<String, Object> object=(Map<String, Object>) yaml.load(doc);
	        return getMapValue(object, token);
	    }

	    public static String getMapValue(Map<String, Object> object, String token) {
	        String st[]=new String[10];
	    	return object.get(token).toString();
	    }



}
