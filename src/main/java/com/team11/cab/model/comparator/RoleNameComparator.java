package com.team11.cab.model.comparator;

import java.util.Comparator;

import com.team11.cab.model.Role;

public class RoleNameComparator  implements Comparator<Role>{

	@Override
	public int compare(Role o1, Role o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
