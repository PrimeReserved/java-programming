/**
 * Data access object for Todo items
 */

package com.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {    
}

