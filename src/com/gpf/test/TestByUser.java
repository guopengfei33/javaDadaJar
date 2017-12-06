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
 * ʹ���û�����������е�¼
 * 
 * @author Administrator
 *
 */
public class TestByUser {

	public static void main(String[] args) {
		// ���ӵ�mongoDB������,
		// serverAddress(address,port);
		try {
			ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);
			// ����seeds ����
			List<ServerAddress> seeds = new ArrayList<ServerAddress>();
			seeds.add(serverAddress);

			// ͨ���û���������е�¼������ �ʺ�,���ݿ�����,����
			MongoCredential mongoCredential = MongoCredential
					.createScramSha1Credential("root", "my_test", "123456".toCharArray());
			List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
			credentialsList.add(mongoCredential);
			// ��ȡmongoclient
			MongoClient mongoClient = new MongoClient(seeds, credentialsList);

			// ���ӵ����ݿ�
			MongoDatabase database = mongoClient.getDatabase("my_test");
			System.out.println("mongoDB connect success!");
			
			//��������
			/*database.createCollection("jinwei");
			System.out.println(" ���ϴ����ɹ�");*/
			MongoCollection<Document> mongoCollection = database.getCollection("jinwei");
			
			Document document = new Document();
			document.append("username", "jinwei");
			document.append("age",12);
			mongoCollection.insertOne(document);
			
			System.out.println("����ɹ�!");
			
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
