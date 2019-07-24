package com.przsoftdevs.wereview.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the photos database table.
 * 
 */
@Entity
@Table(name="photos")
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String photo;

	private String type;

	//bi-directional many-to-one association to LookupPhoto
	@OneToMany(mappedBy="photo")
	private List<LookupPhoto> lookupPhotos;

	public Photo() {
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

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<LookupPhoto> getLookupPhotos() {
		return this.lookupPhotos;
	}

	public void setLookupPhotos(List<LookupPhoto> lookupPhotos) {
		this.lookupPhotos = lookupPhotos;
	}

	public LookupPhoto addLookupPhoto(LookupPhoto lookupPhoto) {
		getLookupPhotos().add(lookupPhoto);
		lookupPhoto.setPhoto(this);

		return lookupPhoto;
	}

	public LookupPhoto removeLookupPhoto(LookupPhoto lookupPhoto) {
		getLookupPhotos().remove(lookupPhoto);
		lookupPhoto.setPhoto(null);

		return lookupPhoto;
	}

}