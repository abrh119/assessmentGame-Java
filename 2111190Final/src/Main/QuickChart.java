package Main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * @author AbRh
 *
 */
public class QuickChart {
	

	public static String generateChart(int correct) {
		
				
			ArrayList<Integer> values = new ArrayList<Integer>();
			values.add(correct); 

		
			//stringbuilder to make the data in the form of json to generate chart		
			StringBuilder json = new StringBuilder();
			for(int i=0;i<values.size();i++)
			{
				json.append(values.get(i).toString()+",");
				System.out.println(values);
			}

			/* 
			 * Author: Quickchart.io 
			 * Availability: https://quickchart.io/documentation/
			 */	
			
			String chartConfigTemplate = "{" + 
					"\"type\": \"pie\"," +
					"\"data\": {" +
								"\"labels\": [\"Your score\"]," +
								"\"datasets\": [{" +
												"\"label\": \"Correct\"," +
												"\"label\": \"Wrong\"," +
												"\"data\": [ "+correct+", 3]" +
												"}]" +
					"}" +
					"}";
			 
			
		
			
			

			String chartConfig =
					chartConfigTemplate.replace("%DATA_VALUES%", values.toString());
			String chartUrl = null;
		try {
				chartUrl = "https://quickchart.io/chart?width=500&height=200&chart=" +
						URLEncoder.encode(chartConfig, "UTF-8");
		}catch(Exception ex) {}
			
			return chartUrl;

			
	}
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
};

