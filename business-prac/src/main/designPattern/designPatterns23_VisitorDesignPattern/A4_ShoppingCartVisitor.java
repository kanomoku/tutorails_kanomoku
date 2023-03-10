package designPattern.designPatterns23_VisitorDesignPattern;

public interface A4_ShoppingCartVisitor {
	// 访问者可以访问 元素类型
	int visit(A2_Book book);
	int visit(A3_Fruit fruit);
}
