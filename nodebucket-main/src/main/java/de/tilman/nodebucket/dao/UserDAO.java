package de.tilman.nodebucket.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface UserDAO {
	
	// XXX implement hashing
	@SqlQuery("select count(*) from users where username = :username and password = :password")
	int getUser(@Bind("username") String username, @Bind("password") String password);
}