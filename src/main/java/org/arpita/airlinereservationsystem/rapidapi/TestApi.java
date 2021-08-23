package org.arpita.airlinereservationsystem.rapidapi;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.arpita.airlinereservationsystem.models.Flight;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class TestApi {
	private static final String skyScannerUri = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com"
			+ "/apiservices/browseroutes/v1.0/%s/%s/en-US/%s/%s/%s";	
	private static final String skyScannerKey = "0aa429a5c2msh931126511a63411p1d2597jsn77f0d39e0b5f";
	private static final String skyScannerHost = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

	private static final String country = "US";
	private static final String currency = "USD";
	private static final String suffix = "-sky";

	private static Flight flight;
	
//	public TestApi() throws JSONException, IOException, InterruptedException {
//		JSONObject obj = new JSONObject(new TestApi().search("SFO", "LAX", "2021-09-01").toString());
//	}
	



	public static void main(String[] args) throws IOException, InterruptedException {
				System.out.println(new TestApi().search("SFO", "LAX", "2021-09-01").toString());

		JSONObject obj = new JSONObject(new TestApi().search("SFO", "SEA", "2021-09-01").toString());
		JSONArray arr = obj.getJSONArray("Quotes");

		int MinPrice = (int) arr.getJSONObject(0).get("MinPrice");
		System.out.println(MinPrice);
		System.out.println(arr.length());
		JSONArray arr2 = obj.getJSONArray("Places");

		Object src = arr2.getJSONObject(0).get("CityName");
		Object destination = arr2.getJSONObject(1).get("CityName");

		System.out.println(src);
		System.out.println(destination);
		System.out.println(arr2.length());

		JSONArray arr3 = obj.getJSONArray("Carriers");

		Object flightNo = arr3.getJSONObject(0).get("CarrierId");
		System.out.println(flightNo);
		
//		flight.setSource(src);


	}
	
	public Iterable<Object> parseApi(JSONObject obj){
//		Iterable<Object> list = ArrayList<>();
		JSONArray arr = obj.getJSONArray("Quotes");

		//	            int MinPrice = (int) arr.getJSONObject(0).get("MinPrice");
		//	            System.out.println(MinPrice);
		System.out.println(arr.length());
		JSONArray arr2 = obj.getJSONArray("Places");


		Object src =  arr2.getJSONObject(0).get("CityName");
		Object destination =  arr2.getJSONObject(1).get("CityName");
		
		System.out.println(src);
		System.out.println(destination);
		System.out.println(arr2.length());
		
		JSONArray arr3 = obj.getJSONArray("Carriers");
		
		Object flightNo = arr3.getJSONObject(0).get("CarrierId");
		System.out.println(flightNo);
		return null;
		
	}
	
	
	private String search(final String origin, final String destination, final String outBoundDate) 
			throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(String.format(skyScannerUri, country, currency, origin + suffix, destination + suffix, outBoundDate)))
				.header("x-rapidapi-key", skyScannerKey)
				.header("x-rapidapi-host", skyScannerHost)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();

		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	
	
}
