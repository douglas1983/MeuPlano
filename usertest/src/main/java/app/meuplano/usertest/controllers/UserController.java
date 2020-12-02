package app.meuplano.usertest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.meuplano.usertest.entities.User;
import app.meuplano.usertest.repositories.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping(value = "")
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(userRepository.findAll());
  }
}
