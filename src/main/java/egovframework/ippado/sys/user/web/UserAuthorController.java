package egovframework.ippado.sys.user.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.ippado.base.IppadoBaseController;
import egovframework.ippado.sys.author.service.AuthorManageService;
import egovframework.ippado.sys.author.service.AuthorManageVO;
import egovframework.ippado.sys.user.service.UserAuthor;
import egovframework.ippado.sys.user.service.UserAuthorService;
import egovframework.ippado.sys.user.service.UserAuthorVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

/**
 * 권한그룹에 관한 controller 클래스를 정의한다.
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이문준          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *
 * </pre>
 */

@Controller
public class UserAuthorController extends IppadoBaseController {
	
    @Resource(name = "userAuthorService")
    private UserAuthorService userAuthorService;
    
    @Resource(name = "authorManageService")
    private AuthorManageService authorManageService;
    
    /**
	 * 권한 목록화면 이동
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping("/sys/user/UserAuthorListView.do")
    public String selectAuthorGroupListView() throws Exception {

        return "/sys/user/UserAuthorManage";
    }    

	/**
	 * 그룹별 할당된 권한 목록 조회
	 * @param userAuthorVO UserAuthorVO
	 * @param authorManageVO AuthorManageVO
	 * @return String
	 * @exception Exception
	 */
    @RequestMapping(value="/sys/user/UserAuthorList.do")
	public String selectAuthorGroupList(@ModelAttribute("userAuthorVO") UserAuthorVO userAuthorVO,
			                            @ModelAttribute("authorManageVO") AuthorManageVO authorManageVO,
			                             ModelMap model) throws Exception {

		// 미인증 사용자에 대한 보안처리
		if (!EgovUserDetailsHelper.isAuthenticated())
			return goLogin(model);

		userAuthorVO.setAuthorGroupList(userAuthorService.selectAuthorGroupList(userAuthorVO));
        model.addAttribute("userAuthorList", userAuthorVO.getAuthorGroupList());
        
        setPageInfo(userAuthorVO, model, userAuthorService.selectAuthorGroupListTotCnt(userAuthorVO));
    	
    	authorManageVO.setAuthorManageList(authorManageService.selectAuthorAllList(authorManageVO));
        model.addAttribute("authorManageList", authorManageVO.getAuthorManageList());

        model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));
        
        return "/sys/user/UserAuthorManage";
	}

	/**
	 * 그룹에 권한정보를 할당하여 데이터베이스에 등록
	 * @param userIds String
	 * @param authorCodes String
	 * @param regYns String
	 * @param userAuthor UserAuthor
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value="/sys/user/UserAuthorInsert.do")
	public String insertAuthorGroup(@RequestParam("userIds") String userIds,
			                        @RequestParam("authorCodes") String authorCodes,
			                        @RequestParam("regYns") String regYns,
			                        @RequestParam("mberTyCodes") String mberTyCode,
			                        @ModelAttribute("userAuthor") UserAuthor userAuthor,
			                         SessionStatus status,
			                         ModelMap model) throws Exception {
		
    	String [] strUserIds = userIds.split(";");
    	String [] strAuthorCodes = authorCodes.split(";");
    	String [] strRegYns = regYns.split(";");
    	String [] strMberTyCode = mberTyCode.split(";");
    	
    	for(int i=0; i<strUserIds.length;i++) {
    		userAuthor.setUniqId(strUserIds[i]);
    		userAuthor.setAuthorCode(strAuthorCodes[i]);
    		userAuthor.setMberTyCode(strMberTyCode[i]);
    		if(strRegYns[i].equals("N"))
    		    userAuthorService.insertAuthorGroup(userAuthor);
    		else 
    		    userAuthorService.updateAuthorGroup(userAuthor);
    	}

        status.setComplete();
        model.addAttribute("message", egovMessageSource.getMessage("success.common.insert"));		
		return "forward:/sys/user/UserAuthorList.do";
	}

	/**
	 * 그룹별 할당된 시스템 메뉴 접근권한을 삭제
	 * @param userIds String
	 * @param userAuthor UserAuthor
	 * @return String
	 * @exception Exception
	 */ 
	@RequestMapping(value="/sys/user/UserAuthorDelete.do")
	public String deleteAuthorGroup(@RequestParam("userIds") String userIds,
                                    @ModelAttribute("userAuthor") UserAuthor userAuthor,
                                     SessionStatus status,
                                     ModelMap model) throws Exception {
		
    	String [] strUserIds = userIds.split(";");
    	for(int i=0; i<strUserIds.length;i++) {
    		userAuthor.setUniqId(strUserIds[i]);
    		userAuthorService.deleteAuthorGroup(userAuthor);
    	}
    	
		status.setComplete();
		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		return "forward:/sys/user/UserAuthorList.do";
	}



}