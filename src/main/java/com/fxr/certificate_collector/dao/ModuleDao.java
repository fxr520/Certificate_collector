package com.fxr.certificate_collector.dao;

import com.fxr.certificate_collector.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanXiaoRui
 * @date 2020/11/27 15:49
 */
public interface ModuleDao extends JpaRepository<Module,String> {

    Module findByName(String name);
}
