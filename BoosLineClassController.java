/**
 * Copyright (C), 2019-2019, 金科教育
 * FileName: BoosLineClassController
 * Author:   Administrator
 * Date:     2019/10/25 15:19
 * Description: BoosLineClassController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.roncoo.controller.zwb;

import com.roncoo.education.ketang.common.model.Lineclass;
import com.roncoo.education.ketang.common.model.Theclass;
import com.roncoo.education.ketang.common.service.LineClassApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈BoosLineClassController〉
 *
 * @author Administrator
 * @create 2019/10/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("line")
public class BoosLineClassController {

    @Autowired
    private LineClassApi lineClassApi;

    @RequestMapping("querylineclass")
    @ResponseBody
    public List<Lineclass> querylineclass() {
        return lineClassApi.querylineclass();
    }

    @RequestMapping("querylinelist")
    @ResponseBody
    public List<Lineclass> querylinelist() {
        return lineClassApi.querylinelist();
    }

    @RequestMapping("linexiangqingye")
    public String linexiangqingye(Integer id, Model model){
        Lineclass lineclass=lineClassApi.linexiangqingye(id);
        model.addAttribute("list",lineclass);
        return "lineclass/linexiangqingye";
    }
}
