package swaggerPetStore;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SwaggerPetStore {
    @Test
    public void addANewPetToTheStore() {
        System.out.println("Add a new pet to the store");
        String payload = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        Response response = given().contentType("application/json").when().body(payload)
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void updateAnExistingPet() {
        System.out.println("Update an existing pet");
        String payload = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        Response response = given().contentType("application/json").when().body(payload)
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void findPetsByStatus() {
        System.out.println("Find Pets by Status");
        Response response = given().when()
                .param("status", "sold")
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

//    @Test
    public void findPetByID() {
        System.out.println("Find pet by ID");
        Response response = given().when()
                .get("https://petstore.swagger.io/v2/pet/5");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    //    @Test
    public void updateAPetInTheStoreWithFormData() {
        System.out.println("Update a pet in the store with form data");
        Response response = given().when().formParam("name", "lion").queryParam("status", "sold")
                .post("https://petstore.swagger.io/v2/pet/5");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void deleteAPet() {
        System.out.println("Delete a pet");
        Response response = given().when()
                .delete("https://petstore.swagger.io/v2/pet/5");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void uploadAnImage() {
        System.out.println("Upload an image");
        Response response = given().when().post("https://petstore.swagger.io/v2/pet/5/uploadImage");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void petInventory() {
        System.out.println("Returns pet inventories by status");
        Response response = given().when()
                .get("http://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void orderAPet() {
        System.out.println("Place an order for a pet");
        String payload = "{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2020-02-13T06:45:54.500Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": false\n" +
                "}";
        Response response = given().contentType("application/json").when().body(payload)
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    //    @Test
    public void findPurchaseOrderByID() {
        System.out.println("Find purchase order by ID");
        Response response = given().when().get("https://petstore.swagger.io/v2/store/order/9");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    //    @Test
    public void orderPetByID() {
        System.out.println("ID of pet that needs to be fetched");
        Response response = given().when().get("https://petstore.swagger.io/v2/store/order/9");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    //    @Test
    public void deletePurchaseOrderByID() {
        System.out.println("Delete purchase order by ID");
        Response response = given().when().delete("https://petstore.swagger.io/v2/store/order/9");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createUser() {
        System.out.println("Create a User");
        String payload = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        Response response = given().contentType("application/json").when().body(payload)
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createAUserWithArray() {
        System.out.println("Create a user with given input array");
        String payload = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"string\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        Response response = given().contentType("application/json").when().body(payload)
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createAUserWithList() {
        System.out.println("Create a user with given input arrayList");
        String payload = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"string\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        Response response = given().contentType("application/json").when().body(payload)
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void userLogin() {
        System.out.println("Logs user into the system");
        Response response = given().when()
                .queryParam("username", "test")
                .queryParam("password", "pwd")
                .get("https://petstore.swagger.io/v2/user/login");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void userLogout() {
        System.out.println("Logs out current logged in user session");
        Response response = given().when().get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getUserByUserName() {
        System.out.println("Get user by user name");
        Response response = given().when().get("https://petstore.swagger.io/v2/user/user1");
        response.prettyPrint();
        //Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void updatedUser() {
        System.out.println("Updated user");
        String payload = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        Response response = given().contentType("application/json").when().body(payload)
                .put("https://petstore.swagger.io/v2/user/user1");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void deleteUser() {
        Response response = given().when().delete("https://petstore.swagger.io/v2/user/user1");
        response.prettyPrint();
//        Assert.assertEquals(200, response.getStatusCode());
    }
}
