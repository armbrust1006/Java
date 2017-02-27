package global.sesoc.sebank.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import global.sesoc.sebank.repository.BoardRepository;
import global.sesoc.sebank.repository.ReplyRepository;
import global.sesoc.sebank.util.FileService;
import global.sesoc.sebank.util.PageNavigator;
import global.sesoc.sebank.vo.Board;

@Controller
@RequestMapping("board")
@SessionAttributes("customer")
public class BoardController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardRepository br;
	@Autowired
	private ReplyRepository rr;

	private final int COUNT_PER_PAGE = 10;
	private final int PAGE_PER_GROUP = 5;
	private final String UP_LOAD_PATH = "/boardfile";

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String list(@RequestParam(value = "searchTitle", defaultValue = "") String searchTitle,
			@RequestParam(value = "searchText", defaultValue = "") String searchText,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "errorMsg", defaultValue = "") String errorMsg, Model model) {

		Map<String, Object> search = new HashMap<>();
		search.put("searchTitle", searchTitle);
		search.put("searchText", searchText);
		System.out.println(errorMsg);

		int total = br.getCount(search);
		PageNavigator navi = new PageNavigator(COUNT_PER_PAGE, PAGE_PER_GROUP, page, total);

		int start = navi.getStartRecord();
		int end = start + COUNT_PER_PAGE;
		search.put("start", start);
		search.put("end", end);

		List<Board> listBoard = br.listBoard(search);

		model.addAttribute("navi", navi);
		model.addAttribute("listBoard", listBoard);

		if (!errorMsg.equals("")) {
			model.addAttribute("errorMsg", errorMsg);
		}

		return "board/boardList";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String write() {
		return "board/boardWrite";
	}

	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String write(Board board, MultipartFile upload, RedirectAttributes redirectAttributes) {
		// 첨부 파일 처리
		if (!upload.isEmpty()) {
			String saveFileName = FileService.saveFile(upload, UP_LOAD_PATH);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavedfile(saveFileName);
		}
		if (br.insertBoard(board) == 1) {
			redirectAttributes.addAttribute("errorMsg", "등록 성공!");
		}
		return "redirect:boardList";
	}

	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public String read(int boardnum, HttpSession session, Model model) {
		model.addAttribute("customer", session.getAttribute("loginId"));
		model.addAttribute("board", br.getBoard(boardnum));
		model.addAttribute("replyList", rr.replyList(boardnum));
		return "board/boardRead";
	}

	@RequestMapping(value = "/boardUpdate", method = RequestMethod.GET)
	public String update(int boardnum, @ModelAttribute("customer") String customer, HttpSession session, Model model) {
		if (session.getAttribute("loginId").equals(customer)) {
			model.addAttribute("board", br.getBoard(boardnum));
		}
		return "board/boardUpdate";
	}

	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String update(Board board, @ModelAttribute("customer") String customer, SessionStatus status,
			RedirectAttributes redirectAttributes) {
		if (board.getOriginalfile() != null) {
			board.setSavedfile(board.getOriginalfile());
		}
		if (br.updateBoard(board) != 0) {
			redirectAttributes.addAttribute("errorMsg", "수정 했습니다.");
		}
		status.setComplete();
		return "redirect:boardList";
	}

	@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
	public String delete(int boardnum) {
		Board board = br.getBoard(boardnum);
		FileService.deleteFile(UP_LOAD_PATH + "/" + board.getSavedfile());
		br.delelteBoard(boardnum);
		return "redirect:boardList";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(int boardnum, HttpServletResponse response) {

		Board board = br.boardDetail();
		String originalfile = board.getOriginalfile();

		// 한글로 된 파일의 경우 다운로드 불가능하므로 UTF-8로 인코딩을 해준다.
		// response 객체의 헤더를 조작함
		try {
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(originalfile, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String fullpath = UP_LOAD_PATH + "/" + board.getSavedfile();

		ServletOutputStream fileOut = null; // 유저에게 파일 전송
		FileInputStream fileIn = null; // 서버 하드에서 자료 갖고 오기

		try {
			fileIn = new FileInputStream(fullpath);
			fileOut = response.getOutputStream();

			FileCopyUtils.copy(fileIn, fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileIn != null)
					fileIn.close();
				if (fileOut != null)
					fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
