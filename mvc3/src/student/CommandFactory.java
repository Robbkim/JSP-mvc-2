package student;

public class CommandFactory {
	private CommandFactory() {} //default 생성자만 만들고, default 생성자의 접근제한자는 private이다
	private static CommandFactory instance = new CommandFactory();
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if(cmd.equals("insert")) {
			cmdIf = new InsertCommand();
			
		}else if(cmd.equals("delete")) {
			cmdIf = new DeleteCommand();
			
		}else if(cmd.equals("find")) {
			cmdIf = new FindCommand();
			
		}else if(cmd.equals("list")) {
			cmdIf = new ListCommand();
			
		}else if(cmd.equals("start")) {
			cmdIf = new StartCommand();
		}
		return cmdIf;
		
}
}