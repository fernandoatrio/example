package com.demo.persistence.user;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
	public static Specification<User> hasEmail(String email) {
		return (root, query, cb) -> cb.equal(root.get("email"), email);
	}
	public static Specification<User> hasLastName(String lastName) {
		return (root, query, cb) -> cb.equal(root.get("lastName"), lastName);
	}
}
