package jnj.com.sty1ightstoremanagement;

/**
 * Created by gjw on 2017-04-17.
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public  class MongoDBManager {
    private static MongoDatabase database;
    private static String connectString = "mongodb://lossgate:<!jiwoo1021>@sty1ight-shard-00-00-bndb2.mongodb.net:27017,sty1ight-shard-00-01-bndb2.mongodb.net:27017,sty1ight-shard-00-02-bndb2.mongodb.net:27017/<DATABASE>?ssl=true&replicaSet=Sty1ight-shard-0&authSource=admin";
    private static String DatabaseName = "Sty1ightStoreManagement";
    public static MongoDBManager dbManager = new MongoDBManager();

        //커넥트
    public static void ConnectDB()
    {
        MongoClientURI uri = new MongoClientURI(connectString);
        MongoClient mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase(DatabaseName); // 큰 틀
    }
    public static void test()
    {
        MongoCollection<Document> collection = database.getCollection("TestCollection"); // 각각의 테이블

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
        collection.insertOne(doc);
        SelectAllDocs(collection);
    }

    //컬렉션 전체 내용 보기
    public static void SelectAllDocs(MongoCollection<Document> collection)
    {
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    //table 생성 코드드
   public static void CreateCollection()
    {

    }
}
