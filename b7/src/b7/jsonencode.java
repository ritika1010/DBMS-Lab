package b7;

import org.json.simple.JSONObject;

public class jsonencode {
	public void encode(){
		 JSONObject o1 = new JSONObject();
		  o1.put("name", "Alex");
		  o1.put("roll", new Integer(12));
		  o1.put("total_marks", new Double(684.50));
		  o1.put("pass", new Boolean(true));
		  System.out.println(o1);
	}
}
