package com.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Admission 
{
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
    @Lob
    @Column(length=999999999)
  private byte[] tenmarksheet;
	
    @Lob
    @Column(length=999999999)
    private byte[] twelthmarksheet;
    
    @Lob
    @Column(length=999999999)
    private byte[] adharcard;
    
    @Lob
    @Column(length=999999999)
    private byte[] pancard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getTenmarksheet() {
		return tenmarksheet;
	}

	public void setTenmarksheet(byte[] tenmarksheet) {
		this.tenmarksheet = tenmarksheet;
	}

	public byte[] getTwelthmarksheet() {
		return twelthmarksheet;
	}

	public void setTwelthmarksheet(byte[] twelthmarksheet) {
		this.twelthmarksheet = twelthmarksheet;
	}

	public byte[] getAdharcard() {
		return adharcard;
	}

	public void setAdharcard(byte[] adharcard) {
		this.adharcard = adharcard;
	}

	public byte[] getPancard() {
		return pancard;
	}

	public void setPancard(byte[] pancard) {
		this.pancard = pancard;
	}
    
	
}
