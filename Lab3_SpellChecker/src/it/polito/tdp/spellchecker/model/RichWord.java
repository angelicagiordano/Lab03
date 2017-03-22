package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola, boolean corretta) {
		
		this.parola = parola;
		this.corretta = corretta;
	}

	/**
	 * @return the parola
	 */
	public String getParola() {
		return parola;
	}

	/**
	 * @param parola the parola to set
	 */
	public void setParola(String parola) {
		this.parola = parola;
	}

	/**
	 * @return the corretta
	 */
	public boolean isCorretta() {
		return corretta;
	}

	/**
	 * @param corretta the corretta to set
	 */
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	
	

}
