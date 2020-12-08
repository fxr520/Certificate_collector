package com.fxr.certificate_collector.dao;

import com.fxr.certificate_collector.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanXiaoRui
 * @date 2020/11/27 15:49
 */
public interface CertificateDao extends JpaRepository<Certificate,Long> {

    Certificate findByName(String name);

    Certificate findById(String id);

}
