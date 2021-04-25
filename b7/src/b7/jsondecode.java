package b7;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class jsondecode {
 public void decode() {
  String s = "{\"name\":\"Alex\",\"marks\":648.50,\"roll\":12}";
  Object o1 = JSONValue.parse(s);
  JSONObject jsonObj = (JSONObject) o1;
  String name = (String) jsonObj.get("name");
Long roll = (Long) jsonObj.get("roll");
Double marks=(Double)jsonObj.get("marks");
  System.out.println(name + " " +  " "+roll+"  "+marks);
 }
}