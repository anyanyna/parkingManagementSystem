package com.gemcoder.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.BillingmanagementService;
import com.gemcoder.system.service.OperationBoardService;
import com.gemcoder.system.util.ExcelUtil;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.*;
import java.util.Map;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

@Controller
@RequestMapping("/Billingmanagement")
public class BillingmanagementController {
	private static final Logger log = LoggerFactory.getLogger(BillingmanagementController.class);
	@Value("${upload.dir:d:\\upload}")
	String uploadDir;
    @Resource
    private BillingmanagementService BillingmanagementService;

    @RequestMapping(value = "/resetBillingManagementList")
    @ResponseBody
    public Result resetBillingManagementList(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.resetBillingManagementList(paramMap);
    }

    @RequestMapping(value = "/queryBillingManagementList")
    @ResponseBody
    public Result queryBillingManagementList(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getBillingManagementList(paramMap);
    }

    @RequestMapping(value = "/getBillingOperationRecords")
    @ResponseBody
    public Result getBillingOperationRecords(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getBillingOperationRecords(paramMap);
    }

    @RequestMapping(value = "/getBillingManagementList")
    @ResponseBody
    public Result getBillingManagementList(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getBillingManagementList(paramMap);
    }

    @RequestMapping(value = "/getRuleInformation")
    @ResponseBody
    public Result getRuleInformation(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getRuleInformation(paramMap);
    }

    @RequestMapping(value = "/getOperationRecords")
    @ResponseBody
    public Result getOperationRecords(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getOperationRecords(paramMap);
    }

    @RequestMapping(value = "/deleteRecord")
    @ResponseBody
    public Result deleteRecord(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.deleteRecord(paramMap);
    }

