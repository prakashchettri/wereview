package com.przsoftdevs.wereview.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reviews database table.
 * 
 */
@Entity
@Table(name="reviews")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String details;

	@Column(name="is_positive")
	private byte isPositive;

	private float rating;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to LookupPhoto
	@OneToMany(mappedBy="review")
	private List<LookupPhoto> lookupPhotos;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Business
	@ManyToOne
	private Business business;

	public Review() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public byte getIsPositive() {
		return this.isPositive;
	}

	public void setIsPositive(byte isPositive) {
		this.isPositive = isPositive;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<LookupPhoto> getLookupPhotos() {
		return this.lookupPhotos;
	}

	public void setLookupPhotos(List<LookupPhoto> lookupPhotos) {
		this.lookupPhotos = lookupPhotos;
	}

	public LookupPhoto addLookupPhoto(LookupPhoto lookupPhoto) {
		getLookupPhotos().add(lookupPhoto);
		lookupPhoto.setReview(this);

		return lookupPhoto;
	}

	public LookupPhoto removeLookupPhoto(LookupPhoto lookupPhoto) {
		getLookupPhotos().remove(lookupPhoto);
		lookupPhoto.setReview(null);

		return lookupPhoto;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

}