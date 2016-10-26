package com.tf.usermanagement.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long productCategoryId;
	private Media media;
	private Long createdBy;
	private Timestamp createdDate;
	private Long modifiedBy;
	private Timestamp modifiedDate; 
	private Boolean active;
	
	private ProductCategoryDescription productCategoryDescription;
	private Set<ProductCategoryHierarchy> productCategoryHierarchy;
	private Set<ProductCategoryHierarchy> parentProductCategoryHierarchy; 
	private Set<ProductCategoryPart> productCategoryPart;
	
	@Id
	@Column(name="PRODUCT_CATEGORY_ID")
	/*@SequenceGenerator(name = "ProductCategorySequence", sequenceName = "SEQ_PRODUCTCATEGORY")
	@GeneratedValue(generator="ProductCategorySequence")*/
	@GeneratedValue
	public Long getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	
	@OneToOne
	@JoinColumn(name="MEDIA_ID")
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	
	@Column(name="CREATED_BY")
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE")
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="MODIFIED_BY")
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="MODIFIED_DATE")
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@Column(name="ACTIVE")
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@OneToOne(mappedBy = "productCategory", fetch = FetchType.LAZY)
	public ProductCategoryDescription getProductCategoryDescription() {
		return productCategoryDescription;
	}
	public void setProductCategoryDescription(
			ProductCategoryDescription productCategoryDescription) {
		this.productCategoryDescription = productCategoryDescription;
	}
	
	@OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY)
	public Set<ProductCategoryHierarchy> getProductCategoryHierarchy() {
		return productCategoryHierarchy;
	}
	public void setProductCategoryHierarchy(
			Set<ProductCategoryHierarchy> productCategoryHierarchy) {
		this.productCategoryHierarchy = productCategoryHierarchy;
	}
	
	@OneToMany(mappedBy = "parentProductCategory", fetch = FetchType.LAZY)
	public Set<ProductCategoryHierarchy> getParentProductCategoryHierarchy() {
		return parentProductCategoryHierarchy;
	}
	public void setParentProductCategoryHierarchy(
			Set<ProductCategoryHierarchy> parentProductCategoryHierarchy) {
		this.parentProductCategoryHierarchy = parentProductCategoryHierarchy;
	}
	
	@OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY)
	public Set<ProductCategoryPart> getProductCategoryPart() {
		return productCategoryPart;
	}
	public void setProductCategoryPart(Set<ProductCategoryPart> productCategoryPart) {
		this.productCategoryPart = productCategoryPart;
	}
	
	@Override
	public String toString(){
		return "Categories [Category_id=" + productCategoryId + ", "
				+ "active=" + active + "]";
	}
}
