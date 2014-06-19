package de.tilman.nodebucket;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import org.skife.jdbi.v2.DBI;

import com.google.common.base.Optional;

import de.tilman.nodebucket.dao.UserDAO;

public class NodebucketAuthenticator implements Authenticator<BasicCredentials, Boolean> {
	
	private final UserDAO userDao;

	public NodebucketAuthenticator(DBI jdbi) {
		userDao = jdbi.onDemand(UserDAO.class);
	}

	@Override
	public Optional<Boolean> authenticate(BasicCredentials credentials) throws AuthenticationException {
		boolean validUser = (userDao.getUser(credentials.getUsername(), credentials.getPassword()) == 1);
		if (validUser) {
			return Optional.of(true);
		}
		return Optional.absent();
	}

}
