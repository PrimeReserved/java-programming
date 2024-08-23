/**
 * Entity class for Todo items
 */
package com.business.model;

import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @NotBlank(message = "Title is required")
    private String title;

    @Getter @Setter
    @NotBlank(message = "Description is require")
    private String description;

    @Getter @Setter
    private boolean complete;

    @Getter @Setter
    private Instant createdDate;

    @Getter @Setter
    private Instant modifiedDate;

    public Todo(){}

    public Todo(String title, String description){
        this.title = title;
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString(){
        return String.format("Todo{id=%d, title='%s', description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
        id, title, description, complete, createdDate, modifiedDate);
    }

}