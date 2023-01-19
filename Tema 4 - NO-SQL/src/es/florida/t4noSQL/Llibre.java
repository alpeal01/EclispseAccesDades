package es.florida.t4noSQL;

import org.bson.types.ObjectId;

public class Llibre {
	ObjectId _id;
	int id;
	String titol;
	String Autor;
	int Any_naixement;
	int Any_publicacio;
	String Editorial;
	int Nombre_pagines;
	
	public Llibre(ObjectId _id,int id, String titol, String autor, int any_naixement, int any_publicacio, String editorial,
			int nombre_pagines) {
		super();
		this._id = _id;
		this.id = id;
		this.titol = titol;
		Autor = autor;
		Any_naixement = any_naixement;
		Any_publicacio = any_publicacio;
		Editorial = editorial;
		Nombre_pagines = nombre_pagines;
	}
	
	public Llibre(int id, String titol, String autor, int any_naixement, int any_publicacio, String editorial,
			int nombre_pagines) {
		super();
		
		this.id = id;
		this.titol = titol;
		Autor = autor;
		Any_naixement = any_naixement;
		Any_publicacio = any_publicacio;
		Editorial = editorial;
		Nombre_pagines = nombre_pagines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public int getAny_naixement() {
		return Any_naixement;
	}

	public void setAny_naixement(int any_naixement) {
		Any_naixement = any_naixement;
	}

	public int getAny_publicacio() {
		return Any_publicacio;
	}

	public void setAny_publicacio(int any_publicacio) {
		Any_publicacio = any_publicacio;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public int getNombre_pagines() {
		return Nombre_pagines;
	}

	public void setNombre_pagines(int nombre_pagines) {
		Nombre_pagines = nombre_pagines;
	}
	
	
	
	

}
