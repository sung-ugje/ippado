package egovframework.ippado.sys.code.web;

import java.util.List;
import java.util.Map;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.ippado.sys.code.service.ClCodeVO;
import egovframework.ippado.sys.code.service.Code;
import egovframework.ippado.sys.code.service.CodeVO;
import egovframework.ippado.sys.code.service.DetailCodeVO;
import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.code.service.ClCodeService;
import egovframework.ippado.sys.code.service.CodeService;
import egovframework.ippado.sys.code.service.DetailCodeService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 *
 * 공통상세코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한
 * Controller를 정의한다
 * 
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */
@Controller
public class DetailCodeController extends IppadoBaseController {

	@Resource(name = "DetailCodeService")
	private DetailCodeService detailCodeDAO;

	@Resource(name = "ClCodeService")
	private ClCodeService clCodeService;

	@Resource(name = "CodeService")
	private CodeService codeService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 공통상세코드를 삭제한다.
	 * 
	 * @param loginVO
	 * @param cmmnDetailCode
	 * @param model
	 * @return "forward:/sys/code/DetailCodeList.do"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/DetailCodeRemove.do")
	public String deleteCmmnDetailCode(@ModelAttribute("loginVO") LoginVO loginVO, CmmnDetailCode cmmnDetailCode,
			ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		detailCodeDAO.deleteCmmnDetailCode(cmmnDetailCode);
		return "forward:/sys/code/DetailCodeList.do";
	}

