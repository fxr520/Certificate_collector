package com.fxr.certificate_collector.service.impl;

import com.fxr.certificate_collector.dao.ModuleDao;
import com.fxr.certificate_collector.entity.Module;
import com.fxr.certificate_collector.exception.DomainException;
import com.fxr.certificate_collector.service.ModuleService;
import com.fxr.certificate_collector.utils.result.ResultCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 11:55
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    /**
     * 添加模块名
     * @author fanXiaoRui
     * @date 2020/11/29 22:04
     * @param name
     * @return void
     */
    @Override
    public void saveModule(String name) {
        if (moduleDao.findByName(name) != null){
            throw new DomainException(ResultCode.MODULENAME_EXIST);
        }else {
            Module module = new Module();
            module.setName(name);
            module.setCreateTime(new Date());
            module.setUpdateTime(new Date());
            module.setDeleted(false);
            moduleDao.save(module);
        }
    }


    /**
     * 修改模块
     * @author fanXiaoRui
     * @date 2020/11/29 22:07
     * @param id
    	* @param name
     * @return void
     */
    @Override
    public void updateModule(String id, String name) {

        //有些小毛病,当id值不存在于数据库中,而模块名存在于数据库中时,异常会优先抛出模块名已存在的异常,而不是该模块不存在异常
        if (moduleDao.getOne(id) != null){
            if (moduleDao.findByName(name) == null){
                moduleDao.getOne(id).setName(name);
                moduleDao.save(moduleDao.getOne(id));
            }else {
                throw new DomainException(ResultCode.MODULENAME_EXIST);
            }
        }else {
            throw new EntityNotFoundException();
        }
    }

    /**
     * 查询模块
     * @author fanXiaoRui
     * @date 2020/11/29 22:10
     * @param
     * @return java.util.List<com.fxr.certificate_collector.entity.Module>
     */
    @Override
    public List<Module> listModule() {
        Module module = new Module();
        if (module.toString() != null){
            return moduleDao.findAll();
        }else {
            throw new DomainException(ResultCode.TABLE_EMPTY);
        }
    }

    /**
     * 逻辑删除模块
     * @author fanXiaoRui
     * @date 2020/11/29 22:10
     * @param id
     * @return void
     */
    @Override
    public void deletedModule(String id) {
        if (moduleDao.getOne(id) != null){
            moduleDao.getOne(id).setDeleted(true);
            moduleDao.save(moduleDao.getOne(id));
        }else {
            throw new EntityNotFoundException();
        }
    }
}
