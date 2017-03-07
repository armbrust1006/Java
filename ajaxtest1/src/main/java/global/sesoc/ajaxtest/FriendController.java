package global.sesoc.ajaxtest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.ajaxtest.repository.HomeRepository;
import global.sesoc.ajaxtest.vo.Friend;

@Controller
public class FriendController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private HomeRepository hr;

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody Friend ajaxtest(Friend friend) {
		logger.info(friend.toString());

		if (hr.insert(friend) != 0) {
			return friend;
		} else {
			return null;
		}
		// return friend; // home.jsp가 아니라 home이라는 값으로 인식 및 데이터를 넘김
	}

	@RequestMapping(value = "/ajaxtest2", method = RequestMethod.POST)
	public @ResponseBody Friend ajaxtest2() {
		return new Friend("Yu", "1234", "Abc");
	}
	
	@RequestMapping(value = "/ajaxtest3", method = RequestMethod.POST)
	public @ResponseBody List<Friend> ajaxtest3() {
		List<Friend> list = new ArrayList<>();
		list.add(new Friend("Yu", "123", "Abc"));
		list.add(new Friend("Kim", "456", "Def"));
		list.add(new Friend("Park", "789", "Ghi"));
		list.add(new Friend("Choi", "741", "Jkl"));
		return list;
	}
}
