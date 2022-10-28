package egovframework.ippado.sys.author.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.author.service.AuthorMenuManageService;
import egovframework.ippado.sys.author.service.AuthorMenuVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 * 메뉴목록 관리및 권한별메뉴, 사이트맵 생성을 처리하는 비즈니스 구현 클래스
 *
 * @author 개발환경 개발팀 이용
 * @since 2009.06.01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * &lt;&lt; 개정이력(Modification Information) &gt;&gt;
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  이  용          최초 생성
 * 	 2011.07.29	 서준식          사이트맵 저장경로 수정
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *      </pre>
 */

@Controller
public class AuthorMenuManageController extends IppadoBaseController {

	/** EgovMenuManageService */
	@Resource(name = "meunCreateManageService")
	private AuthorMenuManageService menuCreateManageService;

	/**
	 * *권한별메뉴목록을 조회한다.
	 *
	 * @param searchVO ComDefaultVO
	 * @return 출력페이지정보 "sys/author/AuthorMenuManage"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorMenuManageSelect.do")
	public String selectAuthorMenuManagList(@ModelAttribute("searchVO") ComDefaultVO searchVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String resultMsg = "";

		if (searchVO.getSearchKeyword() != null && !searchVO.getSearchKeyword().equals("")) {
			int IDcnt = menuCreateManageService.selectUsrByPk(searchVO);
			if (IDcnt == 0) {
				resultMsg = egovMessageSource.getMessage("info.nodata.msg");
			} else {
				/* AuthorCode 검색 */
				AuthorMenuVO vo = new AuthorMenuVO();
				vo = menuCreateManageService.selectAuthorByUsr(searchVO);
				searchVO.setSearchKeyword(vo.getAuthorCode());
			}
		}
		model.addAttribute("list_menumanage", menuCreateManageService.selectAuthorMenuManagList(searchVO));

		setPageInfo(searchVO, model, menuCreateManageService.selectAuthorMenuManagTotCnt(searchVO));

		model.addAttribute("resultMsg", resultMsg);

		return "sys/author/AuthorMenuManage";
	}

	/**
	 * 권한별메뉴 세부화면을 조회한다.
	 *
	 * @param menuCreatVO AuthorMenuVO
	 * @return 출력페이지정보 "sys/author/AuthorMenu"
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/author/AuthorMenuSelect.do")
	public String selectAuthorMenuList(@ModelAttribute("menuCreatVO") AuthorMenuVO menuCreatVO, ModelMap model)
			throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		model.addAttribute("list_menulist", menuCreateManageService.selectAuthorMenuList(menuCreatVO));
		model.addAttribute("resultVO", menuCreatVO);

		return "sys/author/AuthorMenu";
	}

	/**
	 * 권한별메뉴처리 및 권한별메뉴내역을 등록한다.
	 *
	 * @param checkedAuthorForInsert String
	 * @param checkedMenuNoForInsert String
	 * @return 출력페이지정보 등록처리시 "forward:/sys/author/AuthorMenuSelect.do"
	 * @exception Exception
	 */
	@RequestMapping("/sys/author/AuthorMenuInsert.do")
	public String insertAuthorMenuList(@RequestParam("checkedAuthorForInsert") String checkedAuthorForInsert,
			@RequestParam("checkedMenuNoForInsert") String checkedMenuNoForInsert,
			@ModelAttribute("menuCreatVO") AuthorMenuVO menuCreatVO, ModelMap model) throws Exception {
		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		String resultMsg = "";
		String[] insertMenuNo = checkedMenuNoForInsert.split(",");
		if (insertMenuNo == null || (insertMenuNo.length == 0)) {
			resultMsg = egovMessageSource.getMessage("fail.common.insert");
		} else {
			menuCreateManageService.insertAuthorMenuList(checkedAuthorForInsert, checkedMenuNoForInsert);
			resultMsg = egovMessageSource.getMessage("success.common.insert");
		}
		model.addAttribute("resultMsg", resultMsg);
		return "forward:/sys/author/AuthorMenuSelect.do";
	}

}
