package com.zhangziwa.practisesvr.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PageUtils {
    private static int defaultPageNumber; // 默认显示第几页
    private static int defaultPageSize; // 默认每页显示多少条数据
    private static int maxSizePage; // 每页显示条数上限
    private static boolean isQueryTotalCount; // 每次查询DB时,是否进行count查询

    @Value("${page-helper.default-page-num:1}")
    private int pageNumberFromConfig;
    @Value("${page-helper.default-page-size:10}")
    private int pageSizeFromConfig;
    @Value("${page-helper.max-page-size:15}")
    private int maxSizePerPageFromConfig;
    @Value("${page-helper.count-total-or-not:true}")
    private boolean isQueryTotalFromConfig;

    @PostConstruct
    private void init() {
        defaultPageNumber = pageNumberFromConfig;
        defaultPageSize = pageSizeFromConfig;
        maxSizePage = maxSizePerPageFromConfig;
        isQueryTotalCount = isQueryTotalFromConfig;
    }

    public static int getPageNum(Integer pageNum) {
        if (Objects.isNull(pageNum) || pageNum <= 0) {
            return defaultPageNumber;
        } else {
            return pageNum;
        }
    }

    public static int getPageSize(Integer pageSize) {
        if (Objects.isNull(pageSize) || pageSize <= 0) {
            return defaultPageSize;
        } else if (pageSize > 100) {
            return maxSizePage;
        } else {
            return pageSize;
        }
    }

    public static boolean isQueryTotalCount() {
        return isQueryTotalCount;
    }

}
