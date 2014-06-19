package de.tilman.nodebucket.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import de.tilman.nodebucket.representations.Page;

public interface PageDAO {
	// XXX
	@MapResultAsBean
	@SqlQuery("select * from page where id = :id")
	Page getPageById(@Bind("id") int id);

	@GetGeneratedKeys
	@SqlUpdate("insert into page (id, firstName, lastName, phone) values (NULL, :firstName, :lastName, :phone)")
	public int createPage(
			@Bind("firstName") String firstName,
			@Bind("lastName") String lastName,
			@Bind("phone") String phone);

//	@SqlUpdate("update contact set firstName = :firstName, lastName = :lastName, phone = :phone where id = :id")
//	void updateContact(
//			@Bind("id") int id,
//			@Bind("firstName") String firstName,
//			@Bind("lastName") String lastName,
//			@Bind("phone") String phone);
//	
//	@SqlUpdate("delete from contact where id = :id")
//	void deleteContact(@Bind("id") int id);

}
