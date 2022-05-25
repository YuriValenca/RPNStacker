package RPN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;
import java.util.StringTokenizer;

public class RPNStacker {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("src/Calc1.stk");
        String content = new String(Files.readAllBytes(path));
        StringTokenizer st = new StringTokenizer(content, "\r\n");
        Stack<String> stack = new Stack<>();

        while (st.hasMoreTokens()) {

            String token = st.nextToken();
            //Soma
            if (token.equals("+")) {

                String num1 = stack.pop();
                String num2 = stack.pop();

                //Verificação de número, se for letra ou operação não reconhecida, entra na exceção
                if (!num1.matches("[0-9]+(\\.[0-9]+)?")) {

                    throw new IllegalArgumentException("Error: Unexpected character: " + num1);

                } else {

                    if (!num2.matches("[0-9]+(\\.[0-9]+)?")){

                        throw new IllegalArgumentException("Error: Unexpected character: " + num2);

                    } else {

                        System.out.println(new Token(TokenType.NUM, num1));
                        System.out.println(new Token(TokenType.NUM, num2));
                        System.out.println(new Token(TokenType.PLUS, token));
                        stack.push(String.valueOf(Double.parseDouble(num1) + Double.parseDouble(num2))); //op

                    }
                }
                //Subtração
            } else if (token.equals("-")) {

                String num1 = stack.pop();
                String num2 = stack.pop();

                //Verificação de número, se for letra ou operação não reconhecida, entra na exceção
                if (!num1.matches("[0-9]+(\\.[0-9]+)?")){

                    throw new IllegalArgumentException("Error: Unexpected character: " + num1);

                } else {

                    if (!num2.matches("[0-9]+(\\.[0-9]+)?")){

                        throw new IllegalArgumentException("Error: Unexpected character: " + num2);

                    } else {

                        System.out.println(new Token(TokenType.NUM, num1));
                        System.out.println(new Token(TokenType.NUM, num2));
                        System.out.println(new Token(TokenType.MINUS, token));
                        stack.push(String.valueOf(Double.parseDouble(num1) - Double.parseDouble(num2))); //op

                    }
                }
                //Multiplicação
            } else if (token.equals("*")) {

                String num1 = stack.pop();
                String num2 = stack.pop();

                //Verificação de número, se for letra ou operação não reconhecida, entra na exceção
                if (!num1.matches("[0-9]+(\\.[0-9]+)?")){

                    throw new IllegalArgumentException("Error: Unexpected character: " + num1);

                } else {

                    if (!num2.matches("[0-9]+(\\.[0-9]+)?")){

                        throw new IllegalArgumentException("Error: Unexpected character: " + num2);

                    } else {

                        System.out.println(new Token(TokenType.NUM, num1));
                        System.out.println(new Token(TokenType.NUM, num2));
                        System.out.println(new Token(TokenType.STAR, token));
                        stack.push(String.valueOf(Double.parseDouble(num1) * Double.parseDouble(num2))); //op

                    }
                }
                //Divisão
            } else if (token.equals("/")) {

                String num1 = stack.pop();
                String num2 = stack.pop();

                //Verificação de número, se for letra ou operação não reconhecida, entra na exceção
                if (!num1.matches("[0-9]+(\\.[0-9]+)?")){

                    throw new IllegalArgumentException("Error: Unexpected character: " + num1);

                } else {

                    if (!num2.matches("[0-9]+(\\.[0-9]+)?")){

                        throw new IllegalArgumentException("Error: Unexpected character: " + num2);

                    } else {

                        System.out.println(new Token(TokenType.NUM, num1));
                        System.out.println(new Token(TokenType.NUM, num2));
                        System.out.println(new Token(TokenType.SLASH, token));
                        stack.push(String.valueOf(Double.parseDouble(num1) / Double.parseDouble(num2))); //op

                    }

                }

            } else {

                stack.push(token);

            }

        }

        System.out.println("Saida: " + stack.pop());

    }

}