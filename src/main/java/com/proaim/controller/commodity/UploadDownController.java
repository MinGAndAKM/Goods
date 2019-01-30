package com.proaim.controller.commodity;

import com.proaim.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 封装了文件上传和下载的控制层
 *
 * @date 2019/1/25
 */
@Slf4j
@RestController
public class UploadDownController {
    /**
     * 文件上传
     *
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        // 获取文件在服务器的储存位置（绝对路径）
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        log.info("文件保存的路径：" + filePath);
        if (!(filePath.exists() && filePath.isDirectory())) {
            log.info("目录不存在，创建目录:" + filePath);
            filePath.mkdirs();
        }

        // 获取原始文件名称(包含格式)
        String oldFileName = picture.getOriginalFilename();
        log.info("文件原始名称：" + oldFileName);

        // 获取文件类型，以最后一个“ . ”为标识
        // String fileType = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);

        // 获取文件名称（不包含格式）
        // String fileName = oldFileName.substring(0, oldFileName.lastIndexOf("."));

        // 获取上传图片的扩展名(jpg/png/...)
        // pom.xml需导入commons-io
        String extension = FilenameUtils.getExtension(oldFileName);

        // 获取文件路径去除目录和后缀之后的文件名
        String baseFileName = FilenameUtils.getBaseName(oldFileName);

        // 设置文件新名称: 当前时间+文件名称（不包含格式）
        Date nowDateTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = dateFormat.format(nowDateTime);
        /*String newFileName = date + fileName + "." + fileType;*/
        String newFileName = date + baseFileName + "." + extension;
        log.info("文件新名称：" + newFileName);

        // 在指定路径下创建一个文件
        File targetFile = new File(path, newFileName);

        // 将文件保存到服务器指定位置，相对路径放到页面上就可以显示图片
        try {
            picture.transferTo(targetFile);
            log.info("上传成功");
            return new Result(true, "/upload/" + newFileName);
        } catch (IOException e) {
            log.info("上传失败");
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }
}
