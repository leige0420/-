/**
 * Copyright (C), 2019-2019, 金科教育
 * FileName: TheClassController
 * Author:   Administrator
 * Date:     2019/10/25 14:15
 * Description: TheClassController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.roncoo.controller.zwb;

import com.roncoo.education.ketang.common.model.Course;
import com.roncoo.education.ketang.common.model.Liveclass;
import com.roncoo.education.ketang.common.model.Theclass;
import com.roncoo.education.ketang.common.service.LiveServiceApi;
import com.roncoo.education.ketang.common.service.TheClassServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈TheClassController〉
 *
 * @author Administrator
 * @create 2019/10/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("theclass")
public class BoosTheClassController {

    @Autowired
    private TheClassServiceApi theClassServiceApi;



    @RequestMapping("queryclass")
    @ResponseBody
    public List<Theclass> queryclass() {
        return theClassServiceApi.queryclass();
    }

    @RequestMapping("queryclasshuishou")
    @ResponseBody
    public List<Theclass> queryclasshuishou() {
        return theClassServiceApi.queryclasshuishou();
    }

    @RequestMapping("updatehuishou")
    @ResponseBody
    public void updatehuishou(Integer id) {
        theClassServiceApi.updatehuishou(id);
    }

    @RequestMapping("huifu")
    @ResponseBody
    public void huifu(Integer id) {
        theClassServiceApi.huifu(id);
    }

    @RequestMapping("delclass")
    @ResponseBody
    public void delclass(Integer id) {
        theClassServiceApi.delclass(id);
    }

    @RequestMapping("queryclasslist")
    @ResponseBody
    public List<Theclass> queryclasslist() {
        return theClassServiceApi.queryclasslist();
    }

    @RequestMapping("classxiangqingye")
    public String livexiangqingye(Integer id, Model model){
        Theclass theclass=theClassServiceApi.classxiangqingye(id);
        model.addAttribute("list",theclass);
        return "theclass/classxiangqingye";
    }


}
