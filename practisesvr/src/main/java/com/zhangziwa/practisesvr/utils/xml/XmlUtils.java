package com.zhangziwa.practisesvr.utils.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
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

    /**
     * 将XML字符串转换为指定类型的Java对象
     * @param xmlStr XML字符串
     * @param clazz 对象的类型
     * @param <T> 对象类型
     * @return 转换后得到的对象
     * @throws RuntimeException 如果转换失败，则抛出运行时异常
     */
    public static <T> T xmlToBean(String xmlStr, Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            // 将JAXBException转换为更具体的异常类型，或者添加堆栈跟踪信息。
            // 这里可以包装成一个具体的XML解析异常，例如XMLParsingException，并添加错误信息和原始异常。
            throw new RuntimeException("XML parsing failed for class: " + clazz.getName(), e);
        }
    }

    /**
     * 将Java对象转换为XML字符串
     * @param bean 要转换的Java对象
     * @return 转换后的XML字符串
     * @throws JAXBException 当转换发生错误时抛出该异常
     */
    public static String beanToXml(Object bean) {
        try {
            JAXBContext context = JAXBContext.newInstance(bean.getClass());
            Marshaller marshaller = context.createMarshaller();

            // 这意味着在生成的XML中不会包含XML声明（如<?xml version="1.0" encoding="UTF-8"?>）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(bean, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
