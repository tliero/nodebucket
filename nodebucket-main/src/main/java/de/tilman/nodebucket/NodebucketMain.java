package de.tilman.nodebucket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NodebucketMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("nodebucket.xml");
	}

}
