package com.legendaryrealms.LegendaryGuild.Requirement.Sub;

import com.legendaryrealms.LegendaryGuild.Data.Guild.Guild;
import com.legendaryrealms.LegendaryGuild.Data.User.User;
import com.legendaryrealms.LegendaryGuild.Requirement.Requirement;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class GuildLevelRequirement extends Requirement {
    @Override
    public String getSymbol() {
        return "guild_level";
    }

    @Override
    public boolean canPass(Player p, String str) {
        String[] args = str.split(";");
        if (!legendaryGuild.checkIsNumber(args[1])){
            legendaryGuild.info("请输入正确的数字！ ->"+str, Level.SEVERE);
            return false;
        }
        User user = legendaryGuild.getUsersManager().getUser(p.getName());
        if (!user.hasGuild()){
            p.sendMessage(lang.plugin+lang.nothasguild);
            return false;
        }
        Guild guild = legendaryGuild.getGuildsManager().getGuild(user.getGuild());
        if (guild.getLevel() >= Double.parseDouble(args[1])){
            return true;
        }
        p.sendMessage(lang.plugin+lang.noenough_level.replace("%value%",args[1]));
        return false;
    }

    @Override
    public void deal(Player p, String str) {
    }
}
