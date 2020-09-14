package com.dulcepan.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
@Entity
@Table(name = "recipe_status")
public class RecipeStatus {

    private Integer recipeStatusId;
    private String description;
    private Recipe recipe;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "recipe_status_id", unique = true, nullable = false)
    public Integer getRecipeStatusId() {
        return recipeStatusId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }


    @ManyToOne()
    @JsonManagedReference("recipe_status")
    @JoinColumn(name = "recipe_id", nullable = false)
    public Recipe getRecipe() {
        return recipe;
    }

}