package com.coco.dao.test;

import com.coco.model.pojo.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItestDao {
    List<Test> getAll();
}
