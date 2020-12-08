package com.fxr.certificate_collector.controller.admin;

import com.fxr.certificate_collector.dto.CertificateDTO;
import com.fxr.certificate_collector.entity.Certificate;
import com.fxr.certificate_collector.service.CertificateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author fanXiaoRui
 * @date 2020/11/23 15:12
 */
@RestController
@Api(tags = "证书API")
@RequestMapping("/admin")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;


    @ApiOperation(value = "添加证书", notes = "新增一条证书数据")
    @PostMapping("/addCertificate")
    public void saveCertificate(@RequestParam("图片") MultipartFile file,CertificateDTO certificateDTO) {
        certificateService.saveCertificate(file,certificateDTO);
    }


    @ApiOperation(value = "修改证书", notes = "根据id修改一条证书数据")
    @PutMapping("/updCertificateById/{id}")
    public void updateCertificate(@PathVariable String id,@RequestParam("file") MultipartFile file,CertificateDTO certificateDTO) {
        certificateService.updateCertificate(id,file,certificateDTO);
    }


    @ApiOperation(value = "查询单个证书", notes = "根据id查询一条证书数据")
    @GetMapping("/getCertificateById/{id}")
    public Certificate getCertificate(@PathVariable String id) {
        return certificateService.getCertificate(id);
    }


    @ApiOperation(value = "查询多个证书", notes = "查询证书所有数据")
    public List<Certificate> listCertificate() {
        return null;
    }


    @ApiOperation(value = "条件查询多个证书", notes = "根据证书名称、模块、等级、状态查询证书数据")
    public List<Certificate> listCertificateBy() {
        return null;
    }


    @ApiOperation(value = "删除证书", notes = "通过修改逻辑删除的字段的Boolean值,实现删除一条证书数据")
    @ApiImplicitParam(name = "id",value = "模块id")
    @DeleteMapping("/delCertificateById/{id}")
    public void deletedCertificate(@PathVariable String id) {
        certificateService.deletedCertificate(id);
    }

}
