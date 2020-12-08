package com.fxr.certificate_collector.service;


import com.fxr.certificate_collector.entity.Module;

import java.util.List;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 10:57
 */
public interface ModuleService {

    void saveModule(String name);

    void updateModule(String id,String name);

    List<Module> listModule();

    void deletedModule(String id);

}
