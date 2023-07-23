package com.porkerspicks.domain;

import com.porkerspicks.domain.types.PostStatusType;

import javax.persistence.*;
import java.util.ArrayList;
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

	private PostStatusType postStatus = PostStatusType.UNSAVED;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Pick> picks = new ArrayList<Pick>();

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

	public PostStatusType getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(PostStatusType postStatus) {
		this.postStatus = postStatus;
	}

	public boolean isUnsaved() {
		return this.postStatus == PostStatusType.UNSAVED;
	}

	public boolean isDraft() {
		return this.postStatus == PostStatusType.DRAFT;
	}

	public boolean isPublished() {
		return this.postStatus == PostStatusType.PUBLISHED;
	}

	public List<Pick> getPicks() {
		return picks;
	}

	public void setPicks(List<Pick> picks) {
		this.picks = picks;
	}

	public void addPick(Pick pick) {
		this.picks.add( pick );
	}
}
