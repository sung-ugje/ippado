package egovframework.ippado.base;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class IppadoBaseController {
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	protected EgovMessageSource egovMessageSource;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** cmmUseService */
	@Resource(name = "EgovCmmUseService")
	protected EgovCmmUseService cmmUseService;

	protected String goLogin(ModelMap model) {
		model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
		return "sys/user/LoginUsr";
	}

	protected String goLogin(Model model) {
		model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
		return "sys/user/LoginUsr";
	}

	protected String goLogin() {
		return "redirect:/sys/user/loginUsr.do";
	}

	protected void setPageInfo(ComDefaultVO vo, ModelMap model, int totCnt) {

		vo.setPageUnit(propertiesService.getInt("pageUnit"));
		vo.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
	}

	protected void setCodeDetail(ModelMap model, String codeName, String codeId) throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId(codeId);
		model.addAttribute(codeName, cmmUseService.selectCmmCodeDetail(vo));// 사용자상태코드목록
	}

	protected void setCodeDetail(Model model, String codeName, String codeId) throws Exception {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId(codeId);
		model.addAttribute(codeName, cmmUseService.selectCmmCodeDetail(vo));// 사용자상태코드목록
	}
}
