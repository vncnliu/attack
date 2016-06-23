package nosql.mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

            MongoCollection<Document> collection = mongoDatabase.getCollection("reportSmall2");
            System.out.println("集合 report 选择成功");
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Random random = new Random();
            List<Document> datas = new ArrayList<>();
            for(int i=0;i<1000;i++){
                double[] values = new double[5];
                int reportType = random.nextInt(5);
                values[reportType] = random.nextDouble()*1000;
                int smallweiNo = random.nextInt(200000);
                int bigweiNo = random.nextInt(100000);
                int belongUser = random.nextInt(10000);
                Document document = new Document("samllweiNo", smallweiNo).
                        append("balance", values[0]).
                        append("recharge", values[1]).
                        append("takecash", values[2]).
                        append("fee", values[3]).
                        append("feeResult", values[3]).
                        append("couponResult", values[4]).
                        append("smallweiName", "name"+smallweiNo).
                        append("bigweiNo", bigweiNo).
                        append("bigweiName", "name"+bigweiNo).
                        append("belongUserId", belongUser).
                        append("belongUserName", "name"+belongUser).
                        append("smallweiRegDate", new Date(System.currentTimeMillis()-random.nextInt(1000000)*1000*60)).
                        append("countTime", new Date(System.currentTimeMillis()-random.nextInt(1000000)*1000*60)).
                        append("belongDept", random.nextInt(200)).
                        append("type", reportType);
                datas.add(document);
            }
            collection.insertMany(datas);
            System.out.println("文档插入成功");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    @Test
    public void groupTest(){
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // 连接到数据库
        DB mongoDatabase = mongoClient.getDB("report");
        System.out.println("Connect to database successfully");

        DBCollection collection = mongoDatabase.getCollection("reportSmall");
        System.out.println("集合 report 选择成功");
        DBObject groupFields = new BasicDBObject( "_id", "$samllweiNo");

        // we use the $sum operator to increment the "count"
        // for each unique dolaznaStr
        groupFields.put("count", new BasicDBObject( "$sum", 1));
        BasicDBObject group = new BasicDBObject("$group", groupFields );


        // You can add a sort to order by count descending
        // You can add a sort to order by count descending

        DBObject sortFields = new BasicDBObject("count", -1);
        DBObject sort = new BasicDBObject("$sort", sortFields );

        AggregationOutput output = collection.aggregate(group,sort);
        System.out.println(output.results());
    }
}
