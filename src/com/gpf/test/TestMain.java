package com.gpf.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


/**
 * ��ʹ���û�����������е�¼
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) {
		//����mongo�Ŀͻ���
		//����mongoDB
		try {
			MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
			
			//���ӵ����ݿ�
			MongoDatabase mongoDatabase  = mongoClient.getDatabase("test2");
			System.out.println(" mongoDB connect success!");
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}
}
