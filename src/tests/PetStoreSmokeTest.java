package tests;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

import com.jayway.jsonpath.JsonPath;
import framework.TestData;
import io.restassured.response.Response;

import framework.TestSetup;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class PetStoreSmokeTest extends TestSetup {
    private Date timeStamp;
    private String pet_name;

    @BeforeClass
    public void beforeClass() {  }

    @BeforeMethod
    public void beforeMethod() { timeStamp = new Date(); }

    @Parameters({"pet_name"})
    public PetStoreSmokeTest(String pet_name) {
        this.pet_name = pet_name;
    }

    @Test(alwaysRun = true, description = "Verify if the Test can be run in this environment.")
    public void ifTestCanBeRun() {
        // this test class limited for execution in devtest2 environment only. Remove it when you are ready.
        String _id = TestData.getPet("id", pet_name);
        if (Integer.valueOf(_id) <= 0)
            throw new SkipException("The test class is skipped because Pet test data is not available.");
    }

    @Test(dependsOnMethods = {"ifTestCanBeRun"}, description = "Verify if new Pet can be added.")
    public void ifPetCanBeAdded() {
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"ifPetCanBeAdded"}, description = "Verify if new Pet can be found by id.")
    public void ifPetCanBeFoundById() {

    }

    @Test(dependsOnMethods = {"ifPetCanBeAdded"}, description = "Verify if new Pet can be found by status.")
    public void ifPetCanBeFoundByStatus() {

    }

    @Test(dependsOnMethods = {"ifPetCanBeAdded"}, description = "Verify if new Pet can be updated.")
    public void ifPetCanBeUpdated() {

    }

    @Test(dependsOnMethods = {"ifPetCanBeAdded"}, description = "Verify if new Pet can be deleted.")
    public void ifPetCanBeDeleted() {

    }


//    @Test(dependsOnMethods = {"ifSigninNewTenant"}, description = "Verify if the Tenant can be deleted using API call.")
//    public void ifTenantCanBeDeleted() {
//        Response response;
//        String url_get_tenants = applicationURL + "users/api/Tenant";
//        String url_post_delete = applicationURL + "security/api/accounts/delete";
//
//        // we need to get sysadmin cookies to continue working with API
//        nextPage = signInNirmata(multiple_accounts_user, user_account, TestData.getUser("user_password", multiple_accounts_user));
//        //    private WebPage nextPage;
//        String cookie = nextPage.getHttpCookies();
//
//         // get tenants list
//        response = given().header("Cookie", cookie).get(url_get_tenants);
//        assertEquals(response.getStatusCode(), 200, "Getting of tenants list is failed.");
//
//        // locate aimed tenant
//        String output = response.getBody().print();
//        String json_pattern = "$.[?(@.ownerEmail=='" + new_tenant_user + "')]['id']";
//        List<String> tenantMap = JsonPath.read(output, json_pattern);
//        assertEquals(tenantMap.size(), 1, "Cannot retrieve unique tenant id for " + new_tenant_user + ". Test stopped.");
//        String tenantId = tenantMap.get(0);
//
//        // delete the tenant
//        String body = "{\"id\": \"" + tenantId + "\",\"forceDelete\": true}";
//        response = given().header("Cookie", cookie).body(body).post(url_post_delete);
//        assertEquals(response.getStatusCode(), 200, "Tenant has not been deleted, API call status code is - " + response.getStatusCode());
//    }






//    @Test(alwaysRun = true, description = "Get list of all tenants with IDs")
//    @Parameters({"multiple_accounts_user"})
//    public void test102(String multiple_accounts_user) {
//        String uri = "https://devtest2.nirmata.io/users/api/Tenant";
//        String email = "";
//        String password = "";
//        String api_key = "";
//
//        Response response = given().header("Authorization", api_key).get(uri);
//        String output = response.getBody().print();
//
//        List<Map> result = JsonPath.read(output, "$[*]['id','ownerEmail','createdOn']");
//
//        int j = 0;
//        for (int i=0; i < result.size(); i++) {
//            if (result.get(i).get("ownerEmail").toString().contains("@mail.ru") &&
//            new Date (Long.parseLong(result.get(i).get("createdOn").toString())).getTime() > new Date(new Date().getTime()-24*60*60*1000).getTime()) {
//                deleteTenant(result.get(i).get("id").toString(), api_key);
//            }
//        }
//
////        JsonPath.read(output, "$.[?(@.ownerEmail=='and14eve20200303051913@mail.ru')]['id','ownerEmail']");

//    }

//    private void deleteTenant(String id, String api_key) {
//        String uri = "https://devtest2.nirmata.io/security/api/accounts/delete";
//        String email = "";
//        String password = "";
//        String cookie0 = "";
//
//        String body = "{\"id\": \"" + id + "\",\"forceDelete\": true}";
//
//        Response response = given().contentType("application/json").accept("application/json").header("Cookie", cookie0).body(body).post(uri);
//
//    }

//    @Test
//    @Parameters({"login_email", "login_account"})
//    public void TestSignIn(String login_email, String login_account) {
//        SignIn signIn = new SignIn(webDriver, applicationURL);
//        nextPage = signIn.loginNirmataAccount(login_email, login_account);
//        Assert.assertTrue(nextPage.isClass("MainAppSuper"),"SignIn failed");
//    }
//
//    @Test (dependsOnMethods = {"TestSignIn"})
//    public void AccessAppMainPage() {
//        // check all version of starter page (before main application page)
//        if (nextPage.isClass("GetStartedPage")) {
//            ((GetStartedPage) nextPage).isLoaded();
//            ((GetStartedPage) nextPage).skipSetup();
//            nextPage = ((GetStartedPage) nextPage).nextWebPage();
//        }
////        else if () {}
//        Assert.assertTrue(nextPage.isClass("MainApplicationPage"));
//    }
//
//    @Test (dependsOnMethods = {"AccessAppMainPage"})
//    @Parameters({"adduser_email"})
//    public void AddUser(String adduser_email) {
//        nextPage = ((MainMenuPage) nextPage).selectMenuItem("Identity & Access");
//        Assert.assertTrue(nextPage.isClass("Users"));
//    }
}
