package com.example.usermanagment.dao;

import com.example.usermanagment.bean.Entity;

import java.util.List;

public interface OneToManyDAO {
    Long save(Entity entity);

    void delete(Long entityId);

    void update(Entity entity);

    List<Entity> selectAll();

    Entity select(Long id);


}
