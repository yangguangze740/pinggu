package com.zhulin.common.file;

import com.google.common.base.Strings;
import com.zhulin.common.md5.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileStoreUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStoreUtil.class);

    public static FileSaveResult saveSpringWebMultipartFile(String path, MultipartFile file) {
        String filename = file.getOriginalFilename();

        FileSaveResult result = new FileSaveResult();
        result.setOriginFileName(filename);
        result.setStorePath(path);

        if (!Strings.isNullOrEmpty(filename)) {
            // 保存文件
            filename = filename.replace("@", "_").replace(" ", "_").replace("&", "_").replace(";", "_");

            String subName = filename.substring(filename.lastIndexOf("."));

            String distFileName = Md5Util.getMD5String(filename + System.currentTimeMillis()) + subName;

            File targetFile = new File(path, distFileName);

            try {
                file.transferTo(targetFile);

                result.setDistFileName(distFileName);
            } catch (IOException e) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("[UTIL] -> com.zhulin.common.file.FileStoreUtil -> saveSpringWebMultipartFile save web file error with info {}", e.getMessage());
                }

                result.setDistFileName("");

                e.printStackTrace();
            }
        }

        return result;
    }
}
