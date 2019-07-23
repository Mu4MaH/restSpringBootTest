package ru.specdep.evolution.restController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.specdep.evolution.entity.TestEntity;

@RestController
@RequestMapping("/test")
public class testController {

    @PostMapping(path = "/one", consumes = "application/json", produces = "application/json")
    TestEntity testController (@RequestBody TestEntity entity) {
        return entity;
    }

}
