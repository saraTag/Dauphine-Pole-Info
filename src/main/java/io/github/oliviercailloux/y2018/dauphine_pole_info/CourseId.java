package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class CourseId implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_master", referencedColumnName = "id")
	@XmlElement
	private Master master;

	@OneToOne
	@JoinColumn(name = "id_contenu", referencedColumnName = "id")
	@XmlElement
	private Content contents;

	
	
	public CourseId() {
		super();
	}

	public CourseId(Master master, Content contents) {
		super();
		this.master = master;
		this.contents = contents;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public Content getContents() {
		return contents;
	}

	public void setContents(Content contents) {
		this.contents = contents;
	}

}
