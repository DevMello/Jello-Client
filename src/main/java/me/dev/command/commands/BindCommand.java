package me.dev.command.commands;

import java.util.ArrayList;
import java.util.List;

import com.mentalfrostbyte.jello.main.Jello;
import com.mentalfrostbyte.jello.main.Module;
import com.mentalfrostbyte.jello.tabgui.TabGUI;
import me.dev.command.Command;
import me.dev.util.KeyUtils;


public class BindCommand extends Command {

	public BindCommand() {
		super("bind", "bind <module> <key>", "Bind a module to a key");
	}

	@Override
	public String executeCommand(String line, String[] args) {
		if (args.length < 2)
			return getSyntax("&c");


		Jello module = new Jello();
		String name = String.valueOf(Jello.getModule(args[0]));
		Module cat = new Module();
		cat.getCategory();

		if (module == null)
			return String.format("&cThe module &e%1$s&c does not exist.", args[0]);

		int key = KeyUtils.getKey(args[1]);

		List<Module> boundModules = new ArrayList<Module>(Jello.getModules(key));
		boundModules.forEach(mod -> mod.setKeyCode(0));

		cat.setKeyCode(key);

		return String.format("&aThe module &e%1$s&a has been bound to &d%2$s", cat.getDisplayName(), KeyUtils.getKeyName(key));
	}

}