package com.citychoice.shopey;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employe")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employe{
	private Integer id;
	private String name;
	private String address;

	public Employe(){
		this.id = 0;
		this.name = "--invalid--";
		this.address = "error";
	}

	public Employe(Integer id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employe [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}