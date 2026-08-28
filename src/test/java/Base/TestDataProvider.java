package Base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.util.Map;

public class TestDataProvider {

    private Map<String, Object> getTestData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream =
                getClass().getClassLoader()
                        .getResourceAsStream("testData.json");

        if (inputStream == null) {
            throw new RuntimeException("testData.json not found");
        }

        return mapper.readValue(
                inputStream,
                Map.class
        );
    }


    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = getTestData();

        LoginData validUser = mapper.convertValue(
                data.get("validUser"),
                LoginData.class
        );

        return new Object[][]{
                {validUser}
        };
    }


    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = getTestData();

        LoginData invalidUser = mapper.convertValue(
                data.get("invalidUser"),
                LoginData.class
        );

        return new Object[][]{
                {invalidUser}
        };
    }


    @DataProvider(name = "validSearchData")
    public Object[][] validSearchData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = getTestData();

        LoginData validUser = mapper.convertValue(
                data.get("validUser"),
                LoginData.class
        );

        SearchData validName = mapper.convertValue(
                data.get("validName"),
                SearchData.class
        );

        return new Object[][]{
                {validUser, validName}
        };
    }


    @DataProvider(name = "invalidSearchData")
    public Object[][] invalidSearchData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = getTestData();

        LoginData validUser = mapper.convertValue(
                data.get("validUser"),
                LoginData.class
        );

        SearchData invalidName = mapper.convertValue(
                data.get("invalidName"),
                SearchData.class
        );

        return new Object[][]{
                {validUser, invalidName}
        };
    }

    @DataProvider(name = "existingEmployeeData")
    public Object[][] existingEmployeeData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> data = getTestData();

        LoginData validUser = mapper.convertValue(
                data.get("validUser"),
                LoginData.class
        );

        SearchData existingEmployee = mapper.convertValue(
                data.get("ExistingEmployee"),
                SearchData.class
        );

        return new Object[][]{
                {validUser, existingEmployee}
        };
    }
}