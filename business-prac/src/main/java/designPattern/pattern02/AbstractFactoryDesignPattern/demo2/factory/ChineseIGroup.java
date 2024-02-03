package designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory;

import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.ChineseTutor;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.bean.basic.ITutor;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ChineseTeacher;
import com.zhangziwa.practisesvr.model.builder.FactoryMethodPattern.bean.ITeacher;
import designPattern.pattern02.AbstractFactoryDesignPattern.demo2.factory.basic.IGroup;

public class ChineseIGroup implements IGroup {

    @Override
    public ITutor createTutor() {
        ChineseTutor chineseTutor = new ChineseTutor();
        chineseTutor.build();
        return chineseTutor;
    }

    @Override
    public ITeacher createTeacher() {
        ChineseTeacher chineseTeacher = new ChineseTeacher();
        chineseTeacher.build();
        return chineseTeacher;
    }
}
