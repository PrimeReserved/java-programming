package com.business.config;
import com.business.model.Todo;
import com.business.repositories.TodoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoDataLoader implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(TodoDataLoader.class);

    private final TodoRepository todoRepository;

    @Autowired
    public TodoDataLoader(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if(todoRepository.count() == 0) {
            Todo todoItem1 = new Todo("Milk", "Get the milk");
            Todo todoItem2 = new Todo("Programming", "Learn Java in one month");

            todoRepository.save(todoItem1);
            todoRepository.save(todoItem2);
        }

        logger.info("Number of Todo Items: {}", todoRepository.count());
    }
}
