package com.gemcoder.system.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.DepotconfigurationService;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Depotconfiguration")
public class DepotconfigurationController {

	@Value("${upload.dir:d:\\upload}")
	String uploadDir;

	@Resource
	private DepotconfigurationService DepotconfigurationService;

	@RequestMapping(value = "/getYardList")
	@ResponseBody
	public Result getYardList(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getYardList(paramMap);
	}

	@RequestMapping(value = "/searchYardList")
	@ResponseBody
	public Result searchYardList(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.searchYardList(paramMap);
	}

	@RequestMapping(value = "/updateSelectedYardsStatus")
	@ResponseBody
	public Result updateSelectedYardsStatus(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.updateSelectedYardsStatus(paramMap);
	}

	@RequestMapping(value = "/reuseSelectedYardsStatus")
	@ResponseBody
	public Result reuseSelectedYardsStatus(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.reuseSelectedYardsStatus(paramMap);
	}

	@RequestMapping(value = "/getYardListJGV")
	@ResponseBody
	public Result getYardListJGV(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getYardListJGV(paramMap);
	}

	@RequestMapping(value = "/getYardDetails")
	@ResponseBody
	public Result getYardDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getYardDetails(paramMap);
	}

	@RequestMapping(value = "/searchBillingRules")
	@ResponseBody
	public Result searchBillingRules(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.searchBillingRules(paramMap);
	}

	@RequestMapping(value = "/addYardBillingRule")
	@ResponseBody
	public Result addYardBillingRule(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.addYardBillingRule(paramMap);
	}

	@RequestMapping(value = "/deleteRowData")
	@ResponseBody
	public Result deleteRowData(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.deleteRowData(paramMap);
	}

	@RequestMapping(value = "/addPostPersonnel")
	@ResponseBody
	public Result addPostPersonnel(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.addPostPersonnel(paramMap);
	}

	@RequestMapping(value = "/deactivateRule")
	@ResponseBody
	public Result deactivateRule(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.deactivateRule(paramMap);
	}

	@RequestMapping(value = "/updateYardDetails")
	@ResponseBody
	public Result updateYardDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 校验车场名称是否必填
		if (paramMap.get("Nameofyard1value3") == null
				|| String.valueOf(paramMap.get("Nameofyard1value3")).trim().isEmpty()) {
			return new Result(false, "车场名称必填!", null);
		}
		// 校验泊车数量是否必填
		if (paramMap.get("Numberofparkingvalue3") == null) {
			return new Result(false, "泊车数量必填!", null);
		}
		// 校验运营公司是否必填
		if (paramMap.get("OperatingCompany1value3") == null
				|| String.valueOf(paramMap.get("OperatingCompany1value3")).trim().isEmpty()) {
			return new Result(false, "运营公司必填!", null);
		}
		// 校验负责人是否必填
		if (paramMap.get("Personinchargevalue3") == null
				|| String.valueOf(paramMap.get("Personinchargevalue3")).trim().isEmpty()) {
			return new Result(false, "负责人必填!", null);
		}
		// 校验联系电话是否必填
		if (paramMap.get("ContactPhonevalue4") == null
				|| String.valueOf(paramMap.get("ContactPhonevalue4")).trim().isEmpty()) {
			return new Result(false, "联系电话必填!", null);
		}
		// 校验经纬度是否必填
		if (paramMap.get("latitudeandlongitudevalue3") == null
				|| String.valueOf(paramMap.get("latitudeandlongitudevalue3")).trim().isEmpty()) {
			return new Result(false, "经纬度必填!", null);
		}
		// 校验车场状态是否必填
		if (paramMap.get("yardstatus1value3") == null
				|| String.valueOf(paramMap.get("yardstatus1value3")).trim().isEmpty()) {
			return new Result(false, "车场状态必填!", null);
		}
		// 校验车场类型是否必填
		if (paramMap.get("Typeofyard1value3") == null
				|| String.valueOf(paramMap.get("Typeofyard1value3")).trim().isEmpty()) {
			return new Result(false, "车场类型必填!", null);
		}
		// 校验大屏是否可见是否必填
		if (paramMap.get("Whetherthelargescreenisvisiblevalue3") == null
				|| String.valueOf(paramMap.get("Whetherthelargescreenisvisiblevalue3")).trim().isEmpty()) {
			return new Result(false, "大屏是否可见必填!", null);
		}
		// 调用service层的代码
		return DepotconfigurationService.updateYardDetails(paramMap);
	}

	@RequestMapping(value = "/getYardListZVO")
	@ResponseBody
	public Result getYardListZVO(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getYardListZVO(paramMap);
	}

	@RequestMapping(value = "/getYardBillingRules")
	@ResponseBody
	public Result getYardBillingRules(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getYardBillingRules(paramMap);
	}

	@RequestMapping(value = "/getPaginatedYardBillingRules")
	@ResponseBody
	public Result getPaginatedYardBillingRules(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPaginatedYardBillingRules(paramMap);
	}

	@RequestMapping(value = "/getYardBillingRuleByParkingId")
	@ResponseBody
	public Result getYardBillingRuleByParkingId(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getYardBillingRuleByParkingId(paramMap);
	}

	@RequestMapping(value = "/getFileAttachmentList")
	@ResponseBody
	public Result getFileAttachmentList(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getFileAttachmentList(paramMap);
	}

	@RequestMapping(value = "/getPaginatedFileAttachmentList")
	@ResponseBody
	public Result getPaginatedFileAttachmentList(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPaginatedFileAttachmentList(paramMap);
	}

	@RequestMapping(value = "/getPostPersonnelList")
	@ResponseBody
	public Result getPostPersonnelList(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPostPersonnelList(paramMap);
	}

	@RequestMapping(value = "/getPaginatedPostPersonnel")
	@ResponseBody
	public Result getPaginatedPostPersonnel(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPaginatedPostPersonnel(paramMap);
	}

	@RequestMapping(value = "/getAllParkingLots")
	@ResponseBody
	public Result getAllParkingLots(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getAllParkingLots(paramMap);
	}

	@RequestMapping(value = "/getPaginatedParkingLots")
	@ResponseBody
	public Result getPaginatedParkingLots(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPaginatedParkingLots(paramMap);
	}

	@RequestMapping(value = "/getParkingLotDetails")
	@ResponseBody
	public Result getParkingLotDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getParkingLotDetails(paramMap);
	}

	@RequestMapping(value = "/getPlatformInformation")
	@ResponseBody
	public Result getPlatformInformation(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPlatformInformation(paramMap);
	}

	@RequestMapping(value = "/getOperatingRules")
	@ResponseBody
	public Result getOperatingRules(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getOperatingRules(paramMap);
	}

	@RequestMapping(value = "/getBillingRules")
	@ResponseBody
	public Result getBillingRules(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getBillingRules(paramMap);
	}

	@RequestMapping(value = "/getPostManagement")
	@ResponseBody
	public Result getPostManagement(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPostManagement(paramMap);
	}

	@RequestMapping(value = "/getExtendedInformation")
	@ResponseBody
	public Result getExtendedInformation(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getExtendedInformation(paramMap);
	}

	@RequestMapping(value = "/getParkingLotOperationRecords")
	@ResponseBody
	public Result getParkingLotOperationRecords(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getParkingLotOperationRecords(paramMap);
	}

	@RequestMapping(value = "/getPaginatedOperationRecords")
	@ResponseBody
	public Result getPaginatedOperationRecords(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getPaginatedOperationRecords(paramMap);
	}

	@RequestMapping(value = "/getBillingRulesAM1")
	@ResponseBody
	public Result getBillingRulesAM1(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getBillingRulesAM1(paramMap);
	}

	@RequestMapping(value = "/validateNewYardForm")
	@ResponseBody
	public Result validateNewYardForm(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 校验车场名称
		if (paramMap.get("Nameofyard1value2") == null || String.valueOf(paramMap.get("Nameofyard1value2")).isEmpty()) {
			return new Result(false, "车场名称必填", null);
		}
		// 校验负责人
		if (paramMap.get("Personinchargevalue2") == null
				|| String.valueOf(paramMap.get("Personinchargevalue2")).isEmpty()) {
			return new Result(false, "负责人必填", null);
		}
		// 校验联系电话
		if (paramMap.get("ContactPhonevalue2") == null
				|| String.valueOf(paramMap.get("ContactPhonevalue2")).isEmpty()) {
			return new Result(false, "联系电话必填", null);
		}
		// 校验运营公司
		if (paramMap.get("OperatingCompany1value2") == null
				|| String.valueOf(paramMap.get("OperatingCompany1value2")).isEmpty()) {
			return new Result(false, "运营公司必填", null);
		}
		// 调用service层的代码
		return DepotconfigurationService.validateNewYardForm(paramMap);
	}

	@RequestMapping(value = "/addNewYard")
	@ResponseBody
	public Result addNewYard(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 校验车场名称
		if (paramMap.get("Nameofyard1value2") == null || String.valueOf(paramMap.get("Nameofyard1value2")).isEmpty()) {
			return new Result(false, "车场名称必填", null);
		}
		// 校验泊车数量
		if (paramMap.get("Numberofparkingvalue2") == null) {
			return new Result(false, "泊车数量必填", null);
		}
		// 校验运营公司
		if (paramMap.get("OperatingCompany1value2") == null
				|| String.valueOf(paramMap.get("OperatingCompany1value2")).isEmpty()) {
			return new Result(false, "运营公司必填", null);
		}
		// 校验负责人
		if (paramMap.get("Personinchargevalue2") == null
				|| String.valueOf(paramMap.get("Personinchargevalue2")).isEmpty()) {
			return new Result(false, "负责人必填", null);
		}
		// 校验联系电话
		if (paramMap.get("ContactPhonevalue2") == null
				|| String.valueOf(paramMap.get("ContactPhonevalue2")).isEmpty()) {
			return new Result(false, "联系电话必填", null);
		}
		// 校验车场状态
		if (paramMap.get("yardstatus1value2") == null || String.valueOf(paramMap.get("yardstatus1value2")).isEmpty()) {
			return new Result(false, "车场状态必填", null);
		}
		// 校验车场类型
		if (paramMap.get("Typeofyard1value2") == null || String.valueOf(paramMap.get("Typeofyard1value2")).isEmpty()) {
			return new Result(false, "车场类型必填", null);
		}
		// 校验大屏是否可见
		if (paramMap.get("Whetherthelargescreenisvisiblevalue2") == null) {
			return new Result(false, "大屏是否可见必填", null);
		}
		// 调用service层的代码
		return DepotconfigurationService.addNewYard(paramMap);
	}

	@RequestMapping(value = "/getYardListCWC")
	@ResponseBody
	public Result getYardListCWC(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 没有需要校验的入参
		// 调用service层的代码
		return DepotconfigurationService.getYardListCWC(paramMap);
	}

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public Result upload(HttpServletRequest req, final @RequestParam("file") MultipartFile uploadFile)
			throws IllegalStateException, IOException {
		String destpath = null;

		// log.info("jarDir:{}",jarDir);
		// log.info("OriginalFilename:{}",jarFile.getOriginalFilename());
		if (uploadDir.endsWith(File.separator)) {
			destpath = uploadDir + uploadFile.getOriginalFilename();// jarFile.getName();
		} else {
			destpath = uploadDir + File.separatorChar + uploadFile.getOriginalFilename();
		}
		final String dest = destpath;
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				File newFile = new File(dest);
				// 判断文件是否存在，存在就删除
				if (newFile.exists()) {
					deleteFile(dest);
				}
				try {
					uploadFile.transferTo(newFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
		t.start();
		return new Result(true, destpath, destpath);
	}

	@RequestMapping(value = "/enableBillingRule")
	@ResponseBody
	public Result enableBillingRule(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.enableBillingRule(paramMap);
	}

	@RequestMapping(value = "/disableBillingRule")
	@ResponseBody
	public Result disableBillingRule(@RequestBody(required = false) Map<String, Object> paramMap) {
		return DepotconfigurationService.disableBillingRule(paramMap);
	}

	@RequestMapping(value = "/addBillingRule")
	@ResponseBody
	public Result addBillingRule(@RequestBody(required = false) Map<String, Object> paramMap) {
		return DepotconfigurationService.addBillingRule(paramMap);
	}

	@RequestMapping(value = "/updateEmployeeStatus")
	@ResponseBody
	public Result updateEmployeeStatus(@RequestBody Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.updateEmployeeStatus(paramMap);
	}

	@RequestMapping(value = "/getRuleList")
	@ResponseBody
	public Result getRuleList(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return DepotconfigurationService.getRuleList(paramMap);
	}

	@RequestMapping(value = "/getQRcodeList")
	@ResponseBody
	public Result getQRcodeList(@RequestBody(required = false) Map<String, Object> paramMap) {
		if (paramMap.get("id") == null) {
			return new Result(false, "停车场id必填", null);
		}
		return DepotconfigurationService.getQRcodeList(paramMap);
	}

	
	private boolean deleteFile(String jarPath) {
		File file = new File(jarPath);
		// 判断目录或文件是否存在
		if (!file.exists()) {
			// 不存在
			return false;
		} else {
			file.delete();
			return true;
		}
	}
}
