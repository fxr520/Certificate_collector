package com.fxr.certificate_collector.service.impl;

import com.fxr.certificate_collector.dao.CertificateDao;
import com.fxr.certificate_collector.dao.LevelDao;
import com.fxr.certificate_collector.dao.ModuleDao;
import com.fxr.certificate_collector.dto.CertificateDTO;
import com.fxr.certificate_collector.entity.Certificate;
import com.fxr.certificate_collector.entity.Level;
import com.fxr.certificate_collector.entity.Module;
import com.fxr.certificate_collector.exception.DomainException;
import com.fxr.certificate_collector.service.CertificateService;
import com.fxr.certificate_collector.utils.OSSClientUtil;
import com.fxr.certificate_collector.utils.result.ResultCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 11:55
 */
@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateDao certificateDao;

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private LevelDao levelDao;

    /**
     * 添加证书
     * @author fanXiaoRui
     * @date 2020/12/1 18:08
     * @param file
    	* @param certificateDTO
     * @return void
     */
    @Override
    public void saveCertificate(MultipartFile file, CertificateDTO certificateDTO) throws DomainException {

        String[] uploadFile = Upload(file);
        certificateDTO.setPicture(uploadFile[0]);

        if(certificateDao.findByName(certificateDTO.getName()) != null){
            throw new DomainException(ResultCode.CERTIFICATENAME_EXIST);
        }else {

            Certificate certificate = new Certificate();
            BeanUtils.copyProperties(certificateDTO,certificate);

            Module module = moduleDao.getOne(certificateDTO.getModuleId());
            certificate.setModule(module);

            Level level = levelDao.getOne(certificateDTO.getLevelId());
            certificate.setLevel(level);

            certificate.setCreateTime(new Date());
            certificate.setUpdateTime(new Date());

            certificateDao.save(certificate);
        }
    }

    /**
     * 修改证书(缺陷:没有将服务器上的图片删除后再进行覆盖操作)
     * @author fanXiaoRui
     * @date 2020/12/2 16:27
     * @param id
    	* @param file
    	* @param certificateDTO
     * @return com.fxr.certificate_collector.entity.Certificate
     */
    @Override
    public Certificate updateCertificate(String id, MultipartFile file, CertificateDTO certificateDTO) throws DomainException {

        String[] uploadFile = Upload(file);

        Certificate certificate = certificateDao.findById(id);
        if (certificate == null) {
            throw new DomainException(ResultCode.CERTIFICATE_NO_EXIST);
        }else if (certificate.getName() == certificateDTO.getName()) {
            throw new DomainException(ResultCode.CERTIFICATENAME_EXIST);
        }else {
            certificateDTO.setPicture(uploadFile[0]);

            Module module = moduleDao.getOne(certificateDTO.getModuleId());
            certificate.setModule(module);

            Level level = levelDao.getOne(certificateDTO.getLevelId());
            certificate.setLevel(level);

            certificate.setCreateTime(new Date());
            certificate.setUpdateTime(new Date());

            BeanUtils.copyProperties(certificateDTO,certificate);

            return certificateDao.save(certificate);
        }
    }


    /**
     * 查询单个证书数据
     * @author fanXiaoRui
     * @date 2020/12/1 18:53
     * @param id
     * @return com.fxr.certificate_collector.entity.Certificate
     */
    @Override
    public Certificate getCertificate(String id) {
            return certificateDao.findById(id);
    }


    /**
    * 逻辑删除证书
    * @author fanXiaoRui
    * @date 2020/12/1 18:07
    * @param id
    * @return void
    */
    @Override
    public void deletedCertificate(String id) {
        if (certificateDao.findById(id) != null){
            certificateDao.findById(id).setDeleted(true);
            certificateDao.save(certificateDao.findById(id));
        }else {
            throw new DomainException(ResultCode.CERTIFICATE_NO_EXIST);
        }
    }

    /**
     * 上传图片并返回网络图片url
     * @author fanXiaoRui
     * @date 2020/12/1 18:07
     * @param file
     * @return java.lang.String[]
     */
    public static String[] Upload(MultipartFile file) {

        OSSClientUtil ossClient = new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");

        return split;
    }
}
