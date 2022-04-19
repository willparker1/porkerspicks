package com.porkerspicks.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Entity bean for holding details of a blog post.
 * 
 * @author William
 *
 */
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Version
	private int version;
	
	private Date timestamp;
	
	private String title;
	
	private String content;  
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Pick> picks;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
