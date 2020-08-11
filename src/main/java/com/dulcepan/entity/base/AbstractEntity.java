package com.dulcepan.entity.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

	
	public abstract ID getEntityId();

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getEntityId()).toHashCode();
	}
        
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!this.getClass().isAssignableFrom(obj.getClass())) {
			return false;
		}
		final AbstractEntity<ID> castObj = (AbstractEntity<ID>) obj;
		return new EqualsBuilder().append(this.getEntityId(), castObj.getEntityId()).isEquals();
	}
}
