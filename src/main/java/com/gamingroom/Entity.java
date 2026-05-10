package com.gamingroom;

/**
 * Superclass for entities that have a unique name and id.
 */
public class Entity {
	private long id;
	private String name;
    
    /** Constructor made protected, to ensure that Entity cannot be created without a name and id. */
    private Entity() {
    }

    /**
     * Instantiate an Entity with name and id
     * @param id   The unique identifier of the Entity.
     * @param name The name of the Entity.
     */
    Entity(long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    /**
     * Access the unique identifier of the current Entity.
     * @return The current entity's ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Access the name of the current Entity.
     * @return The current entity's name.
     */
    public String getName() {
        return name;
    }

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}