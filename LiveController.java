/**
 * Copyright (C), 2019-2019, 金科教育
 * FileName: LiveController
 * Author:   Administrator
 * Date:     2019/10/24 16:07
 * Description: LiveController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.roncoo.controller.zwb;


import com.roncoo.education.ketang.common.model.Course;
import com.roncoo.education.ketang.common.model.Liveclass;


import com.roncoo.education.ketang.common.service.LiveServiceApi;
import com.roncoo.service.LiveService;
import com.roncoo.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈LiveController〉
 *
 * @author Administrator
 * @create 2019/10/24
 * @since 1.0.0
 */
@Controller
@RequestMapping("live")
public class LiveController {

    @Autowired
    private LiveServiceApi liveServiceApi;


    @RequestMapping("livexiangqingye")
    public String livexiangqingye(Integer id, Model model){
        Liveclass liveclass=liveServiceApi.livexiangqingye(id);
        model.addAttribute("list",liveclass);
        return "liveclass/livexiangqingye";
    }
    @RequestMapping("querylivelist")
    @ResponseBody
    public List<Liveclass> querylivelist() {
        return liveServiceApi.querylivelist();
    }


    @RequestMapping("/addlive")

    public String  addlive(Liveclass liveclass) {
        liveServiceApi.addlive(liveclass);
        return "redirect:liveyishen";
    }
    @RequestMapping("liveyishen")
    public String getliveyishen(){
        return "liveclass/liveyishen";
    }

    @RequestMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(MultipartFile file) {
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        try {
            String url = "https://sf-1134-1300168057.cos.ap-chengdu.myqcloud.com/"+ fileUploadUtil.uploadFile2Cos(file);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}
