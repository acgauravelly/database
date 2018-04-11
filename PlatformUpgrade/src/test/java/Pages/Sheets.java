package Pages;

import java.io.IOException;

public class Sheets {

    Xls_Reader reader=new Xls_Reader();
    public void BrandExcel(String name) throws IOException {

       reader.readBrandExcel(name);
    }

    public void loadUrls(String env) throws IOException, InterruptedException {

        reader.loadurls(env);
    }

    public void addResult(String result) throws IOException {
        reader.writeResult(result);
    }


}
