package br.com.dojo.model;

import java.io.IOException;
import java.util.Set;

public abstract class LeitorLog <RETORNO>{

	public abstract Set<RETORNO> processaLog() throws IOException;
}
