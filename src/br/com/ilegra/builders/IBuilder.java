package br.com.ilegra.builders;

import br.com.ilegra.entities.IEntity;

/**
 * 
 * @author guilherme
 *
 */
public interface IBuilder {
	public IEntity buid(String[] data);
}
