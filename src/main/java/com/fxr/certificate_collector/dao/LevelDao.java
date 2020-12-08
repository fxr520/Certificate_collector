package com.fxr.certificate_collector.dao;

import com.fxr.certificate_collector.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanXiaoRui
 * @date 2020/12/1 13:19
 */
public interface LevelDao extends JpaRepository<Level,String> {
}
