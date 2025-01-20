package amazon_ui.data;

import framework.utils.CsvReader;
import org.testng.annotations.DataProvider;

public class searchData{

    @DataProvider(name = "productSearch")
    public static Object[][] hotelSearch() {
        return CsvReader.readCsvData(System.getProperty("user.dir") + "/resources/csv_files/search.csv");
    }
}
