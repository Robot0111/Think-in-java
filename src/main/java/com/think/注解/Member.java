package com.think.注解;

import Annotation.Constraints;
import Annotation.DBTable;
import Annotation.SQLInteger;
import Annotation.SQLString;

@DBTable(name = "MEMBER")
public class Member {
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;
	@SQLString(30)
	String firstName;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;
	static int memberCount;

	public String getHandle() {
		return handle;

	}

	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;

	}

	public String toString() {
		return handle;

	}

	public Integer getAge() {
		return age;
	}
}
