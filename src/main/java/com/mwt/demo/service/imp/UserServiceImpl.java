package com.mwt.demo.service.imp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mwt.demo.config.AjaxResult;
import com.mwt.demo.entity.SysUser;
import com.mwt.demo.mapper.UserMapper;
import com.mwt.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muwentao
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,SysUser> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public AjaxResult login(SysUser user) {
        if(user.getUsername()==null||user.getPassword()==null) {
            return AjaxResult.error("用户名和密码不能为空");
        }
        SysUser loginUser = userMapper.login(user);
        if(loginUser!=null) {
            return AjaxResult.success("登陆成功");
        }
        return AjaxResult.error("登录失败");

    }

    @Override
    public AjaxResult register(SysUser user) {
        if(user!=null) {
            QueryWrapper<SysUser> qw = new QueryWrapper<>();
            qw.eq("username",user.getUsername());
            List<SysUser> list = userMapper.selectList(qw);
            if(ObjectUtils.isNotEmpty(list)){
                log.info("{}",list);
                return AjaxResult.error("用户已存在");
            }
            int row = userMapper.register(user);
            if (row > 0) {
                return AjaxResult.success("注册成功");
            }
        }
        return AjaxResult.error("注册失败");
    }

    @Override
    public List<SysUser> findUserInfo() {
        return userMapper.findUserInfo();
    }
/*
    public void standardApply(List<BusinessInvoiceSlipVO> invoiceDetailsList) {
        for (BusinessInvoiceSlipVO slipVO:
                invoiceDetailsList) {
            try {
                //String requestId = UUID.randomUUID().toString(); //自定义请求唯一标识
                PasswordLoginConfig loginConfig = baiwangConfig.loginConfig();
                BopLoginClient loginClient = new PasswordLoginClient(loginConfig);

                // 获取token, token相关说明请参考 文档中心 -> 用户授权说明
                BopLoginResponse loginResponse = loginClient.login();
                // 重载方法，可以传自定义请求唯一标识
                // BopLoginResponse loginResponse = loginClient.login(requestId);
                String token = loginResponse.getResponse().getAccessToken();

                OutputRedinfoStandardapplyRequest request = new OutputRedinfoStandardapplyRequest();
                OutputRedinfoStandardapplyInvoice data = new OutputRedinfoStandardapplyInvoice();
                //1_1：购方已抵扣，1_2：购方未抵扣，2_0：销方申请
                data.setApplyType("2_0");
                data.setIsAmount("");
                data.setSellerName(slipVO.getSellerName());
                data.setInvoiceTotalTax(String.valueOf(slipVO.getInvoiceTotalTax()));
                data.setRateSign("1");
                data.setPriceAndTax(String.valueOf(slipVO.getInvoiceTotalPriceTax()));
                data.setMachineNo("");
                data.setGoodsCodeVersion("");
                data.setInvoiceNo(slipVO.getBwInvoiceNumber());
                data.setInvoiceTotalRate("");
                data.setBuyerTaxNo(slipVO.getBuyerTaxNo());
                data.setApplyReason("");
                data.setInvoiceSpecialMark("00");
                data.setBuyerName(slipVO.getBuyerName());
                data.setInvoiceDate(String.valueOf(slipVO.getInvoiceAt()));
                data.setInvoiceCode(slipVO.getBwInvoiceCode());
                data.setApplyDesCribe("");
                data.setCollectionType(slipVO.getTaxationMethod());
                data.setSellerTaxNo(slipVO.getTaxNo());
                data.setDeduction(String.valueOf(slipVO.getDeductibleAmount()));
                data.setPhone(slipVO.getPhone());
                data.setInvoiceTotalPrice(String.valueOf(slipVO.getInvoiceTotalPrice()));
                data.setInvoiceTypeCode(slipVO.getInvoiceTypeCode());
                for (BusinessInvoiceSlipDetailVO detailVO:
                        slipVO.getInvoiceApplyRecordDetailVOList()) {
                    List<OutputRedinfoStandardapplyInvoiceDetail> invoiceDetailList = new ArrayList();
                    OutputRedinfoStandardapplyInvoiceDetail outputRedinfoStandardapplyInvoiceDetail = new OutputRedinfoStandardapplyInvoiceDetail();
                    outputRedinfoStandardapplyInvoiceDetail.setPriceTaxMark("0");
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsTaxRate(String.valueOf(detailVO.getGoodsTaxRate()));
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsTotalPrice(String.valueOf(detailVO.getGoodsTotalPrice()));
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsLineNature("0");
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsSpecification(detailVO.getGoodsSpecification());
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsPrice(String.valueOf(detailVO.getGoodsPrice()));
                    outputRedinfoStandardapplyInvoiceDetail.setFreeTaxMark("");
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsQuantity(String.valueOf(detailVO.getGoodsNumber()));
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsUnit(detailVO.getGoodsUnit());
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsTotalTax(String.valueOf(detailVO.getGoodsTotalTax()));
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsCode(detailVO.getGoodsTaxCode());
                    outputRedinfoStandardapplyInvoiceDetail.setPreferentialMark("0");
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsName(detailVO.getGoodsName());
                    outputRedinfoStandardapplyInvoiceDetail.setGoodsLineNo(String.valueOf(detailVO.getGoodsLineNo()));
                    outputRedinfoStandardapplyInvoiceDetail.setVatSpecialManagement("");
                    invoiceDetailList.add(outputRedinfoStandardapplyInvoiceDetail);
                    data.setInvoiceDetailList(invoiceDetailList);
                }
                if ("dev".equals(active) || "sit".equals(active) || "uat".equals(active)) {
                    // 税号
                    request.setTaxNo("36996300000000013");
                    data.setInvoiceTerminalCode("410123456725");

                }else {
                    Map<String, SysDictData> terminalCodeMap = sysDictTypeService.selectDictDataMapByType("business_invoice_terminal_code");
                    SysDictData sysDictData = terminalCodeMap.get(slipVO.getTaxNo());
                    if (null == sysDictData) {
                        log.info("红字发票编号[{}]未配置百望云机器编码,无法完成开票申请", slipVO.getSerialNo());
                        continue;
                    }
                    String invoiceTerminalCode = sysDictData.getDictLabel();
                    request.setTaxNo(slipVO.getTaxNo());
                    // 服务器/税务ukey
                    data.setInvoiceTerminalCode(invoiceTerminalCode);
                }
                request.setData(data);
                log.info("【请求业务参数：{}】",request);
                // 初始化一个客户端
                IBWClient client = new BWRestClient(loginConfig.getUrl(), loginConfig.getClientId(), loginConfig.getClientSecret());
                OutputRedinfoStandardapplyResponse response = client.outputRedinfo().standardapply(request, token);
                // 重载方法，可以传自定义请求唯一标识
                // OutputRedinfoStandardapplyResponse response = client.outputRedinfo().standardapply(request, token, requestId);
                log.info("响应业务参数:{}",response);
            } catch (BWOpenException e) {
                log.info("红字信息表开具异常：",e.getMessage());
            }
        }
    }*/
}
