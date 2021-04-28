package com.comics.heroesapi.configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.comics.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.comics.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

public class LoadHeroesData {
    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO)
                )
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Hero");

        Item batman = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Batman")
                .withString("universe", "DC Comics")
                .withNumber("films", 11);

        Item wonderWoman = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Wonder Woman")
                .withString("universe", "DC Comics")
                .withNumber("films", 2);

        Item deadpool = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Deadpool")
                .withString("universe", "Marvel comics")
                .withNumber("films", 3);

        PutItemOutcome outcome1 = table.putItem(batman);
        PutItemOutcome outcome2 = table.putItem(wonderWoman);
        PutItemOutcome outcome3 = table.putItem(deadpool);
    }
}
