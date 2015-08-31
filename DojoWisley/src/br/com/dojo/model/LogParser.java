package br.com.dojo.model;

import java.util.Collection;

public interface LogParser <FROM,TO>{
	public Collection<TO> parse(Collection<FROM> from);
	public TO parse(FROM from);
}
