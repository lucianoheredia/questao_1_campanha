package br.com.desafio.run.model.campanha;

import br.com.desafio.run.model.time_coracao.TimeCoracao;

/**
 * 
 * @author Luciano
 *
 */
public class Campanha implements Comparable<Campanha>{
	
	public Campanha() {
	
	}

	private long id;

	private String nome;
	
	private String dataIni;
	
	private String dataFim;
	
	private TimeCoracao timeCoracao;

	public Campanha(long id, String nome, String dataIni, String dataFim, TimeCoracao timeCoracao ) {
		this.id = id;
		this.nome = nome;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
		this.timeCoracao = timeCoracao;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataIni() {
		return dataIni;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataIni(String dataIni) {
		this.dataIni = dataIni;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}

	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campanha other = (Campanha) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{id :" + id + ",nome:" + nome + ",dataIni:"+ dataIni +",dataFim:" + dataFim + "}";
	}

	@Override
	public int compareTo(Campanha o) {
	  int strVal = this.dataFim.compareTo(o.dataFim);
	      if (strVal < 0) {
	    	  strVal = -1;
	      } else if (strVal == 0) {
	    	  strVal = 0;
	      } else {
	    	  strVal = 1;
	      }
	  	return strVal;
	}

		
}