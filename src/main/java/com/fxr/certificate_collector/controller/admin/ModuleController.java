package com.fxr.certificate_collector.controller.admin;

import com.fxr.certificate_collector.entity.Module;
import com.fxr.certificate_collector.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fanXiaoRui
 * @date 2020/11/23 15:14
 */
@RestController
@Api(tags = "模块API")
@RequestMapping("/admin")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @ApiOperation(value = "添加模块", notes = "新增一条模块数据")
    @ApiImplicitParam(name = "name",value = "模块名字")
    @PostMapping("/addModule")
    public void saveModule(String name) {
        moduleService.saveModule(name);
    }


    @ApiOperation(value = "修改模块", notes = "根据id修改一条模块数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "模块id"),
            @ApiImplicitParam(name = "name",value = "模块名字")
    })
    @PutMapping("/updModuleById/{id}")
    public void updateModule(@PathVariable String id,String name) {
        moduleService.updateModule(id, name);
    }


    @ApiOperation(value = "查询模块", notes = "查询模块所有数据")
    @GetMapping("/findModule")
    public List<Module> listModule() {
        return moduleService.listModule();
    }


    @ApiOperation(value = "删除模块", notes = "通过修改逻辑删除的字段的Boolean值,实现删除一条模块数据")
    @ApiImplicitParam(name = "id",value = "模块id")
    @DeleteMapping("/delModuleById/{id}")
    public void deletedModule(@PathVariable String id) {
        moduleService.deletedModule(id);
    }

}
