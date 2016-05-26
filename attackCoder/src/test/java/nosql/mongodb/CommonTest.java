package nosql.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/17.
 */
public class CommonTest {

    @Test
    public void testNum(){
        Random random = new Random();
        System.out.println(random.nextDouble()*1000);
    }

    @Test
    public void testInsert(){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("report");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("report");
            System.out.println("集合 report 选择成功");
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Random random = new Random();
            for(int i=0;i<100000;i++){
                int smallweiNo = random.nextInt(200000);
                int bigweiNo = random.nextInt(100000);
                int belongUser = random.nextInt(10000);
                Document document = new Document("samllweiNo", smallweiNo).
                        append("balance", random.nextDouble()*1000).
                        append("smallweiName", "name"+smallweiNo).
                        append("bigweiNo", bigweiNo).
                        append("bigweiName", "name"+bigweiNo).
                        append("belongUserId", belongUser).
                        append("belongUserName", "name"+belongUser).
                        append("smallweiRegDate", new Date(System.currentTimeMillis()-random.nextInt(100000000))).
                        append("belongDept", random.nextInt(200)).
                        append("type", 1);
                collection.insertOne(document);
            }
            System.out.println("文档插入成功");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
