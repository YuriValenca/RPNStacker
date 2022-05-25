package RPNStackerPostfix.ast;

import java.util.Stack;

import RPNStackerPostfix.ast.Expr.Id;
import RPNStackerPostfix.ast.Expr.Binop;
import RPNStackerPostfix.ast.Expr.Number;

public class AstPrinter implements Expr.Visitor<String>{

	public String print(Expr expr) {
		return expr.accept(this);
	}
	@Override
	public String visitIdExpr(Id expr) {
		return expr.id.toString();
	}

	@Override
	public String visitNumberExpr(Number expr) {
		return expr.value.toString();
	}

	@Override
	public String visitBinopExpr(Binop expr) {
		return parenthesizePreOrder(expr.operator.lexeme,
				expr.left, expr.right);
	}

	private String parenthesizePreOrder(String name, Expr... exprs) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("(").append(name);
		for (Expr expr : exprs) {
			buffer.append(" ");
			buffer.append(expr.accept(this));
		}
		buffer.append(")");

		return buffer.toString();
	}

}
