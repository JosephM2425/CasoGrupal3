package bl;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class APIConector {
	private String baseUrl = "http://eeds.club/BISOFT-12/";
	private String usr = "USUARIO";
	private String pwd = "CLAVE";

	public String getAPIURL(String pQuery) {
		return baseUrl +
				"?usuario=" + URLEncoder.encode(usr, StandardCharsets.UTF_8) +
				"&clave=" + URLEncoder.encode(pwd, StandardCharsets.UTF_8) +
				"&query=" + URLEncoder.encode(pQuery, StandardCharsets.UTF_8);
	}

	public HttpResponse<String> EjecutarLlamado(String encodedURL) throws IOException, InterruptedException{
		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(encodedURL))
				.header("Content-Type", "application/json")
				.GET()
				.build();

		return httpClient.send(request, BodyHandlers.ofString());
	}
	public String insertQuery(String pTabla, String pCampos, String pValores) {
		return "INSERT INTO " + pTabla + " (" + pCampos + ") VALUES (" + pValores + ")";
	}
	public String selectQuery(String pTabla) {
		return "SELECT * FROM " + pTabla;
	}
	public String selectQueryFrom(String pCampos, String pTabla) {
		return "SELECT " + pCampos + " FROM " + pTabla;
	}
	public String selectQueryWhere(String pCampos, String pTabla, String pCondicion) {
		return "SELECT " + pCampos + " FROM " + pTabla + " WHERE " + pCondicion;
	}
	public String updateQuery(String pTabla, String pCampos, String pCondicion) {
		return "UPDATE " + pTabla + " SET " + pCampos + " WHERE " + pCondicion;
	}
	public String deleteQuery(String pTabla, String pCondicion) {
		return "DELETE FROM " + pTabla + " WHERE " + pCondicion;
	}
}
