package com.zhangziwa.practisesvr.utils.pagehelper;

import com.github.pagehelper.PageInfo;
import com.zhangziwa.practisesvr.utils.response.ResponseUtils;

public class PageHeaderUtils {
    private static final String PAGE_NUM = "page_num"; // 当前第几页
    private static final String PAGE_SIZE = "page_size"; // 每页显示的条数
    private static final String PREV_PAGE = "prev_page"; // 上一页页码
    private static final String NEXT_PAGE = "next_page"; // 下一页页码
    private static final String TOTAL_COUNT = "total_count"; // 总条数
    private static final String TOTAL_PAGE = "total_page"; // 总页数

    public static <E> void setPageHeader(PageInfo<E> page) {
        if (page == null) {
            return;
        }
        ResponseUtils.addHeaders(PAGE_NUM, String.valueOf(page.getPageNum()));
        ResponseUtils.addHeaders(PAGE_SIZE, String.valueOf(page.getPageSize()));
        ResponseUtils.addHeaders(TOTAL_COUNT, String.valueOf(page.getTotal()));
        ResponseUtils.addHeaders(TOTAL_PAGE, String.valueOf(page.getPages() == 0 ? 1 : page.getPages()));
        // page.getPages()=1表示就1页,前后页都不存在,故也算特殊场景.也为了page.getPages()+1和page.getPages()-1不会对[1,page.getPages()]越界
        if (page.getPages() == 0 || page.getPages() == 1) {
            ResponseUtils.addHeaders(PREV_PAGE, "");
            ResponseUtils.addHeaders(NEXT_PAGE, "");
        } else if (page.getPageNum() == 1) {
            ResponseUtils.addHeaders(PREV_PAGE, "");
            ResponseUtils.addHeaders(NEXT_PAGE, String.valueOf(page.getPages() + 1));
        } else if (page.getPageNum() == page.getPages()) {
            ResponseUtils.addHeaders(PREV_PAGE, String.valueOf(page.getPages() - 1));
            ResponseUtils.addHeaders(NEXT_PAGE, "");
        } else {
            ResponseUtils.addHeaders(PREV_PAGE, String.valueOf(page.getPages() - 1));
            ResponseUtils.addHeaders(NEXT_PAGE, String.valueOf(page.getPages() + 1));
        }
    }
}