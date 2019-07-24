package com.przsoftdevs.wereview.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the business database table.
 * 
 */
@Entity
@NamedQuery(name="Business.findAll", query="SELECT b FROM Business b")
public class Business implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="address_line1")
	private String addressLine1;

	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private double lat;

	@Column(name="long")
	private double long_;

	private String name;

	private String phone;

	@Column(name="photo_url")
	private String photoUrl;

	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="website_url")
	private String websiteUrl;

	private String zip;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to LookupPhoto
	@OneToMany(mappedBy="business")
	private List<LookupPhoto> lookupPhotos;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="business")
	private List<Review> reviews;

	public Business() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLong_() {
		return this.long_;
	}

	public void setLong_(double long_) {
		this.long_ = long_;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getWebsiteUrl() {
		return this.websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LookupPhoto> getLookupPhotos() {
		return this.lookupPhotos;
	}

	public void setLookupPhotos(List<LookupPhoto> lookupPhotos) {
		this.lookupPhotos = lookupPhotos;
	}

	public LookupPhoto addLookupPhoto(LookupPhoto lookupPhoto) {
		getLookupPhotos().add(lookupPhoto);
		lookupPhoto.setBusiness(this);

		return lookupPhoto;
	}

	public LookupPhoto removeLookupPhoto(LookupPhoto lookupPhoto) {
		getLookupPhotos().remove(lookupPhoto);
		lookupPhoto.setBusiness(null);

		return lookupPhoto;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setBusiness(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setBusiness(null);

		return review;
	}

}