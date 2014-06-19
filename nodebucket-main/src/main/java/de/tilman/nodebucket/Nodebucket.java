package de.tilman.nodebucket;

import io.dropwizard.Application;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import de.tilman.nodebucket.resources.PageResource;

public class Nodebucket extends Application<NodebucketConfiguration> {

//	private static final Logger LOGGER = LoggerFactory.getLogger(Nodebucket.class);

	public static void main(String[] args) throws Exception {
		new Nodebucket().run(args);
	}

	@Override
	public void initialize(Bootstrap<NodebucketConfiguration> bootstrap) {
		// TODO
	}

	@Override
	public void run(NodebucketConfiguration configuration, Environment environment) throws Exception {

		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
		
		// TODO später Caching hinzufügen
		environment.jersey().register(new BasicAuthProvider<Boolean>(new NodebucketAuthenticator(jdbi), "Web Service Realm"));
		
		environment.jersey().register(new PageResource(jdbi));
	}

}
