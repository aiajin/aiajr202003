package com.aia.op.member.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "member-list")
public class MemberXmlList {
	
	@XmlElement(name = "member") // <member> .... </member>
	private List<MemberXML> members;
	
	public MemberXmlList() {
	}

	public MemberXmlList(List<MemberXML> members) {
		this.members = members;
	}

	public List<MemberXML> getMembers() {
		return members;
	}

	public void setMembers(List<MemberXML> members) {
		this.members = members;
	}
	
	
	
	
	

}







