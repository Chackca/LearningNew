package 设计模式.大话设计模式.expression;

//包含解释器之外的一些全局信息
public class Context {
    private String input;
    private String output;
    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
}
