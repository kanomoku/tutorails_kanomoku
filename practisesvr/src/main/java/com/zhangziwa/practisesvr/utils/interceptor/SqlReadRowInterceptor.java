package com.zhangziwa.practisesvr.utils.interceptor;

import com.zhangziwa.practisesvr.utils.log.LogContext;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.Collection;

@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
@Component
public class SqlReadRowInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("***SqlReadRowInterceptor.intercept***");

        Object proceed = invocation.proceed();
        if (proceed instanceof Collection) {
            LogContext.incrementSqlSearchedRowCount(((Collection<?>) proceed).size());
        } else {
            LogContext.incrementSqlSearchedRowCount(0);
        }
        return proceed;
    }
}
