package org.bookmarknotes.services;

import org.bookmarknotes.dto.UserDTO;
import org.bookmarknotes.entities.UserEntity;
import org.bookmarknotes.exception.UsernameAlreadyExistException;
import org.bookmarknotes.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by zealot on 09.08.18.
 */
@Service
public class UserService implements UserDetailsService {
    private UserRepository dao;
    private PasswordEncoder encoder;
    private ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (dao.exist(username)) {
            return new User(username, encoder.encode(dao.password(username)), new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }

    @Autowired
    public UserService setDao(UserRepository dao) {
        this.dao = dao;
        return this;
    }

    @Autowired
    public UserService setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
        return this;
    }

    @Autowired
    public UserService setMapper(ModelMapper mapper) {
        this.mapper = mapper;
        return this;
    }

    public void save(UserDTO user) {
        if (!dao.exist(user.getLogin())) {
            dao.save(mapper.map(user, UserEntity.class));
        } else {
            throw new UsernameAlreadyExistException("Username with login " + user.getLogin() + " already exists");
        }
    }
}
