package projectDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.http.*;
public class GetApiToPdf {
    public static void main(String[] args) {
        // Replace with your API URL
        String apiUrl = "https://example.com/api/endpoint";
        try {
            // Create an HTTP client
            HttpClient httpClient = HttpClient.newHttpClient();
            // Create an HTTP GET request
            HttpGet httpGet = new HttpGet(apiUrl);
            // Execute the request and get the response
            String responseBody = EntityUtils.toString(httpClient.execute(httpGet).getEntity());
            // Create a PDF document
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            // Create a content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            // Write the API response to the PDF
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700); // Adjust the coordinates as needed
            contentStream.showText(responseBody);
            contentStream.endText();
            contentStream.close();
            // Save the PDF to a file
            document.save("api_response.pdf");
            // Close the PDF document
            document.close();
            System.out.println("API response saved as api_response.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}