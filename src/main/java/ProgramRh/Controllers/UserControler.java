package ProgramRh.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserControler {
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Successfully logged in");
    }
}
