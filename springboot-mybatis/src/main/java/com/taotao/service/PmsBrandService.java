package com.taotao.service;

import com.taotao.mbg.model.PmsBrand;

import java.util.List;

/**
 * @auther ASUS
 * @date 2021/12/2
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);

}
