
package org.sid.service;

import org.sid.entity.Role;
import org.sid.dao.RoleRepository;
import org.sid.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
}
