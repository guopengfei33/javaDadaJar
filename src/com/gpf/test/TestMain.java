package com.gpf.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


/**
 * 不使用用户名和密码进行登录
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) {
		//创建mongo的客户端
		//连接mongoDB
		try {
			MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
			
			//连接到数据库
			MongoDatabase mongoDatabase  = mongoClient.getDatabase("test2");
			System.out.println(" mongoDB connect success!");
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}
}
