package com.project.alpha.common.code.service;

import com.project.alpha.common.code.model.CommonCodeModel;

import java.util.List;

public interface CommonCodeService {

    /**
     * 공통 코드 리스트 조회
     * @param commonCodeModel CommonCodeModel
     * @return List<CommonCodeModel>
     */
    List<CommonCodeModel> selectCommonCodeList(CommonCodeModel commonCodeModel);

    /**
     * 공통 코드 분류별 리스트 조회
     * @param commonCodeModel CommonCodeModel
     * @return List<CommonCodeModel>
     */
    List<CommonCodeModel> selectCommonCodeListWhereCategory(CommonCodeModel commonCodeModel);

    /**
     * 공통 코드 추가
     * @param commonCodeModel CommonCodeModel
     */
    void insertCommonCode(CommonCodeModel commonCodeModel);

    /**
     * 공통 코드 수정
     * @param commonCodeModel CommonCodeModel
     */
    void updateCommonCode(CommonCodeModel commonCodeModel);

    /**
     * 공통 코드 삭제
     * @param commonCodeModel CommonCodeModel
     */
    void deleteCommonCode(CommonCodeModel commonCodeModel);

}
