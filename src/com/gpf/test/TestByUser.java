package com.gpf.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 使用用户名和密码进行登录
 * 
 * @author Administrator
 *
 */
public class TestByUser {

	public static void main(String[] args) {
		// 连接到mongoDB服务器,
		// serverAddress(address,port);
		try {
			ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);
			// 进行seeds 创建
			List<ServerAddress> seeds = new ArrayList<ServerAddress>();
			seeds.add(serverAddress);

			// 通过用户名密码进行登录的连接 帐号,数据库名称,密码
			MongoCredential mongoCredential = MongoCredential
					.createScramSha1Credential("root", "my_test", "123456".toCharArray());
			List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
			credentialsList.add(mongoCredential);
			// 获取mongoclient
			MongoClient mongoClient = new MongoClient(seeds, credentialsList);

			// 连接到数据库
			MongoDatabase database = mongoClient.getDatabase("my_test");
			System.out.println("mongoDB connect success!");
			
			//创建集合
			/*database.createCollection("jinwei");
			System.out.println(" 集合创建成功");*/
			MongoCollection<Document> mongoCollection = database.getCollection("jinwei");
			
			Document document = new Document();
			document.append("username", "jinwei");
			document.append("age",12);
			mongoCollection.insertOne(document);
			
			System.out.println("插入成功!");
			
			mongoCollection = database.getCollection("users");
			
			FindIterable<Document> findIterable = mongoCollection.find();
			for (Document document2 : findIterable) {
				System.out.println(document2);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}
}
