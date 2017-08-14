package br.com.desafio.run.util;

public class RestDesafioErrorType {
	
	private String mensagemErroReq;
	 
    public RestDesafioErrorType(String mensagemErroReq){
        this.mensagemErroReq = mensagemErroReq;
    }
 
    public String getErrorMessage() {
        return mensagemErroReq;
    }
}
