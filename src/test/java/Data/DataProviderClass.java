package Data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

        @DataProvider(name="usersForTest")
        public static Object[][] getUsers(){
            return new Object[][]
                    {
                            {"Maximiliano","Argentina","maximiliano.pisso@gmail.com","4555990017889874", "12","23"},
                            {"Gisela","Argentina","gisela.ib@gmail.com","685990045889874", "12","24"},
                            {"Vanesa","Argentina","vanesa.ib@gmail.com","4568235457841254", "11","22"},

                    };
        }
}
