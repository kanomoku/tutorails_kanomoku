package designPattern.designPatterns23_VisitorDesignPattern;

public interface A1_ItemElement {
	// 元素 别的没要求 接收访问者来处理自身
	public int accept(A4_ShoppingCartVisitor visitor);
}

