package org.n52.huddle.di.impl;

import static com.google.common.base.Objects.*;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.n52.huddle.di.User;

import com.google.common.collect.ComparisonChain;
@Entity
public class UserImpl extends BaseEntityImpl<User> implements User, Comparable<User>, Serializable {
    private static final long serialVersionUID = 1L;
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    @Column(name = LAST_NAME)
    private String lastName;
    @Column(name = FIRST_NAME)
    private String firstName;

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public User setFirstName(String firstName) {
        this.firstName = checkNotNull(firstName);
        return this;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public UserImpl setLastName(String lastName) {
        this.lastName = checkNotNull(lastName);
        return this;
    }

    @Override
    public int hashCode() {
        return hashCode(getId(), getFirstName(), getLastName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserImpl) {
            UserImpl o = (UserImpl) obj;
            return equal(getFirstName(), o.getFirstName())
                   && equal(getLastName(), o.getLastName())
                   && equal(getId(), o.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", getId())
                .add("firstName", getFirstName())
                .add("lastName", getLastName())
                .toString();
    }

    @Override
    public int compareTo(User o) {
        return ComparisonChain.start()
                .compare(getLastName(), o.getLastName())
                .compare(getFirstName(), o.getFirstName())
                .result();
    }
}