    @RequestMapping(value = "/refreshTableData")
    @ResponseBody
    public Result refreshTableData(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.refreshTableData(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme")
    @ResponseBody
    public Result changeBillingScheme(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeBillingScheme(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme2")
    @ResponseBody
    public Result changeBillingScheme2(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 temporaryCar 是否必填
        if (paramMap.get("temporaryCar") == null || String.valueOf(paramMap.get("temporaryCar")).isEmpty()) {
            return new Result(false, "temporaryCar 必填", null);
        }
        // 校验 storedValueCar 是否必填
        if (paramMap.get("storedValueCar") == null || String.valueOf(paramMap.get("storedValueCar")).isEmpty()) {
            return new Result(false, "storedValueCar 必填", null);
        }
        // 校验 temporaryCarFirstTier 是否必填
        if (paramMap.get("temporaryCarFirstTier") == null) {
            return new Result(false, "temporaryCarFirstTier 必填", null);
        }
        // 校验 temporaryCarSecondTier 是否必填
        if (paramMap.get("temporaryCarSecondTier") == null) {
            return new Result(false, "temporaryCarSecondTier 必填", null);
        }
        // 校验 temporaryCarThirdTier 是否必填
        if (paramMap.get("temporaryCarThirdTier") == null) {
            return new Result(false, "temporaryCarThirdTier 必填", null);
        }
        // 校验 storedValueCarFirstTier 是否必填
        if (paramMap.get("storedValueCarFirstTier") == null) {
            return new Result(false, "storedValueCarFirstTier 必填", null);
        }
        // 校验 storedValueCarSecondTier 是否必填
        if (paramMap.get("storedValueCarSecondTier") == null) {
            return new Result(false, "storedValueCarSecondTier 必填", null);
        }
        // 校验 storedValueCarThirdTier 是否必填
        if (paramMap.get("storedValueCarThirdTier") == null) {
            return new Result(false, "storedValueCarThirdTier 必填", null);
        }
        // 调用service层的代码
        return BillingmanagementService.changeBillingScheme2(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme3")
    @ResponseBody
    public Result changeBillingScheme3(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeBillingScheme3(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme4")
    @ResponseBody
    public Result changeBillingScheme4(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeBillingScheme4(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme5")
    @ResponseBody
    public Result changeBillingScheme5(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeBillingScheme5(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme6")
    @ResponseBody
    public Result changeBillingScheme6(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeBillingScheme6(paramMap);
    }

    @RequestMapping(value = "/changeBillingScheme7")
    @ResponseBody
    public Result changeBillingScheme7(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeBillingScheme7(paramMap);
    }

    @RequestMapping(value = "/openNewBillingModal")
    @ResponseBody
    public Result openNewBillingModal(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.openNewBillingModal(paramMap);
    }

    @RequestMapping(value = "/changeEditBillingScheme")
    @ResponseBody
    public Result changeEditBillingScheme(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeEditBillingScheme(paramMap);
    }

    @RequestMapping(value = "/changeEditBillingScheme2")
    @ResponseBody
    public Result changeEditBillingScheme2(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeEditBillingScheme2(paramMap);
    }

    @RequestMapping(value = "/handleChargingSchemeChangeHv8")
    @ResponseBody
    public Result handleChargingSchemeChangeHv8(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.handleChargingSchemeChangeHv8(paramMap);
    }

    @RequestMapping(value = "/handleChargingSchemeChangeyYk")
    @ResponseBody
    public Result handleChargingSchemeChangeyYk(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.handleChargingSchemeChangeyYk(paramMap);
    }

    @RequestMapping(value = "/handleChargingSchemeChangelDp")
    @ResponseBody
    public Result handleChargingSchemeChangelDp(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.handleChargingSchemeChangelDp(paramMap);
    }

    @RequestMapping(value = "/handleChargingSchemeChangePrw")
    @ResponseBody
    public Result handleChargingSchemeChangePrw(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.handleChargingSchemeChangePrw(paramMap);
    }

    @RequestMapping(value = "/handleChargingSchemeChangeBDF")
    @ResponseBody
    public Result handleChargingSchemeChangeBDF(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.handleChargingSchemeChangeBDF(paramMap);
    }

    @RequestMapping(value = "/updateBillingRule")
    @ResponseBody
    public Result updateBillingRule(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 RuleNamevalue2 是否存在且不为空
        if (paramMap.get("id") == null || String.valueOf(paramMap.get("id")).trim().isEmpty()) {
            return new Result(false, "id 必填", null);
        }
        if (paramMap.get("rule_name") == null || String.valueOf(paramMap.get("rule_name")).trim().isEmpty()) {
        	return new Result(false, "rule_name 必填", null);
        }
        // 校验 chargingschemevalue1 是否存在且不为空
		/*
		 * if (paramMap.get("chargingschemevalue1") == null ||
		 * String.valueOf(paramMap.get("chargingschemevalue1")).trim().isEmpty()) {
		 * return new Result(false, "chargingschemevalue1 必填", null); }
		 */
        // 调用service层的代码
        return BillingmanagementService.updateBillingRule(paramMap);
    }

    @RequestMapping(value = "/getParkingLotList")
    @ResponseBody
    public Result getParkingLotList(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 该接口没有需要校验的参数
        // 调用service层的代码
        return BillingmanagementService.getParkingLotList(paramMap);
    }

    @RequestMapping(value = "/validateRuleInformation")
    @ResponseBody
    public Result validateRuleInformation(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 ruleName 是否存在且不为空
        if (paramMap.get("rule_name") == null || String.valueOf(paramMap.get("rule_name")).trim().isEmpty()) {
            return new Result(false, "rule_name 必填", null);
        }
        // 校验 chargingScheme 是否存在且不为空
		/*
		 * if (paramMap.get("chargingScheme") == null ||
		 * String.valueOf(paramMap.get("chargingScheme")).trim().isEmpty()) { return new
		 * Result(false, "chargingScheme 必填", null); }
		 */
        // 调用service层的代码
        return BillingmanagementService.validateRuleInformation(paramMap);
    }

    @RequestMapping(value = "/generateRuleNumber")
    @ResponseBody
    public Result generateRuleNumber(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 该接口无请求参数需要校验
        // 调用service层的代码
        return BillingmanagementService.generateRuleNumber(paramMap);
    }

    @RequestMapping(value = "/saveBillingRule")
    @ResponseBody
    public Result saveBillingRule(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 ruleName 是否存在且不为空
        if (paramMap.get("rule_name") == null || String.valueOf(paramMap.get("rule_name")).trim().isEmpty()) {
            return new Result(false, "ruleName 必填", null);
        }
        // 校验 chargingScheme 是否存在且不为空
		/*
		 * if (paramMap.get("chargingScheme") == null ||
		 * String.valueOf(paramMap.get("chargingScheme")).trim().isEmpty()) { return new
		 * Result(false, "chargingScheme 必填", null); }
		 */
        // 调用service层的代码
        return BillingmanagementService.saveBillingRule(paramMap);
    }

    @RequestMapping(value = "/refreshBillingManagementList")
    @ResponseBody
    public Result refreshBillingManagementList(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 该接口无请求参数需要校验
        // 调用service层的代码
        return BillingmanagementService.refreshBillingManagementList(paramMap);
    }

    @RequestMapping(value = "/getAssociatedParkingLots")
    @ResponseBody
    public Result getAssociatedParkingLots(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getAssociatedParkingLots(paramMap);
    }

    @RequestMapping(value = "/changeSegmentedBilling")
    @ResponseBody
    public Result changeSegmentedBilling(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeSegmentedBilling(paramMap);
    }

    @RequestMapping(value = "/changeSegmentedBilling2")
    @ResponseBody
    public Result changeSegmentedBilling2(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.changeSegmentedBilling2(paramMap);
    }

    @RequestMapping(value = "/addHolidayComponent")
    @ResponseBody
    public Result addHolidayComponent(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.addHolidayComponent(paramMap);
    }
    
    @RequestMapping(value = "/getHolidaysList")
    @ResponseBody
    public Result getHolidaysList(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getHolidaysList(paramMap);
    }
    @RequestMapping(value = "/getFreeTimeRange")
    @ResponseBody
    public Result getFreeTimeRange(@RequestBody(required = false) Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return BillingmanagementService.getFreeTimeRange(paramMap);
    }
    @RequestMapping(value = "/updateBilllingFreeTimeRange")
    @ResponseBody
    public Result updateBilllingFreeTimeRange (@RequestBody(required = false) Map<String, Object>paramMap) {
    	 if (paramMap.get("billing_rule_id") == null || String.valueOf(paramMap.get("billing_rule_id")).trim().isEmpty()) {
             return new Result(false, "billing_rule_id 必填", null);
         }
    	BillingmanagementService.saveBilllingFreeTimeRange(Integer.parseInt(String.valueOf(paramMap.get("billing_rule_id"))),paramMap);
    	return new Result(true, "更新成功", null);
    }
    @RequestMapping(value = "/updateBilllingHoliday")
    @ResponseBody
    public Result updateBilllingHoliday (@RequestBody(required = false) Map<String, Object>paramMap) {
    	if (paramMap.get("billing_rule_id") == null || String.valueOf(paramMap.get("billing_rule_id")).trim().isEmpty()) {
    		return new Result(false, "billing_rule_id 必填", null);
    	}
    	BillingmanagementService.saveBilllingHoliday(Integer.parseInt(String.valueOf(paramMap.get("billing_rule_id"))),paramMap);
    	return new Result(true, "更新成功", null);
    }
    @RequestMapping(value = "/getBillingRuleDetails")
    @ResponseBody
    public Result getBillingRuleDetails (@RequestBody(required = false) Map<String, Object>paramMap) {
    	 return BillingmanagementService.getBillingRuleDetails(paramMap);
    }
    @RequestMapping(value = "/deleteCurrentRecord")
    @ResponseBody
    public Result deleteCurrentRecord (@RequestBody(required = false) Map<String, Object>paramMap) {
    	return BillingmanagementService.deleteRecord(paramMap);
    }
    @RequestMapping(value = "/searchBillingManagementList")
    @ResponseBody
    public Result searchBillingManagementList (@RequestBody(required = false) Map<String, Object>paramMap) {
    	return BillingmanagementService.searchBillingManagementList(paramMap);
    }
    
    ///////////////////////////////
    @RequestMapping(value = "/getRuleInfo")
    @ResponseBody
    public Result getRuleInfo(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getRuleInfo(paramMap);
    }
    @RequestMapping(value = "/showAddBillingModal")
    @ResponseBody
    public Result showAddBillingModal(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
    	return new Result(true,"新建成功",new HashMap<String,Object>());
    }
    @RequestMapping(value = "/getBillingManagementList6AP")
    @ResponseBody
    public Result getBillingManagementList6AP(@RequestBody Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return BillingmanagementService.getBillingManagementList(paramMap);
    }
    @RequestMapping(value = "/fetchTableData")
    @ResponseBody
    public Result fetchTableData(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.fetchTableData(paramMap);
    }
    @RequestMapping(value = "/syncHolidayTimes")
    @ResponseBody
    public Result syncHolidayTimes(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.syncHolidayTimes(paramMap);
    }
    
    @RequestMapping(value = "/deleteHoliday")
    @ResponseBody
    public Result deleteHoliday(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.deleteHoliday(paramMap);
    }
    @RequestMapping(value = "/deleteHolidayByRule")
    @ResponseBody
    public Result deleteHolidayByRule(@RequestBody(required = false) Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return BillingmanagementService.deleteHolidayByRule(paramMap);
    }
    @RequestMapping(value = "/deleteFreeTimeRange")
    @ResponseBody
    public Result deleteFreeTimeRange(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.deleteFreeTimeRange(paramMap);
    }
    @RequestMapping(value = "/deleteFreeTimeRangeByRule")
    @ResponseBody
    public Result deleteFreeTimeRangeByRule(@RequestBody(required = false) Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return BillingmanagementService.deleteFreeTimeRangeByRule(paramMap);
    }
    @PostMapping(value = "/holidayUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public Result holidayUpload(HttpServletRequest req,final @RequestParam("file") MultipartFile uploadFile)
			throws IllegalStateException, IOException {
		String destpath = null;
		
		//log.info("jarDir:{}",jarDir);
		//log.info("OriginalFilename:{}",jarFile.getOriginalFilename());
		if (uploadDir.endsWith(File.separator)) {
			destpath = uploadDir + uploadFile.getOriginalFilename();// jarFile.getName();
		} else {
			destpath = uploadDir + File.separatorChar + uploadFile.getOriginalFilename();
		}
		final String dest=destpath;
		File newFile = new File(dest);
		uploadFile.transferTo(newFile);
		
		List<Map<String, Object>> rst;
		try {
			rst = ExcelUtil.batchUpload(newFile);
		} catch (Exception e) {
			log.warn(e.toString(),e);
			return new Result(false, "上传失败", e.toString()); 
		}
		return new Result(true, "上传成功", rst);
	}
    
    @RequestMapping(value = "/getYardListByRule")
    @ResponseBody
    public Result getYardListByRule(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BillingmanagementService.getYardListByRule(paramMap);
    }
    
}
