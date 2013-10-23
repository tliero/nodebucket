package de.tilman.nodebucket.persistence;

import de.tilman.nodebucket.domain.File;
import de.tilman.nodebucket.domain.UserGroup;
import de.tilman.nodebucket.domain.Node;
import de.tilman.nodebucket.domain.Page;
import de.tilman.nodebucket.domain.User;

public interface NodebucketDao {
	
	public Node getNode(long id);
	
	public Node getNode(String title);
	
	public void deleteNode(long id);
	
	
	public Page getPage(long id);
	
	public Page getPage(String title);
	
	public void savePage(Page page);
	
	
	public File getFile(long id);
	
	public File getFile(String title);
	
	public void saveFile(File file);
	
	
	public UserGroup getGroup(long id);
	
	public UserGroup getGroup(String name);
	
	public void saveGroup(UserGroup group);
	
	public void deleteGroup(UserGroup group);
	
	
	public User getUser(String name);
	
	public void saveUser(User user);
	
	public void deleteUser(String userId);
	
}
