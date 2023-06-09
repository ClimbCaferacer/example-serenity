package starter.api.cars.get.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetCarsResponseItem{

	@JsonProperty("image")
	private String image;

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("provider")
	private String provider;

	@JsonProperty("price")
	private double price;

	@JsonProperty("title")
	private String title;

	@JsonProperty("promoDetails")
	private String promoDetails;

	@JsonProperty("brand")
	private String brand;

	@JsonProperty("isPromo")
	private boolean isPromo;

	@JsonProperty("url")
	private String url;
}