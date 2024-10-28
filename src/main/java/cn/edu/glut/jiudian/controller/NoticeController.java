package cn.edu.glut.jiudian.controller;

import cn.edu.glut.jiudian.entity.Comment;
import cn.edu.glut.jiudian.entity.Notice;
import cn.edu.glut.jiudian.entity.Room;
import cn.edu.glut.jiudian.entity.RoomType;
import cn.edu.glut.jiudian.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    private Notice notice;

    @RequestMapping("notice_management.html")
    public ModelAndView noticeManagement(){
        List<Notice> noticeList = noticeService.selectAll();
        ModelAndView mav = new ModelAndView("notice_management");
        mav.addObject("noticeList", noticeList);
        return mav;
    }

    @RequestMapping("deleteNotice")
    @ResponseBody
    public Object deleteComment(@RequestParam("serNum") Integer serNum){
        HashMap<String, String> res = new HashMap<>();
        if (noticeService.deleteNoticeByPrimaryKey(serNum)) {
            res.put("stateCode", "1");
        } else {
            res.put("stateCode", "0");
        }
        return res;
    }

    @RequestMapping("notice_add.html")
    public ModelAndView noticeAdd(){
        List<Notice> noticeList = noticeService.selectAll();
        ModelAndView mav = new ModelAndView("notice_add");
        // mav.addObject("noticeList", noticeList);
        return mav;
    }

    @RequestMapping("doNoticeAdd")
    @ResponseBody
    public Object doNoticeAdd(Notice notice){
        HashMap<String, String> res = new HashMap<>();
        notice.setReleaseTime(new java.sql.Date(new java.util.Date().getTime()));
        if (noticeService.insertNotice(notice)){
            res.put("stateCode", "1");
        } else {
            res.put("stateCode", "0");
        }
        return res;
    }

    @RequestMapping("doNoticeEdit")
    @ResponseBody
    public Object doNoticeEdit(Notice notice){
        HashMap<String, String> res = new HashMap<>();
        notice.setReleaseTime(new java.sql.Date(new java.util.Date().getTime()));
        if (noticeService.updateNoticeByPrimary(notice)) {
            res.put("stateCode", "1");
        } else {
            res.put("stateCode", "0");
        }
        return res;
    }

    @RequestMapping("getEditNotice")
    @ResponseBody
    public Object getEditNotice(@RequestParam("serNum") Integer serNum){
        notice = noticeService.selectNoticeByPrimary(serNum);
        return true;
    }

    @RequestMapping("notice_edit.html")
    public ModelAndView editNotice(){
        ModelAndView mav = new ModelAndView("notice_edit");
        mav.addObject("notice", notice);
        return mav;
    }

}
