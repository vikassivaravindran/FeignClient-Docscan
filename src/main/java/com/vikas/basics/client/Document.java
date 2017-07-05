package com.vikas.basics.client;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Document {
	
	
	
	private String name;
	private DocumentType docType;
	
	@JsonIgnore
	private Set<CustomerType> customerTypes;
	
	public enum DocumentType{
		
		EXPENDITURE,
		INCOME,
		BOTH
	}
	public enum CustomerType{
		
		EMPLOYED,
		SELF_EMPLOYED,
		NOT_EMPLOYED,
		RETIRED
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DocumentType getDocType() {
		return docType;
	}
	public void setDocType(DocumentType docType) {
		this.docType = docType;
	}
	
	public Set<CustomerType> getCustomerTypes() {
		return customerTypes;
	}
	public void setCustomerTypes(Set<CustomerType> customerTypes) {
		this.customerTypes = customerTypes;
	}
	
	public Document(String name, DocumentType docType, Set<CustomerType> customerTypes) {
		super();
		this.name = name;
		this.docType = docType;
		this.customerTypes = customerTypes;
	}
	public Document() {
		super();
		
	}
	
	
	
	


	
	


	

}
