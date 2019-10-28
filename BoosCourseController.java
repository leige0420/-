/**
 * Copyright (C), 2019-2019, 金科教育
 * FileName: CourseController
 * Author:   Administrator
 * Date:     2019/10/16 15:13
 * Description: CourseController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.roncoo.controller.zwb;


import com.roncoo.education.ketang.common.model.*;
import com.roncoo.service.CourseService;
import com.roncoo.util.ExportExcel;
import com.roncoo.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;

/*import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈CourseController〉
 *
 * @author Administrator
 * @create 2019/10/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("classname")
public class BoosCourseController {

    @Autowired
    private CourseService userService;



    @RequestMapping("course")
    @ResponseBody
    public List<Course> CourseList(Course course, Model model) {
        List<Course> list = userService.CourseList(course);
        return list;
    }

    @RequestMapping("/huishoucourse")
    @ResponseBody
    public List<Course> huishoucourse(Model model) {
        List<Course> list = userService.huishoucourse();


        return  list;
    }

    @RequestMapping("/updateavailable")
    @ResponseBody
    public void updateavailable(Integer id) {
        userService.updateavailable(id);

    }

    @RequestMapping("/jinyongavailable")
    @ResponseBody
    public void jinyongavailable(@RequestParam Integer id) {
        userService.jinyongavailable(id);

    }
    @RequestMapping("/xiajia")
    @ResponseBody
    public void xiajia(@RequestParam Integer id) {
        userService.xiajia(id);

    }
    @RequestMapping("/querykejianku")
    @ResponseBody
    public  List<Kejianku> querykejianku() {
        List<Kejianku> list = userService.querykejianku();


        return list;

    }
    @RequestMapping("/querypending")
    @ResponseBody
    public  List<Course> querypending() {
        List<Course> list = userService.querypending();

        return list;

    }
    @RequestMapping("/queryexam")
    @ResponseBody
    public  List<Exam> queryexam() {
        List<Exam> list = userService.queryexam();

        return list;

    }
    @RequestMapping("/queryvideo")
    @ResponseBody
    public  List<Video> queryvideo() {
        List<Video> list = userService.queryvideo();

        return list;

    }
    @RequestMapping("/addcourse")

    public String addcourse(Course course) {
        userService.addcourse(course);
        return "redirect:Ondemand";
    }
    @RequestMapping("Ondemand")
    public String getOndemand(){
        return "ondemandclass/Ondemand";
    }
    @RequestMapping("/queryctype")
    @ResponseBody
    public List<Coursecategory> queryctype() {
        List<Coursecategory>list= userService.queryctype();
        return list;
    }
    @RequestMapping("/queryjigou")
    @ResponseBody
    public List<Affiliation> queryjigou() {
        List<Affiliation>list= userService.queryjigou();
        return list;
    }

    @RequestMapping("/queryjiangshi")
    @ResponseBody
    public List<Affiliation> queryjiangshi(Integer pid) {
        List<Affiliation>list= userService.queryjiangshi(pid);
        return list;
    }
    @RequestMapping("xiangqingye")
    public String xiangqingye(Integer id,Model model){
        Course course=userService.xiangqingye(id);
        model.addAttribute("list",course);
        return "ondemandclass/xiangqingye";
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
    @RequestMapping("exportExcel")

    public void exportExcel(Course course, HttpServletResponse response){
        //导出的excel的标题
        String title = "已审";
        //导出excel的列名
        String[] rowName = {"id","课程名称","课程封面","市场价","销售价","教师名称","URL","课程评分","学习人数","学习人数(营销)","是否免费","是否营销","下架时间"};
        //导出的excel数据
        List<Object[]>  dataList = new ArrayList<Object[]>();
        //查询的数据库的书籍信息
        List<Course> list=   userService.CourseList(course);
        //循环书籍信息

        for(Course course1:list){
            Object[] obj =new Object[rowName.length];
            obj[0]=course1.getId();
            obj[1]=course1.getCoursename();
            obj[2]=course1.getCoursesimg();
            obj[3]=course1.getMarketprice();
            obj[4]=course1.getSaleprice();
            obj[5]=course1.getTeacherid();
            obj[6]=course1.getUserid();
            obj[7]=course1.getCoursegrade();
            obj[8]=course1.getLearningcount();
            obj[9]=course1.getLearningcountmarketing();
            obj[10]=course1.getWhetherfree();
            obj[11]=course1.getIsaudit();
            obj[12]=course1.getCreationtime();
            dataList.add(obj);
        }
        ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
