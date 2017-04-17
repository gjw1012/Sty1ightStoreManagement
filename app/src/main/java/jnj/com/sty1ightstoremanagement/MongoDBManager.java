package jnj.com.sty1ightstoremanagement;

/**
 * Created by gjw on 2017-04-17.
 */

public class MongoDBManager {

    //커넥트
    public void ConnectDB()
    {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://lossgate:<PASSWORD>@sty1ight-shard-00-00-bndb2.mongodb.net:27017,sty1ight-shard-00-01-bndb2.mongodb.net:27017,sty1ight-shard-00-02-bndb2.mongodb.net:27017/<DATABASE>?ssl=true&replicaSet=Sty1ight-shard-0&authSource=admin");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
    }

    //table 생성 코드드
   public void CreateCollection()
    {

    }
}
