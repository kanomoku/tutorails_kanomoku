package designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory.basic;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;

public interface IGroup {
    ITutor createTutor();
    ITeacher createTeacher();
}
