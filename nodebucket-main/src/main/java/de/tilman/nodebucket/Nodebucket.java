package de.tilman.nodebucket;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import de.tilman.nodebucket.domain.FileRepository;
import de.tilman.nodebucket.domain.Page;
import de.tilman.nodebucket.domain.PageRepository;
import de.tilman.nodebucket.domain.User;
import de.tilman.nodebucket.domain.UserGroup;
import de.tilman.nodebucket.domain.UserGroupRepository;
import de.tilman.nodebucket.domain.UserRepository;

@Configuration
@EnableJpaRepositories(basePackages = { "de.tilman.nodebucket.domain" })
public class Nodebucket {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(H2).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan("de.tilman.nodebucket.domain");
		return lef;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.H2);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	public static void main(String[] args) {
		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.INFO);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Nodebucket.class);

		UserRepository userRepository = context.getBean(UserRepository.class);
		UserGroupRepository userGroupRepository = context.getBean(UserGroupRepository.class);
		PageRepository pageRepository = context.getBean(PageRepository.class);
		FileRepository fileRepository = context.getBean(FileRepository.class);

		User achim = new User("Achim", "achim@siarp.de", "xxxxx", true);
		User berta = new User("Berta", "berta@siarp.de", "xxxxx", false);
		User carl = new User("Carl", "carl@siarp.de", "xxxxx", false);
		User daniel = new User("Daniel", "daniel@siarp.de", "xxxxx", false);

		userRepository.save(achim);
		userRepository.save(berta);
		userRepository.save(carl);
		userRepository.save(daniel);

		Iterable<User> users = userRepository.findAll();
		System.out.println("Users found with findAll():");
		System.out.println("---------------------------");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println();

		UserGroup userGroup = new UserGroup("Stammtisch", achim);
		userGroup.addUser(achim);
		userGroup.addUser(berta);
		userGroup.addUser(carl);
		userGroup.addUser(daniel);
		userGroupRepository.save(userGroup);

		userGroup = userGroupRepository.findOne(1L);
		System.out.println("UserGroup 1:");
		System.out.println("------------");
		System.out.println(userGroup);
		
		Page page = new Page("Page One");
		page.setContent("Content 1");
		pageRepository.save(page);
		page = new Page("Page Two");
		page.setContent("Content 2");
		pageRepository.save(page);
		
		System.out.println("Pages:");
		System.out.println("------");
		page = pageRepository.findOne(1L);
		System.out.println("'" + page.getTitle() + "': '" + page.getContent() + "'");
		page = pageRepository.findOne(2L);
		System.out.println("'" + page.getTitle() + "': '" + page.getContent() + "'");
		
		context.close();
	}

}
