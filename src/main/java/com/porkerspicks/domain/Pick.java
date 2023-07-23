package com.porkerspicks.domain;

import com.porkerspicks.domain.types.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity bean for holding details of a blog post.
 * 
 * @author William
 *
 */
@Entity
public class Pick {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Version
	private int version;

	private Date timestamp;
	
	private BigDecimal stake = BigDecimal.ONE;
	
	private BigDecimal price;
	
	private TeamType team;
	
	private TeamType opposition;

	private CompetitionType competition;
	
	private VenueType venue;
	
	private BetType betType = BetType.RESULT;
	
	private ResultType forecast;
	
	private ResultType result;

	@ManyToOne
	@JoinColumn(name="POST_ID",nullable = false)
	private Post post;

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

	public BigDecimal getStake() {
		return stake;
	}

	public void setStake(BigDecimal stake) {
		this.stake = stake;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public TeamType getTeam() {
		return team;
	}

	public void setTeam(TeamType team) {
		this.team = team;
	}

	public TeamType getOpposition() {
		return opposition;
	}

	public void setOpposition(TeamType opposition) {
		this.opposition = opposition;
	}

	public CompetitionType getCompetitionTYpe() {
		return competition;
	}

	public void setCompetitionTYpe(CompetitionType competition) {
		this.competition = competition;
	}

	public VenueType getVenue() {
		return venue;
	}

	public void setVenue(VenueType venue) {
		this.venue = venue;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public ResultType getForecast() {
		return forecast;
	}

	public void setForecast(ResultType forecast) {
		this.forecast = forecast;
	}

	public ResultType getResult() {
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
