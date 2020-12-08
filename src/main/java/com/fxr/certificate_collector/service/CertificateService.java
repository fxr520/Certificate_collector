package com.fxr.certificate_collector.service;


import com.fxr.certificate_collector.dto.CertificateDTO;
import com.fxr.certificate_collector.entity.Certificate;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fanXiaoRui
 * @date 2020/10/6 10:57
 */
public interface CertificateService {

    void saveCertificate(MultipartFile file, CertificateDTO certificateDTO);

    Certificate updateCertificate(String id,MultipartFile file, CertificateDTO certificateDTO);

    Certificate getCertificate(String id);

    void deletedCertificate(String id);

}
