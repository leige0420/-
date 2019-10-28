/**
 * Copyright (C), 2019-2019, 金科教育
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/10/17 20:59
 * Description: HelloController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.roncoo.controller.zwb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈HelloController〉
 *
 * @author Administrator
 * @create 2019/10/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("go")
public class HelloController {
    @RequestMapping("huishou")
    public String gethuishou(){
        return "ondemandclass/huishou";
    }
    @RequestMapping("Ondemand")
    public String getOndemand(){
        return "ondemandclass/Ondemand";
    }
    @RequestMapping("kejianku")
    public String getkejianku(){
        return "ondemandclass/kejianku";
    }
    @RequestMapping("pending")
    public String getpending(){
        return "ondemandclass/pending";
    }
    @RequestMapping("videolibrary")
    public String getvideolibrary(){
        return "ondemandclass/videolibrary";
    }
    @RequestMapping("ccvideolibrary")
    public String getccvideolibrary(){
        return "ondemandclass/ccvideolibrary";
    }
    @RequestMapping("daochu")
    public String getdaochu(){
        return "ondemandclass/daochu";
    }
    @RequestMapping("addcourse")
    public String getaddcourse(){
        return "ondemandclass/addcourse";
    }
    @RequestMapping("ondemandzhanshi")
    public String getondemandzhanshi(){
        return "ondemandclass/ondemandzhanshi";
    }


    @RequestMapping("liveyishen")
    public String getliveyishen(){
        return "liveclass/liveyishen";
    }
    @RequestMapping("livedaishen")
    public String getlivedaishen(){
        return "liveclass/livedaishen";
    }
    @RequestMapping("livehuishou")
    public String getlivehuishou(){
        return "liveclass/livehuishou";
    }
    @RequestMapping("liveadd")
    public String getliveadd(){
        return "liveclass/liveadd";
    }
    @RequestMapping("livedaochu")
    public String getlivedaochu(){
        return "liveclass/livedaochu";
    }
    @RequestMapping("livezhanshi")
    public String getliveclass(){
        return "liveclass/livezhanshi";
    }


    @RequestMapping("classlist")
    public String getclasslist(){
        return "theclass/classlist";
    }
    @RequestMapping("classadd")
    public String getclassadd(){
        return "theclass/classadd";
    }
    @RequestMapping("classhuishou")
    public String getclasshuishou(){
        return "theclass/classhuishou";
    }
    @RequestMapping("classdaochu")
    public String getclassdaochu(){
        return "theclass/classdaochu";
    }
    @RequestMapping("classzhanshi")
    public String getclasszhanshi(){
        return "theclass/classzhanshi";
    }


    @RequestMapping("linedaishen")
    public String getlinedaishen(){
        return "lineclass/linedaishen";
    }
    @RequestMapping("lineyishen")
    public String getlineyishen(){
        return "lineclass/lineyishen";
    }
    @RequestMapping("linehuishou")
    public String getlinehuishou(){
        return "lineclass/linehuishou";
    }
    @RequestMapping("lineadd")
    public String getlineadd(){
        return "lineclass/lineadd";
    }
    @RequestMapping("linedaochu")
    public String getlinedaochu(){
        return "lineclass/linedaochu";
    }
    @RequestMapping("linezhanshi")
    public String getlinezhanshi(){
        return "lineclass/linezhanshi";
    }
}
