package Data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "usersForTest")
    public static Object[][] getUsers() {
        return new Object[][]
                {
                        {"Maximiliano Rencores", "Argentina", "maximiliano.pisso@gmail.com", "4555990017889874", "12", "23"},
                        {"Gisella Cumpleañera", "Argentina", "gisela.ib@gmail.com", "685990045889874", "12", "24"},
                        {"Vanesa Busca Pleitos", "Argentina", "vanesa.ib@gmail.com", "4568235457841254", "11", "22"},
                };
    }
}
