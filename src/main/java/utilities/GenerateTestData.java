package utilities;

import com.github.javafaker.Faker;

public class GenerateTestData {

    Faker faker = new Faker();

    private String firstName = faker.name().firstName();


}
