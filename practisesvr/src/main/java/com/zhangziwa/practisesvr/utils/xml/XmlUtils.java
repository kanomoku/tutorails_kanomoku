package com.zhangziwa.practisesvr.utils.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.List;

public class XmlUtils {
    /**
     * 增加防止部实体注入逻辑
     */
    public static void setReaderFeature(SAXReader reader) throws SAXException {
        // 禁用DTD
        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        // 禁用外部DTD
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        // 禁用外部一般实体解析
        reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
        // 禁用参数实体解析
        reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        // 禁用限制实体解析次数
        reader.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
    }

    public static void main(String[] args) {
        try {
            // 创建SAXReader
            SAXReader reader = new SAXReader();

            // 做安全防护
            setReaderFeature(reader);

            //从xml文件获取数据
            Document document = reader.read(new File("D:\\projects\\tutorails_kanomoku\\practisesvr\\src\\main\\java\\com\\zhangziwa\\practisesvr\\utils\\xml\\test.xml"));

            // 获取根节点 tests
            Element root = document.getRootElement();
            // 查找指定节点名称的所有子节点elements
            List<Element> elements = root.elements("test");

            for (Element element : elements) {
                System.out.println("element.getName()==>" + element.getName());

                List<Element> testElements = element.elements();

                for (Element e : testElements) {  //遍历emp元素下的子元素
                    System.out.print(e.getName() + ":");  //获取子元素名称
                    System.out.print(e.getText() + " ");  //获取子元素的文本值
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
