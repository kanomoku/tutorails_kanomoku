package com.zhangziwa.practisesvr.utils.pagehelper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhangziwa.practisesvr.utils.response.ResponseContext;

import java.util.ArrayList;
import java.util.List;

public class PageHeaderUtils {
    private static final String PAGE_NUM = "page_num"; // 当前第几页
    private static final String PAGE_SIZE = "page_size"; // 每页显示的条数
    private static final String PREV_PAGE = "prev_page"; // 上一页页码
    private static final String NEXT_PAGE = "next_page"; // 下一页页码
    private static final String TOTAL_COUNT = "total_count"; // 总条数
    private static final String TOTAL_PAGE = "total_page"; // 总页数

    public static <E> void setPageHeader(Page<E> page) {
        if (page == null) {
            return;
        }
        ResponseContext.addHeaders(PAGE_NUM, String.valueOf(page.getPageNum()));
        ResponseContext.addHeaders(PAGE_SIZE, String.valueOf(page.getPageSize()));
        ResponseContext.addHeaders(TOTAL_COUNT, String.valueOf(page.getTotal()));
        ResponseContext.addHeaders(TOTAL_PAGE, String.valueOf(page.getPages() == 0 ? 1 : page.getPages()));
        if (page.getPages() == 0 || page.getPages() == 1) {
            ResponseContext.addHeaders(PREV_PAGE, "");
            ResponseContext.addHeaders(NEXT_PAGE, "");
        } else if (page.getPageNum() == 1) {
            ResponseContext.addHeaders(PREV_PAGE, "");
            ResponseContext.addHeaders(NEXT_PAGE, String.valueOf(page.getPageNum() + 1));
        } else if (page.getPageNum() == page.getPages()) {
            ResponseContext.addHeaders(PREV_PAGE, String.valueOf(page.getPageNum() - 1));
            ResponseContext.addHeaders(NEXT_PAGE, "");
        } else {
            ResponseContext.addHeaders(PREV_PAGE, String.valueOf(page.getPageNum() - 1));
            ResponseContext.addHeaders(NEXT_PAGE, String.valueOf(page.getPageNum() + 1));
        }
    }

    /**
     * 设置分页头信息
     *
     * @param page 分页对象
     * @param <E>  分页对象的数据类型
     */
    public static <E> void setPageHeader(PageInfo<E> page) {
        if (page == null) {
            return;
        }
        ResponseContext.addHeaders(PAGE_NUM, String.valueOf(page.getPageNum()));  // 设置当前页码
        ResponseContext.addHeaders(PAGE_SIZE, String.valueOf(page.getPageSize()));  // 设置每页显示数量
        ResponseContext.addHeaders(TOTAL_COUNT, String.valueOf(page.getTotal()));  // 设置总记录数
        ResponseContext.addHeaders(TOTAL_PAGE, String.valueOf(page.getPages() == 0 ? 1 : page.getPages()));  // 设置总页数
        // page.getPages()=1表示就1页,前后页都不存在,故也算特殊场景.也为了page.getPages()+1和page.getPages()-1不会对[1,page.getPages()]越界
        if (page.getPages() == 0 || page.getPages() == 1) {
            ResponseContext.addHeaders(PREV_PAGE, "");  // 上一页
            ResponseContext.addHeaders(NEXT_PAGE, "");  // 下一页
        } else if (page.getPageNum() == 1) {
            ResponseContext.addHeaders(PREV_PAGE, "");  // 上一页
            ResponseContext.addHeaders(NEXT_PAGE, String.valueOf(page.getPageNum() + 1));  // 下一页
        } else if (page.getPageNum() == page.getPages()) {
            ResponseContext.addHeaders(PREV_PAGE, String.valueOf(page.getPageNum() - 1));  // 上一页
            ResponseContext.addHeaders(NEXT_PAGE, "");  // 下一页
        } else {
            ResponseContext.addHeaders(PREV_PAGE, String.valueOf(page.getPageNum() - 1));  // 上一页
            ResponseContext.addHeaders(NEXT_PAGE, String.valueOf(page.getPageNum() + 1));  // 下一页
        }
    }

    // 数据聚合场景下的手工分页
    // 也适合EmptyList场景 Page{count=true, pageNum=1, pageSize=10, startRow=0, endRow=0, total=0, pages=0, reasonable=null, pageSizeZero=null}
    public static <E> Page<E> manualPage(List<E> res, Integer pageNum, Integer pageSize) {
        if (res == null) {
            res = new ArrayList<>();
        }

        int pageNumber = PageUtils.getPageNum(pageNum);
        int sizePerPage = PageUtils.getPageSize(pageSize);
        int totalSize = res.size();

        List<E> pageElements = res.stream().skip((long) (pageNumber - 1) * sizePerPage).limit(sizePerPage).toList(); // 分页

        Page<E> page = new Page<>();
        page.setPageNum(pageNumber);
        page.setPageSize(sizePerPage);
        page.setTotal(totalSize);
        page.setPages((totalSize / pageSize + ((totalSize % pageSize == 0) ? 0 : 1)));
        page.addAll(pageElements);

        return page;
    }
}