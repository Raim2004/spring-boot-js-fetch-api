package com.peaksoft.springboot.service;

import com.peaksoft.springboot.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {

    List<Role> getAllRoles();

}
