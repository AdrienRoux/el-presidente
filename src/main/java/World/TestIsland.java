package World;

import org.junit.Before;

public class TestIsland {

    @Before
    public void setUp(){
        // Create your sellers here :
        company = new Company_("Europcar",null,01,01,1951);
        // - The enterprise is created on the 1st of January 2021
        // - Sellers are also employees. They work in the same company, called "Europcar"
        // - First seller is called "Joe", and he sold :
        //   - a car, called "DMC Dolorean", at 44 000 € (bought 36 000 €),
        // - Second seller is called "Jack" and he sold :
        //   - a article called "bumber", at 300 € (bought 100 €),
        //   - 4 "wheels", at 300 € each (bought at 150 € each),
        // - Third seller is called "William" and did not sell anything.

        // All sales are done the 22/02/2021

    }

    // DO NOT MODIFY BELOW THiS LINE

    @Test
    public void testEmployeeWithMostSales(){
        Employee employeeJack = company.retrieveEmployee("Jack");
        Employee bestSeller = company.getEmployeeOfTheMonth();
        Assertions.assertThat(bestSeller).isNotNull();
        Assertions.assertThat(bestSeller.getName()).isEqualTo(employeeJack.getName());
    }
}