	/**
	 * 공통상세코드를 등록한다.
	 * 
	 * @param loginVO
	 * @param cmmnDetailCode
	 * @param cmmnCode
	 * @param bindingResult
	 * @param model
	 * @return "/sys/code/DetailCodeRegist"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/DetailCodeRegist.do")
	public String insertCmmnDetailCode(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("cmmnDetailCode") CmmnDetailCode cmmnDetailCode, @ModelAttribute("cmmnCode") Code cmmnCode,
			BindingResult bindingResult, @RequestParam Map<String, Object> commandMap, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		String sCmd = commandMap.get("cmd") == null ? "" : (String) commandMap.get("cmd");
		if (cmmnDetailCode.getCodeId() == null || cmmnDetailCode.getCodeId().equals("")
				|| cmmnDetailCode.getCode() == null || cmmnDetailCode.getCode().equals("") || sCmd.equals("")) {

			ClCodeVO searchClCodeVO;
			searchClCodeVO = new ClCodeVO();
			searchClCodeVO.setRecordCountPerPage(999999);
			searchClCodeVO.setFirstIndex(0);
			searchClCodeVO.setSearchCondition("CodeList");
			List<?> CmmnClCodeList = clCodeService.selectCmmnClCodeList(searchClCodeVO);
			model.addAttribute("cmmnClCodeList", CmmnClCodeList);

			CodeVO searchCodeVO;
			searchCodeVO = new CodeVO();
			searchCodeVO.setRecordCountPerPage(999999);
			searchCodeVO.setFirstIndex(0);
			searchCodeVO.setSearchCondition("clCode");
			if (cmmnCode.getClCode().equals("")) {
				EgovMap emp = (EgovMap) CmmnClCodeList.get(0);
				cmmnCode.setClCode(emp.get("clCode").toString());
			}
			searchCodeVO.setSearchKeyword(cmmnCode.getClCode());

			// List CmmnCodeList = codeService.selectCmmnCodeList(searchCodeVO);
			model.addAttribute("cmmnCodeList", codeService.selectCmmnCodeList(searchCodeVO));

			return "/sys/code/DetailCodeRegist";
		} else if (sCmd.equals("Regist")) {

			beanValidator.validate(cmmnDetailCode, bindingResult);
			if (bindingResult.hasErrors()) {
				ClCodeVO searchClCodeVO;
				searchClCodeVO = new ClCodeVO();
				searchClCodeVO.setRecordCountPerPage(999999);
				searchClCodeVO.setFirstIndex(0);
				List<?> CmmnClCodeList = clCodeService.selectCmmnClCodeList(searchClCodeVO);
				model.addAttribute("cmmnClCodeList", CmmnClCodeList);

				CodeVO searchCodeVO;
				searchCodeVO = new CodeVO();
				searchCodeVO.setRecordCountPerPage(999999);
				searchCodeVO.setFirstIndex(0);
				searchCodeVO.setSearchCondition("clCode");
				if (cmmnCode.getClCode().equals("")) {
					EgovMap emp = (EgovMap) CmmnClCodeList.get(0);
					cmmnCode.setClCode(emp.get("clCode").toString());
				}
				searchCodeVO.setSearchKeyword(cmmnCode.getClCode());

				// List CmmnCodeList = codeService.selectCmmnCodeList(searchCodeVO);
				model.addAttribute("cmmnCodeList", codeService.selectCmmnCodeList(searchCodeVO));

				return "/sys/code/DetailCodeRegist";
			}

			cmmnDetailCode.setFrstRegisterId(loginVO.getUniqId());
			detailCodeDAO.insertCmmnDetailCode(cmmnDetailCode);
			return "forward:/sys/code/DetailCodeList.do";
		} else {
			return "forward:/sys/code/DetailCodeList.do";
		}
	}

	/**
	 * 공통상세코드 상세항목을 조회한다.
	 * 
	 * @param loginVO
	 * @param cmmnDetailCode
	 * @param model
	 * @return "sys/code/DetailCodeDetail"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/DetailCodeDetail.do")
	public String selectCmmnDetailCodeDetail(@ModelAttribute("loginVO") LoginVO loginVO, CmmnDetailCode cmmnDetailCode,
			ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		CmmnDetailCode vo = detailCodeDAO.selectCmmnDetailCodeDetail(cmmnDetailCode);
		model.addAttribute("result", vo);

		return "sys/code/DetailCodeDetail";
	}

	/**
	 * 공통상세코드 목록을 조회한다.
	 * 
	 * @param loginVO
	 * @param searchVO
	 * @param model
	 * @return "/sys/code/DetailCodeList"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/DetailCodeList.do")
	public String selectCmmnDetailCodeList(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("searchVO") DetailCodeVO searchVO, ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		setPageInfo(searchVO, model, detailCodeDAO.selectCmmnDetailCodeListTotCnt(searchVO));

		model.addAttribute("resultList", detailCodeDAO.selectCmmnDetailCodeList(searchVO));

		return "/sys/code/DetailCodeList";
	}

	/**
	 * 공통상세코드를 수정한다.
	 * 
	 * @param loginVO
	 * @param cmmnDetailCode
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "/sys/code/DetailCodeModify"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sys/code/DetailCodeModify.do")
	public String updateCmmnDetailCode(@ModelAttribute("loginVO") LoginVO loginVO,
			@ModelAttribute("cmmnDetailCode") CmmnDetailCode cmmnDetailCode, BindingResult bindingResult,
			@RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated()) return goLogin(model);

		String sCmd = commandMap.get("cmd") == null ? "" : (String) commandMap.get("cmd");
		if (sCmd.equals("")) {
			CmmnDetailCode vo = detailCodeDAO.selectCmmnDetailCodeDetail(cmmnDetailCode);
			model.addAttribute("cmmnDetailCode", vo);

			return "/sys/code/DetailCodeModify";
		} else if (sCmd.equals("Modify")) {
			beanValidator.validate(cmmnDetailCode, bindingResult);
			if (bindingResult.hasErrors()) {
				CmmnDetailCode vo = detailCodeDAO.selectCmmnDetailCodeDetail(cmmnDetailCode);
				model.addAttribute("cmmnDetailCode", vo);

				return "/sys/code/DetailCodeModify";
			}

			cmmnDetailCode.setLastUpdusrId(loginVO.getUniqId());
			detailCodeDAO.updateCmmnDetailCode(cmmnDetailCode);
			return "forward:/sys/code/DetailCodeList.do";
		} else {
			return "forward:/sys/code/DetailCodeList.do";
		}
	}

}