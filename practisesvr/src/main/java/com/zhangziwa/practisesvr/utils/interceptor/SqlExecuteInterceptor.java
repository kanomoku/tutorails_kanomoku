package com.zhangziwa.practisesvr.utils.interceptor;

import com.zhangziwa.practisesvr.utils.log.LogContext;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import java.sql.Statement;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})})
@Component
public class SqlExecuteInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("***SqlExecuteInterceptor.intercept***");

        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long executionCost = System.currentTimeMillis() - startTime;
            LogContext.incrementSqlCount();
            LogContext.incrementSqlCost(executionCost);
        }
    }
}
