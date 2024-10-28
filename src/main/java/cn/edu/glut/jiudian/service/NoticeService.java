package cn.edu.glut.jiudian.service;


import cn.edu.glut.jiudian.entity.Notice;
import org.aspectj.weaver.ast.Not;

import java.util.List;

/**
 * @author stone(huangshizhang) at 2019-06-09 23:00
 */
public interface NoticeService {

     List<Notice> selectAll();

     boolean deleteNoticeByPrimaryKey(Integer serNum);

     boolean insertNotice(Notice notice);

     Notice selectNoticeByPrimary(Integer serNum);

     boolean updateNoticeByPrimary(Notice notice);
}
