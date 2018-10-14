package com.project.alpha.common.code.service;

import com.project.alpha.common.code.mapper.CommonCodeMapper;
import com.project.alpha.common.code.model.CommonCodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeMapper commonCodeMapper;

    @Autowired
    public CommonCodeServiceImpl(CommonCodeMapper commonCodeMapper) {
        this.commonCodeMapper = commonCodeMapper;
    }

    @Override
    public List<CommonCodeModel> selectCommonCodeList(CommonCodeModel commonCodeModel) {
        return commonCodeMapper.selectCommonCodeList(commonCodeModel);
    }

    @Override
    public List<CommonCodeModel> selectCommonCodeListWhereCategory(CommonCodeModel commonCodeModel) {
        return commonCodeMapper.selectCommonCodeListWhereCategory(commonCodeModel);
    }

    @Override
    public void insertCommonCode(CommonCodeModel commonCodeModel) {
        commonCodeMapper.insertCommonCode(commonCodeModel);
    }

    @Override
    public void updateCommonCode(CommonCodeModel commonCodeModel) {
        commonCodeMapper.updateCommonCode(commonCodeModel);
    }

    @Override
    public void deleteCommonCode(CommonCodeModel commonCodeModel) {
        commonCodeMapper.deleteCommonCode(commonCodeModel);
    }

}
